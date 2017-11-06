-- CREATION OF ALL ENTITY TABLES AND THEIR CONSTRAINTS 

CREATE TABLE ERS_USERS(
    U_ID NUMBER(*,0) NOT NULL,
    U_USERNAME VARCHAR2(40) NOT NULL,
    U_PASSWORD VARCHAR2(40) NOT NULL,
    U_FIRSTNAME VARCHAR2(30),
    U_LASTNAME VARCHAR2(30),
    U_EMAIL VARCHAR2(100),
    UR_ID NUMBER(*,0) NOT NULL,
    CONSTRAINT ERS_USERS_PK PRIMARY KEY (U_ID),
    CONSTRAINT FK_ERS_USERS_USER_ROLES
        FOREIGN KEY (UR_ID)
        REFERENCES ERS_USER_ROLES(UR_ID),
    CONSTRAINT ERS_USERS_UNIQUE UNIQUE (U_USERNAME, U_EMAIL)
);

CREATE TABLE ERS_USER_ROLES(
    UR_ID NUMBER(*,0) NOT NULL,
    UR_ROLE VARCHAR2(40),
    CONSTRAINT ERS_USER_ROLES_PK PRIMARY KEY (UR_ID)
);

CREATE TABLE ERS_REIMBURSEMENTS(
    R_ID NUMBER(*,0) NOT NULL,
    R_AMOUNT NUMBER(22,2) NOT NULL,
    R_DESCRIPTION VARCHAR2(100),
    R_RECEIPT BLOB,
    R_SUBMITTED TIMESTAMP NOT NULL,
    R_RESOLVED TIMESTAMP,
    U_ID_AUTHOR NUMBER(*,0) NOT NULL,
    U_ID_RESOLVER NUMBER(*,0),
    RT_TYPE NUMBER(*,0) NOT NULL,
    RT_STATUS NUMBER(*,0),
    CONSTRAINT ERS_REIMBURSEMENTS_PK PRIMARY KEY (R_ID),
    CONSTRAINT FK_ERS_REIMBURSEMENTS_AUTHOR
        FOREIGN KEY (U_ID_AUTHOR)
        REFERENCES ERS_USERS(U_ID),
    CONSTRAINT FK_ERS_REIMBURSEMENTS_RESOLVER
        FOREIGN KEY (U_ID_RESOLVER)
        REFERENCES ERS_USERS(U_ID),
    CONSTRAINT FK_ERS_REIMBURSEMENTS_TYPES
        FOREIGN KEY (RT_TYPE)
        REFERENCES ERS_REIMBURSEMENT_TYPE(RT_ID),
    CONSTRAINT FK_ERS_REIMBURSEMENTS_STATUS
        FOREIGN KEY (RT_STATUS)
        REFERENCES ERS_REIMBURSEMENT_STATUS(RS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS(
    RS_ID NUMBER(*,0) NOT NULL,
    RS_STATUS VARCHAR2(30) NOT NULL,
    CONSTRAINT ERS_REIMBURSEMENT_STATUS_PK PRIMARY KEY (RS_ID)
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE(
    RT_ID NUMBER(*,0) NOT NULL,
    RT_TYPE VARCHAR2(30) NOT NULL,
    CONSTRAINT ERS_REIMBURSEMENT_TYPE_PK PRIMARY KEY (RT_ID)
);

-- SET DATABASE TO OUR TIME ZONE AND DATE 

ALTER SESSION SET TIME_ZONE = '+8:0';
ALTER SESSION SET NLS_DATE_FORMAT = 'DD-MON-YYYY HH24:MI:SS';

-- SEQUENCES FOR PRIMARY KEYS 

CREATE SEQUENCE SQ_ERS_U_ID_PK
START WITH 1
INCREMENT BY 3;

CREATE SEQUENCE SQ_ERS_UR_ID_PK
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_ERS_R_ID_PK
START WITH 100
INCREMENT BY 8;

CREATE SEQUENCE SQ_ERS_RS_ID_PK
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_ERS_RT_ID_PK
START WITH 1
INCREMENT BY 1;

-- BEFORE INSERT TRIGGERS WITH SEQUENCES 

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_USERS
BEFORE INSERT ON ERS_USERS
FOR EACH ROW
BEGIN
    SELECT SQ_ERS_U_ID_PK.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_USER_ROLES
BEFORE INSERT ON ERS_USER_ROLES
FOR EACH ROW 
BEGIN
    SELECT SQ_ERS_UR_ID_PK.NEXTVAL INTO :NEW.UR_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_REIMBURSEMENTS
BEFORE INSERT ON ERS_REIMBURSEMENTS
FOR EACH ROW 
BEGIN
    SELECT SQ_ERS_R_ID_PK.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_STATUS
BEFORE INSERT ON ERS_REIMBURSEMENT_STATUS
FOR EACH ROW 
BEGIN
    SELECT SQ_ERS_RS_ID_PK.NEXTVAL INTO :NEW.RS_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ERS_TYPE
BEFORE INSERT ON ERS_REIMBURSEMENT_TYPE
FOR EACH ROW 
BEGIN
    SELECT SQ_ERS_RT_ID_PK.NEXTVAL INTO :NEW.RT_ID FROM DUAL;
END;

-- INSERT INFO INTO ERS_REIMBURSEMENT_STATUS

INSERT INTO ERS_REIMBURSEMENT_STATUS(RS_STATUS) 
VALUES('SUBMITTED');
INSERT INTO ERS_REIMBURSEMENT_STATUS(RS_STATUS) 
VALUES('APPROVED');
INSERT INTO ERS_REIMBURSEMENT_STATUS(RS_STATUS) 
VALUES('DECLINED');

-- INSERT INFO INTO ERS_REIMBURSEMENT_TYPE

INSERT INTO ERS_REIMBURSEMENT_TYPE(RT_TYPE) 
VALUES('FOOD');
INSERT INTO ERS_REIMBURSEMENT_TYPE(RT_TYPE) 
VALUES('HOUSING');
INSERT INTO ERS_REIMBURSEMENT_TYPE(RT_TYPE) 
VALUES('TRANSPORTATION');
INSERT INTO ERS_REIMBURSEMENT_TYPE(RT_TYPE) 
VALUES('TUITION');
INSERT INTO ERS_REIMBURSEMENT_TYPE(RT_TYPE) 
VALUES('HEALTHCARE');

-- INSERT INFO FOR ERS_USER_ROLES

INSERT INTO ERS_USER_ROLES(UR_ROLE) 
VALUES('EMPLOYEE');
INSERT INTO ERS_USER_ROLES(UR_ROLE) 
VALUES('MANAGER');

-- INSERT A MANANGER INTO ERS_USERS

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, UR_ID)
VALUES('ADMIN', 'PASSWORD!', 2);

-- INSERT AN EMPLOYEE INTO ERS_USERS

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, UR_ID)
VALUES('SPONGEBOB', 'SQUAREPANTS', 1);

UPDATE ERS_USERS SET U_FIRSTNAME = 'Bob'
WHERE U_USERNAME = 'SPONGEBOB';

UPDATE ERS_USERS SET U_LASTNAME = 'Pop'
WHERE U_USERNAME = 'SPONGEBOB';

UPDATE ERS_USERS SET U_EMAIL = 'bobpop@gmail.com'
WHERE U_USERNAME = 'SPONGEBOB';

-- PROCEDURE TO UPDATE ERS_USERS

CREATE OR REPLACE PROCEDURE UPDATE_USER
(U_NAME IN VARCHAR2, COL IN VARCHAR2, NEW_VAL IN VARCHAR2)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    IF COL = 'U_PASSWORD' THEN
        UPDATE ERS_USERS SET U_PASSWORD = NEW_VAL
        WHERE U_USERNAME = U_NAME;
    ELSIF COL = 'U_FIRSTNAME' THEN
        UPDATE ERS_USERS SET U_FIRSTNAME = NEW_VAL
        WHERE U_USERNAME = U_NAME;
    ELSIF COL = 'U_LASTNAME' THEN
        UPDATE ERS_USERS SET U_LASTNAME = NEW_VAL
        WHERE U_USERNAME = U_NAME;
    ELSIF COL = 'U_EMAIL' THEN
        UPDATE ERS_USERS SET U_EMAIL = NEW_VAL
        WHERE U_USERNAME = U_NAME;
    END IF;
    DBMS_OUTPUT.PUT_LINE('UPDATED USER');
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNABLE TO UPDATE USER');
    ROLLBACK;
END;

BEGIN
    UPDATE_USER('SPONGEBOB', 'U_PASSWORD', 'pineapples');
END;

--  INSERT TEST REIMBURSEMENTS

INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_SUBMITTED, 
U_ID_AUTHOR, RT_TYPE, RT_STATUS)
VALUES(50, SYSDATE, 4, 4, 1);

INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_SUBMITTED, 
U_ID_AUTHOR, RT_TYPE, RT_STATUS)
VALUES(100, SYSDATE, 61, 2, 1);

INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_SUBMITTED, 
U_ID_AUTHOR, RT_TYPE, RT_STATUS)
VALUES(80, SYSDATE, 61, 3, 1);

INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_SUBMITTED, 
R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS)
VALUES(100, SYSDATE, SYSDATE, 4, 1, 1, 2);

INSERT INTO ERS_REIMBURSEMENTS(R_AMOUNT, R_SUBMITTED, 
R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS)
VALUES(100, SYSDATE, SYSDATE, 4, 1, 1, 3);


-- PROCEDURE TO APPROVE REIMBURSEMENTS
CREATE OR REPLACE PROCEDURE APPROVE(RE_ID IN NUMBER,ID_RESOLVER IN NUMBER)
IS
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE ERS_REIMBURSEMENTS SET RT_STATUS = 2 
    WHERE R_ID = RE_ID;
    UPDATE ERS_REIMBURSEMENTS SET R_RESOLVED = SYSDATE
    WHERE R_ID = RE_ID;
    UPDATE ERS_REIMBURSEMENTS SET U_ID_RESOLVER = ID_RESOLVER
    WHERE R_ID = RE_ID;
    DBMS_OUTPUT.PUT_LINE('UPDATED REIMBURSEMENT');
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNABLE TO APPROVE REIMBURSEMENT');
    ROLLBACK;
