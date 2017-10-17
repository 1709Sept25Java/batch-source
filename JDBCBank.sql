DROP TABLE ACCOUNT_HOLDER;
DROP TABLE ACC_HOLDER_TRANSCTION;
DROP TABLE USERS;
DROP TABLE CREDENTIAL;
DROP TABLE TRANSACTION_TYPE;


-- ACCOUNT_HOLDER  

CREATE TABLE ACCOUNT_HOLDER (
ACCOUNT_HOLDER_ID INTEGER PRIMARY KEY,
FIRST_NAME VARCHAR2(100 BYTE),
LAST_NAME VARCHAR2(100 BYTE)
);

ALTER TABLE ACCOUNT_HOLDER 
ADD EMAIL VARCHAR2(100 BYTE);
-- ACC_HOLDER_TRANSCTION

CREATE TABLE ACC_HOLDER_TRANSCTION (
TRANSACTION_ID INTEGER PRIMARY KEY,
ACCOUNT_HOLDER_ID INTEGER,
TRANSACTION_TYPE_ID NUMBER(*,0),
TRANSACTIO_DATE DATE,
TRANSACTION_AMOUNT NUMBER(10,2),
ACC_BALANCE NUMBER(10,2) 
);

-- USERS AND CREDENTIALS 

CREATE TABLE USERS (
ACCOUNT_HOLDER_ID INTEGER,
USER_ID INTEGER,
LOGIN_UN VARCHAR2(50),
LOGIN_PW VARCHAR2(50)
);

DROP TABLE USERS;


-- TRANSACTION TYPES

/*CREATE TABLE TRANSACTION_TYPE (
TRANSACTION_TYPE_ID INTEGER PRIMARY KEY,
TRANSACTIONE_TYPE VARCHAR2(100 BYTE)  
); */


-- FOREIGN KEY CONTRAINTS

ALTER TABLE ACC_HOLDER_TRANSCTION 
ADD CONSTRAINT FK_ACCOUNT_HOLDER_ID 
FOREIGN KEY (ACCOUNT_HOLDER_ID) REFERENCES ACCOUNT_HOLDER(ACCOUNT_HOLDER_ID);

ALTER TABLE ACC_HOLDER_TRANSCTION
ADD CONSTRAINT FK_ACC_HOLDER_TRANSCTION
FOREIGN KEY (TRANSACTION_TYPE_ID) REFERENCES TRANSACTION_TYPE(TRANSACTION_TYPE_ID);

ALTER TABLE USERS 
ADD CONSTRAINT FK_ACCOUNT_HOLDER_ID_USER
FOREIGN KEY (ACCOUNT_HOLDER_ID) REFERENCES ACCOUNT_HOLDER(ACCOUNT_HOLDER_ID);

ALTER TABLE USERS 
ADD CONSTRAINT FK_USER_ID
FOREIGN KEY (USER_ID) REFERENCES CREDENTIAL(USER_ID);


--ADD CHECK CONSTRAINT TO KEEP ACCOUNT BALACE > 0

ALTER TABLE ACC_HOLDER_TRANSCTION
ADD CONSTRAINT CK_ACC_BALANCE CHECK (ACC_BALANCE > 0);

-- ADD UNIQUE CONTRAINT

--SEQUENCES 
CREATE SEQUENCE SQ_ACCOUNT_HOLDER_PK
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE SQ_ACC_HOLDER_TRANSACTION_PK
START WITH 10
INCREMENT BY 1;

CREATE SEQUENCE SQ_TRANSACTION_TYPE_PK
START WITH 20
INCREMENT BY 1;


CREATE SEQUENCE SQ_USER_ID_PK
START WITH 30
INCREMENT BY 1;


DROP SEQUENCE SQ_CREDENTIAL_ID_PK;
DROP SEQUENCE SQ_ACC_HOLDER_TRANSACTION_PK;
DROP SEQUENCE SQ_ACCOUNT_HOLDER_PK;

--CREATE BEFORE INSERT TRIGGERS 

CREATE OR REPLACE TRIGGER TR_INSERT_ACCOUNT_HOLDER
BEFORE INSERT ON ACCOUNT_HOLDER
FOR EACH ROW
BEGIN
SELECT SQ_ACCOUNT_HOLDER_PK.NEXTVAL INTO :NEW.ACCOUNT_HOLDER_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_ACC_HOLDER_TRAN
BEFORE INSERT ON ACC_HOLDER_TRANSCTION
FOR EACH ROW
BEGIN
  SELECT SQ_ACC_HOLDER_TRANSACTION_PK.NEXTVAL INTO :NEW.TRANSACTION_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_TRANSACTION_TYPE
BEFORE INSERT ON TRANSACTION_TYPE
FOR EACH ROW
BEGIN
  SELECT SQ_TRANSACTION_TYPE_PK.NEXTVAL INTO :NEW.TRANSACTION_TYPE_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER TR_INSERT_USER_ID
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  SELECT SQ_USER_ID_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;



--USE TRIGGERS TO GENERATE PRIMARY KEYS
INSERT INTO TRANSACTION_TYPE VALUES (1, 'DEPOSIT');
INSERT INTO TRANSACTION_TYPE VALUES (2, 'WITHDRAWL');


INSERT INTO ACCOUNT_HOLDER VALUES (1, 'Sherine', 'Miri', 'miris@gmail.com');
INSERT INTO ACCOUNT_HOLDER VALUES (2, 'Hai', 'Ding', 'dingh@gmail.com');
INSERT INTO ACCOUNT_HOLDER VALUES (3, 'Estephany', 'Torres', 'torrese@gmail.com');

INSERT INTO ACC_HOLDER_TRANSCTION VALUES (1,24,2,NULL,1000,1000);
INSERT INTO ACC_HOLDER_TRANSCTION VALUES (2,24,2,NULL,200,800);


INSERT INTO USERS VALUES (1,1,'miris@gmail.com', '123');
-- PROCEDURES






