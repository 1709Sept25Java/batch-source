--TABLES
CREATE TABLE USERS(
    U_ID NUMBER NOT NULL,
    U_USERNAME VARCHAR2(40) NOT NULL ,
    U_PASSWORD VARCHAR2(40) NOT NULL,
    U_FIRSTNAME VARCHAR2(30),
    U_LASTNAME VARCHAR2(30),
    U_EMAIL VARCHAR2(100),
    --DECIDED TO DROP USER ROLE TABLE
    U_ROLE VARCHAR2(40) NOT NULL CONSTRAINT UROLE CHECK(U_ROLE IN ('Employee','Manager')), 
    CONSTRAINT PK_USER PRIMARY KEY(U_ID),
    CONSTRAINT UN_USERNAME UNIQUE(U_USERNAME),
    CONSTRAINT UN_EMAIL UNIQUE(U_EMAIL)
);

CREATE TABLE REIMBURSEMENT_STATUS(
    RS_ID NUMBER NOT NULL,
    RS_STATUS VARCHAR2(30) NOT NULL,
    CONSTRAINT PK_R_STATUS PRIMARY KEY(RS_ID)
);

CREATE TABLE REIMBURSEMENT_TYPE(
    RT_ID NUMBER NOT NULL UNIQUE,
    RT_TYPE VARCHAR2(30),
    CONSTRAINT PK_R_TYPE PRIMARY KEY(RT_ID)
);

CREATE TABLE REIMBURSEMENTS(
    R_ID NUMBER NOT NULL,
    R_AMOUNT NUMBER(22,2) NOT NULL,
    R_DESCRIPTION VARCHAR2(100),
    R_RECEIPT BLOB,
    R_SUBMITTED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    R_RESOLVED TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    U_ID_AUTHOR NUMBER NOT NULL,
    U_ID_RESOLVER NUMBER,
    RT_TYPE NUMBER NOT NULL,
    RT_STATUS NUMBER NOT NULL,
    CONSTRAINT PK_REIMBURSEMENTS PRIMARY KEY(R_ID),
    CONSTRAINT FK_AUTHOR FOREIGN KEY (U_ID_AUTHOR) REFERENCES USERS(U_ID),
    CONSTRAINT FK_RESOLVER FOREIGN KEY (U_ID_RESOLVER) REFERENCES USERS(U_ID),
    CONSTRAINT FK_R_STATUS FOREIGN KEY (RT_STATUS) REFERENCES REIMBURSEMENT_STATUS(RS_ID),
    CONSTRAINT FK_R_TYPE FOREIGN KEY (RT_TYPE) REFERENCES REIMBURSEMENT_TYPE(RT_ID)    
);

--SEQUENCES FOR USERS, REIMBURSEMENTS, REIMBUSEMENT_STATUS & REIMBURSEMENT_TYPE
CREATE SEQUENCE SQ_PK_USER
START WITH 3000
INCREMENT BY 3;

CREATE SEQUENCE SQ_PK_REIMBURSEMENTS
START WITH 5000
INCREMENT BY 5;

CREATE SEQUENCE SQ_PK_R_STATUS
START WITH 7000
INCREMENT BY 7;

CREATE SEQUENCE SQ_PK_R_TYPE
START WITH 9000
INCREMENT BY 9;

--TRIGGERS FOR GENERATING PRIMARY KEYS FOR USERS, REIMBURSEMENTS, REIMBUSEMENT_STATUS & REIMBURSEMENT_TYPE
CREATE OR REPLACE TRIGGER TR_INSERT_USERS
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
    SELECT SQ_PK_USER.NEXTVAL INTO :NEW.U_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_REIMBURSEMENTS
BEFORE INSERT ON REIMBURSEMENTS
FOR EACH ROW
BEGIN
    SELECT SQ_PK_REIMBURSEMENTS.NEXTVAL INTO :NEW.R_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_R_STATUS
BEFORE INSERT ON REIMBURSEMENT_STATUS
FOR EACH ROW
BEGIN
    SELECT SQ_PK_R_STATUS.NEXTVAL INTO :NEW.RS_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_R_TYPE
BEFORE INSERT ON REIMBURSEMENT_TYPE
FOR EACH ROW
BEGIN
    SELECT SQ_PK_R_TYPE.NEXTVAL INTO :NEW.RT_ID FROM DUAL;
END;

CREATE OR REPLACE PROCEDURE LOGIN(UN IN VARCHAR2, PW IN VARCHAR2, S OUT SYS_REFCURSOR)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    OPEN S FOR
        SELECT U_ID, U_ROLE FROM USERS WHERE U_USERNAME = UN AND U_PASSWORD = PW;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE USER_INFORMATION(USER_ID IN NUMBER, S OUT SYS_REFCURSOR)