END;

BEGIN
    APPROVE(108, 1);
END;

-- PROCEDURE TO DECLINE REIMBURSEMENTS
CREATE OR REPLACE PROCEDURE DECLINE(RE_ID IN NUMBER,ID_RESOLVER IN NUMBER)
IS
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    UPDATE ERS_REIMBURSEMENTS SET RT_STATUS = 3 
    WHERE R_ID = RE_ID;
    UPDATE ERS_REIMBURSEMENTS SET R_RESOLVED = SYSDATE
    WHERE R_ID = RE_ID;
    UPDATE ERS_REIMBURSEMENTS SET U_ID_RESOLVER = ID_RESOLVER
    WHERE R_ID = RE_ID;
    DBMS_OUTPUT.PUT_LINE('UPDATED REIMBURSEMENT');
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNABLE TO APPROVE REIMBURSEMENT');
    ROLLBACK;
END;

BEGIN
    DECLINE(124, 1);
END;

-- PROCEDURE TO INSERT REIMBURSEMENTS
CREATE OR REPLACE PROCEDURE NEW_REIMBURSEMENT
(AMOUNT IN NUMBER, DESCRIP IN VARCHAR2, REC IN BLOB, 
AUTHOR IN NUMBER, TYPE1 IN VARCHAR2)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    IF TYPE1 = 'food' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, REC, SYSDATE, AUTHOR, 1, 1);
    ELSIF TYPE1 = 'housing' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, REC, SYSDATE, AUTHOR, 2, 1);
    ELSIF TYPE1 = 'transportation' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, REC, SYSDATE, AUTHOR, 3, 1);
    ELSIF TYPE1 = 'tuition' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, REC, SYSDATE, AUTHOR, 4, 1);
    ELSIF TYPE1 = 'healthcare' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_RECEIPT, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, REC, SYSDATE, AUTHOR, 5, 1);
    END IF;
    DBMS_OUTPUT.PUT_LINE('REIMBURSEMNET SUBMITTED');
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNABLE TO INSERT');
    ROLLBACK;
END;

BEGIN
    NEW_REIMBURSEMENT(20, 'business trip', NULL, 61, 'food');
END;

CREATE OR REPLACE PROCEDURE REIMBURSEMENT
(AMOUNT IN NUMBER, DESCRIP IN VARCHAR2, 
AUTHOR IN NUMBER, TYPE1 IN VARCHAR2)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    IF TYPE1 = 'food' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, SYSDATE, AUTHOR, 1, 1);
    ELSIF TYPE1 = 'housing' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, SYSDATE, AUTHOR, 2, 1);
    ELSIF TYPE1 = 'transportation' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, SYSDATE, AUTHOR, 3, 1);
    ELSIF TYPE1 = 'tuition' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, SYSDATE, AUTHOR, 4, 1);
    ELSIF TYPE1 = 'healthcare' THEN
        INSERT INTO ERS_REIMBURSEMENTS
        (R_AMOUNT, R_DESCRIPTION, R_SUBMITTED,
        U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES(AMOUNT, DESCRIP, SYSDATE, AUTHOR, 5, 1);
    END IF;
    DBMS_OUTPUT.PUT_LINE('REIMBURSEMENT SUBMITTED');
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNABLE TO INSERT');
    ROLLBACK;
END;
        
BEGIN
    REIMBURSEMENT(15, 'lunch', 61, 'food');
END;

DELETE FROM ERS_REIMBURSEMENTS WHERE R_ID = 596;

-- INSERT MORE USERS
INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES('billyboy85', '1234', 'Billy', 'Brown', 'billyboy85@yahoo.com', 1);

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES('kylesmith94', 'hihello', 'Kyle', 'Smith', 'kylesmith@yahoo.com', 1);

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES('marypoppins', 'umbrella', 'Mary', 'Jenkins', 'marypoppins@gmail.com', 1);

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES('kelsey218', 'cali', 'Kelsey', 'Green', 'kelsey218@gmail.com', 1);

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, U_FIRSTNAME, U_LASTNAME, U_EMAIL, UR_ID)
VALUES('ryry1212', '12121', 'Rylie', 'Adams', 'ryry12@yahoo.com', 1);

INSERT INTO ERS_USERS(U_USERNAME, U_PASSWORD, UR_ID)
VALUES('admin2', 'password', 2);