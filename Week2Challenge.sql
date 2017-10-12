<<<<<<< HEAD
 CREATE TABLE DEPARTMENTS
(DEPARTMENT_ID NUMBER NOT NULL,
 DEPARTMENT_NAME VARCHAR(100),
 CONSTRAINT PK_DEPARTMENTS PRIMARY KEY (DEPARTMENT_ID)
 );
 
CREATE TABLE EMPLOYEES
(EMPLOYEE_ID NUMBER NOT NULL,
 EMP_FIRSTNAME VARCHAR(100),
 EMP_LASTNAME VARCHAR(100),
 DEPARTMENT_ID NUMBER NOT NULL,
 SALARY NUMBER,
 EMP_EMAIL VARCHAR(100),
 CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY(EMPLOYEE_ID),
 CONSTRAINT FK_DEPARTMENT_ID FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID)
 );

DROP TABLE DEPARTMENTS;
DROP TABLE EMPLOYEES;
 
  
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES(1, 'CHARLIE','BROWN',1,5000,'CHARLIE.BROWN@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(2, 'MEGAN','SMITH',2,5000,'MEGAN.SMITH@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(3, 'LYDIA','BOOK',3,5000,'LYDIA.BOOK@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(4, 'SAM','HILTON',1,5000,'SAM.HILTON@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(5, 'LILY','FOX',2,5000,'LILY.FOX@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(6, 'JACK','MILANO',3,5000,'JACK.MILANO@GMAIL.COM');

INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME)VALUES(1,'ACCOUNTING');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME)VALUES(2,'FINANCE');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES(3,'IT');

CREATE SEQUENCE EMPLOYEES_SEQ;
CREATE SEQUENCE DEPARTMENTS_SEQ;

CREATE OR REPLACE TRIGGER EMP_SEQ
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW
BEGIN
  SELECT EMPLOYEES_SEQ.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER DEP_SEQ
BEFORE INSERT ON DEPARTMENTS
FOR EACH ROW
BEGIN
  SELECT DEPARTMENTS_SEQ.NEXTVAL INTO :NEW.DEPARTMENTS_ID FROM DUAL;
END;

CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE
(DEPARTMENTID DEPARTMENTS.DEPARTMENT_ID%TYPE
)
IS 
BEGIN
UPDATE EMPLOYEES
SET SALARY = SALARY*1.1
WHERE DEPARTMENT_ID = DEPARTMENTID;
END;
BEGIN
SP_GIVE_RAISE(1);
END;





=======
 CREATE TABLE DEPARTMENTS
(DEPARTMENT_ID NUMBER NOT NULL,
 DEPARTMENT_NAME VARCHAR(100),
 CONSTRAINT PK_DEPARTMENTS PRIMARY KEY (DEPARTMENT_ID)
 );
 
CREATE TABLE EMPLOYEES
(EMPLOYEE_ID NUMBER NOT NULL,
 EMP_FIRSTNAME VARCHAR(100),
 EMP_LASTNAME VARCHAR(100),
 DEPARTMENT_ID NUMBER NOT NULL,
 SALARY NUMBER,
 EMP_EMAIL VARCHAR(100),
 CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY(EMPLOYEE_ID),
 CONSTRAINT FK_DEPARTMENT_ID FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID)
 );

DROP TABLE DEPARTMENTS;
DROP TABLE EMPLOYEES;
 
  
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) VALUES(1, 'CHARLIE','BROWN',1,5000,'CHARLIE.BROWN@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(2, 'MEGAN','SMITH',2,5000,'MEGAN.SMITH@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(3, 'LYDIA','BOOK',3,5000,'LYDIA.BOOK@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(4, 'SAM','HILTON',1,5000,'SAM.HILTON@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(5, 'LILY','FOX',2,5000,'LILY.FOX@GMAIL.COM');
INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)VALUES(6, 'JACK','MILANO',3,5000,'JACK.MILANO@GMAIL.COM');

INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME)VALUES(1,'ACCOUNTING');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME)VALUES(2,'FINANCE');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES(3,'IT');

CREATE SEQUENCE EMPLOYEES_SEQ;
CREATE SEQUENCE DEPARTMENTS_SEQ;

CREATE OR REPLACE TRIGGER EMP_SEQ
BEFORE INSERT ON EMPLOYEES
FOR EACH ROW
BEGIN
  SELECT EMPLOYEES_SEQ.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;

CREATE OR REPLACE TRIGGER DEP_SEQ
BEFORE INSERT ON DEPARTMENTS
FOR EACH ROW
BEGIN
  SELECT DEPARTMENTS_SEQ.NEXTVAL INTO :NEW.DEPARTMENTS_ID FROM DUAL;
END;

CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE
(DEPARTMENTID DEPARTMENTS.DEPARTMENT_ID%TYPE
)
IS 
BEGIN
UPDATE EMPLOYEES
SET SALARY = SALARY*1.1
WHERE DEPARTMENT_ID = DEPARTMENTID;
END;
BEGIN
SP_GIVE_RAISE(1);
END;





>>>>>>> ba5ea52599c51160fbdf35b2ee179acc98a5c746
