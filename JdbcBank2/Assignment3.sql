--CREATE USER TABLE
CREATE TABLE USERS(
    USER_ID INTEGER PRIMARY KEY,
    USERNAME VARCHAR2(20) UNIQUE NOT NULL,
    USER_PASS VARCHAR2(25) NOT NULL,
    FIRST_NAME VARCHAR2(30),
    LAST_NAME VARCHAR2(30),
    IS_ADMIN VARCHAR2(1) --VALUE TO DIFFERENTAITE ADMIN
);

--BANK ACCOUNT TABLE
CREATE TABLE BANK_ACCOUNT(
    ACCOUNT_ID NUMBER PRIMARY KEY,
    BALANCE NUMBER NOT NULL,
    USER_ID NUMBER, --FOREIGN KEY TO USER THAT OWNS ACCOUNT
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID) ON DELETE CASCADE
);

--TABLE TO STORE TRANSACTIONS
CREATE TABLE USER_HIST(
    T_ID NUMBER PRIMARY KEY,
    LOG_DATE DATE,  --RECORD TIME OF THE TRANSACTION
    LOG_TYPE VARCHAR2(40), --DESCRIPTION OF TRANSACTION
    USER_ID NUMBER,
    ACCOUNT_ID NUMBER,
    FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID) ON DELETE CASCADE,
    FOREIGN KEY (ACCOUNT_ID) REFERENCES BANK_ACCOUNT(ACCOUNT_ID) ON DELETE CASCADE
);

--CUSTOM CONSTRAINT FOR BALANCE
ALTER TABLE BANK_ACCOUNT
ADD CONSTRAINT CK_BALANCE_POSITIVE CHECK (BALANCE > 0);


--CREATE SEQUENCES FOR PRIMARY KEYS
CREATE SEQUENCE SQ_USERS_PK
START WITH 1
INCREMENT BY 2;

CREATE SEQUENCE SQ_ACCOUNT_PK
START WITH 1
INCREMENT BY 2;

CREATE SEQUENCE SQ_USER_HIST_PK
START WITH 1
INCREMENT BY 2;

--TRIGGERS BEFORE INSERT TO ADD PK
CREATE OR REPLACE TRIGGER TR_INSERT_USER
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
    SELECT SQ_USERS_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT
BEFORE INSERT ON BANK_ACCOUNT
FOR EACH ROW
BEGIN
    SELECT SQ_ACCOUNT_PK.NEXTVAL INTO :NEW.ACCOUNT_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_USER_HIST
BEFORE INSERT ON USER_HIST
FOR EACH ROW
BEGIN
    SELECT SQ_USER_HIST_PK.NEXTVAL INTO :NEW.T_ID FROM DUAL;
END;

--STORED PROCEDURE TO CREATE A KNEW USER
CREATE OR REPLACE PROCEDURE INSERT_USERS
(U_NAME IN VARCHAR2, PW IN VARCHAR2, ADM IN VARCHAR2, U_MADE OUT NUMBER)
IS
BEGIN
   INSERT INTO USERS (USERNAME,USER_PASS,IS_ADMIN) VALUES(U_NAME,PW,ADM); 
   U_MADE := 1;
   COMMIT;
   EXCEPTION
   WHEN OTHERS THEN
        U_MADE := -1;
END;