IS
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    OPEN S FOR
        SELECT U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL, U_ROLE FROM USERS WHERE U_ID = USER_ID;
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE USER_REIMBURSEMENTS(USER_ID IN NUMBER, S OUT SYS_REFCURSOR)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
    OPEN S FOR
        SELECT R.*--, RS.RS_STATUS, RT.RT_TYPE
        FROM REIMBURSEMENTS R
        --JOIN REIMBURSEMENT_STATUS RS ON R.RT_STATUS = RS.RS_ID
        --JOIN REIMBURSEMENT_TYPE RT ON R.RT_TYPE = RT.RT_ID
        WHERE R.U_ID_AUTHOR = USER_ID;
    COMMIT;
    EXCEPTION 
    WHEN OTHERS THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE SUBMIT_REIMBURSEMENT(R_AMT IN NUMBER, R_DESC IN VARCHAR2, R_AUTH IN NUMBER, R_TYPE IN NUMBER, S OUT NUMBER)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; 
        INSERT INTO REIMBURSEMENTS(R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES (R_AMT, R_DESC, DEFAULT, R_AUTH, R_TYPE, 7000);
        S:=1;
    COMMIT;
    S:=0;
    EXCEPTION
    WHEN OTHERS THEN ROLLBACK;
END;


CREATE OR REPLACE PROCEDURE SUBMIT_IMAGE(RECEIPT IN BLOB)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; 
        INSERT INTO REIMBURSEMENTS(R_AMOUNT, R_RECEIPT, R_SUBMITTED, U_ID_AUTHOR, RT_TYPE, RT_STATUS)
        VALUES (10, RECEIPT, DEFAULT, 3000, 9000, 7000);
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE UPDATE_USER(USER_ID IN NUMBER, UN IN VARCHAR2, UPW IN VARCHAR2, UFN IN VARCHAR2, ULN IN VARCHAR2, UE IN VARCHAR2, S OUT NUMBER)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; 
    UPDATE USERS 
        SET U_USERNAME = UN,
            U_PASSWORD = UPW,
            U_FIRSTNAME = UFN,
            U_LASTNAME = ULN,
            U_EMAIL = UE
        WHERE U_ID = USER_ID;
        S:=1;
    COMMIT;
    S:=0;
    EXCEPTION
    WHEN OTHERS THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE STATUS_REIMBURSEMENTS(STATUS IN NUMBER,S OUT SYS_REFCURSOR)
IS 
BEGIN 
    OPEN S FOR 
        SELECT R.*
        FROM REIMBURSEMENTS R WHERE RT_STATUS = STATUS;
END;

CREATE OR REPLACE PROCEDURE REVIEW_REIMBURSEMENT(RID IN NUMBER, MID IN NUMBER, STATUS IN NUMBER, S OUT NUMBER)
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; 
    S:=0;
    UPDATE REIMBURSEMENTS 
        SET U_ID_RESOLVER = MID,
            RT_STATUS = STATUS
        WHERE R_ID = RID;
        S:=1;
    COMMIT;
    EXCEPTION
    WHEN OTHERS 
    THEN ROLLBACK;
END;

CREATE OR REPLACE PROCEDURE VIEW_EMPLOYEES(S OUT SYS_REFCURSOR)
IS BEGIN
    OPEN S FOR
        SELECT U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL FROM USERS
        WHERE U_ROLE = 'Employee';
END;

CREATE OR REPLACE PROCEDURE VIEW_EMPLOYEES(S OUT SYS_REFCURSOR)
IS BEGIN
    OPEN S FOR
        SELECT U_ID, U_USERNAME, U_FIRSTNAME, U_LASTNAME, U_EMAIL FROM USERS
        WHERE U_ROLE = 'Employee';
END;

CREATE OR REPLACE PROCEDURE RESOLVED_REIMBURSEMENTS(S OUT SYS_REFCURSOR)
IS 
BEGIN 
    OPEN S FOR 
        SELECT R_ID, R_AMOUNT, R_DESCRIPTION, R_SUBMITTED, R_RESOLVED, U_ID_AUTHOR, U_ID_RESOLVER, RT_TYPE, RT_STATUS
        FROM REIMBURSEMENTS R WHERE RT_STATUS = 7007 OR RT_STATUS = 7014;
END;

CREATE OR REPLACE PROCEDURE REIMBURSEMENT_TYPE_ID(RTYPE IN VARCHAR, S OUT NUMBER)  
IS 
BEGIN
    SET TRANSACTION ISOLATION LEVEL SERIALIZABLE; 
    INSERT INTO REIMBURSEMENT_TYPE(RT_TYPE) VALUES(RTYPE)
        RETURNING RT_ID INTO S;
    EXCEPTION WHEN OTHERS THEN
        SELECT RT_ID INTO S FROM REIMBURSEMENT_TYPE WHERE RT_TYPE = RTYPE; 
END;

DECLARE S NUMBER;
BEGIN 
    REVIEW_REIMBURSEMENT(5200, 3060, 7000, S);
    DBMS_OUTPUT.PUT_lINE(S);
END;

ALTER TABLE REIMBURSEMENTS MODIFY (R_RESOLVED TIMESTAMP DEFAULT CURRENT_TIMESTAMP); 
ALTER TABLE REIMBURSEMENT_TYPE MODIFY (RT_TYPE UNIQUE); 