--STORED PROCEDURE FOR LOGIN
CREATE OR REPLACE PROCEDURE LOGIN
(U_NAME IN VARCHAR2, PW IN VARCHAR2, FOUND OUT NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
    SELECT COUNT(USER_ID) INTO FOUND FROM USERS --CHECK THAT THE USER EXISTS
    WHERE USERNAME = U_NAME AND USER_PASS = PW;
    
    IF FOUND = 1 THEN
        OPEN S FOR  --IF THE USER IS FOUND RETURN THE USER AND POSITIVE VALUE TO REPRESENT TRUE
        SELECT * FROM USERS WHERE USERNAME = U_NAME AND USER_PASS = PW;
    ELSE
        FOUND := -1; --IF USER NOT FOUND RETURN NEGATIVE VALUE TO REPRESENT FALSE
        S := NULL;  --AND A NUUL USER
    END IF;    
END;

--PROCEDURE TO DELETE USER
CREATE OR REPLACE PROCEDURE DELETE_USERS
(U_ID IN NUMBER, PASS OUT NUMBER)
IS
BEGIN
    SELECT COUNT(USER_ID) INTO PASS FROM USERS WHERE USER_ID = U_ID; --MAKE SURE THAT THE USER EXISTS IN THE DATABASE
    IF PASS = 1 THEN
        DELETE USERS WHERE USER_ID = U_ID; --IF THE USER IS FOUND, DELETE IT AND COMMIT THE CHANGES
        COMMIT;
    ELSE
        PASS := -1; --IF THERE IS AN ERROR, RETURN NEGATIVE VALUE TO REPRESENT FALSE
    END IF;
END;

--FUNCTION TO VIEW ALL USERS IN THE DATABASE
CREATE OR REPLACE FUNCTION VIEW_USERS (A_ID IN NUMBER)
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT * FROM USERS WHERE USER_ID != A_ID; --RETURN ALL USERS EXCEPT THE ADMIN
    RETURN S;
END;

--FUNCTION TO VIEW ACCOUNTS
CREATE OR REPLACE FUNCTION GET_ACCOUNTS (U_ID IN NUMBER)
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT * FROM BANK_ACCOUNT WHERE USER_ID = U_ID;
    RETURN S;
END;

--STORED PROCEDURE TO CREATE A NEW ACCOUNT
CREATE OR REPLACE PROCEDURE INSERT_ACCOUNT (U_ID IN NUMBER, PASS OUT NUMBER)
IS
BEGIN
    INSERT INTO BANK_ACCOUNT (USER_ID,BALANCE) VALUES(U_ID,0); --CREATE WITH A INITIAL BALANCE OF 0
    PASS := 1;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        PASS := -1;
END;

--STORED PROCEDURE TO DELETE AN ACCOUNT
CREATE OR REPLACE PROCEDURE DELTE_ACCOUNT (U_ID IN NUMBER, BA_ID IN NUMBER, PASS OUT NUMBER)
IS
BEGIN
    SELECT COUNT(ACCOUNT_ID) INTO PASS FROM BANK_ACCOUNT --CHECK THAT THE ACCOUNT EXISTS
    WHERE USER_ID = U_ID AND ACCOUNT_ID = BA_ID;
    IF PASS = 1 THEN
        DELETE BANK_ACCOUNT WHERE ACCOUNT_ID = BA_ID; --DELETE AND COMMIT CHANGES TO DB IF FOUND
        COMMIT;
    ELSE
        PASS := -1; --RETURN NEGATIVE VALUE IF THE ACCOUNT IS NOT FOUND
    END IF;
END;

--PROCEDURE TO WITHDRAW FROM BANK ACCOUNT
CREATE OR REPLACE PROCEDURE ACCOUNT_WITHDRAW (BA_ID IN NUMBER, AMT IN NUMBER, NEW_BAL OUT NUMBER)
IS
BEGIN
    SELECT BALANCE INTO NEW_BAL FROM BANK_ACCOUNT
    WHERE ACCOUNT_ID = BA_ID;
    NEW_BAL := NEW_BAL - AMT;   --MAKE SURE THAT THE AMOUNT TO WITHDRAW IS NOT MORE THAN THE BALANCE
    IF NEW_BAL >= 0 THEN
        UPDATE BANK_ACCOUNT SET BALANCE = NEW_BAL --UPDATE THE BALANCE 
        WHERE ACCOUNT_ID = BA_ID;
        COMMIT;
    ELSE
        NEW_BAL := -1;
    END IF;
END;

--STORED PROCEDURE TO DEPOSIT INTO BANK ACCOUNT
CREATE OR REPLACE PROCEDURE ACCOUNT_DEPOSIT (BA_ID IN NUMBER, AMT IN NUMBER, NEW_BAL OUT NUMBER)
IS
BEGIN
    SELECT BALANCE INTO NEW_BAL FROM BANK_ACCOUNT WHERE ACCOUNT_ID = BA_ID;
    NEW_BAL := NEW_BAL + AMT;   --CALCULATE THE NEW BALANCE TO RETURN
    UPDATE BANK_ACCOUNT SET BALANCE = NEW_BAL
    WHERE ACCOUNT_ID = BA_ID;   --SET THE NEW BALANCE FOR THE ACCOUNT
    COMMIT; --COMMIT THE CHANGES
END;
