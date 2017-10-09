--2.1 SELECT
SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    employee
WHERE
    lastname = 'King';

SELECT
    *
FROM
    employee
WHERE
    firstname = 'Andrew'
    AND   reportsto IS NULL;

--2.2 ORDER BY

SELECT
    *
FROM
    album
ORDER BY
    title DESC;

SELECT
    firstname
FROM
    customer
ORDER BY
    city ASC;

--2.3 INSERT INTO

INSERT INTO genre VALUES (
    26,
    'Gothic Rock'
);

INSERT INTO genre VALUES (
    27,
    'Art Punk'
);

INSERT INTO employee (
    employeeid,
    lastname,
    firstname,
    title,
    reportsto,
    state,
    country
) VALUES (
    9,
    'Stark',
    'Tony',
    'Engineer',
    NULL,
    'NY',
    'USA'
);

INSERT INTO employee VALUES (
    10,
    'SMITH',
    'JHON',
    'IT Staff',
    NULL,
    '10-SEP-1986',
    '23-AUG-2009',
    '1111 Unicorn ST',
    'Neverland',
    'NL',
    'Disney',
    'T2K 1S2',
    '+1 (403) 499-3181',
    '+1 (403) 467-2212',
    'jhons@chinookcorp.com'
);

INSERT INTO customer VALUES (
    60,
    'Stark',
    'Arya',
    NULL,
    '1010 Westeros',
    'Bravoos',
    'WF',
    'USA',
    '30017',
    '+1 (614) 821-5711',
    NULL,
    'aryas@gmail.com',
    4
);

INSERT INTO customer VALUES (
    61,
    'Stark',
    'Rob',
    NULL,
    '1010 Westeros',
    'Winterfell',
    'WS',
    'USA',
    '30108',
    '+1 (212) 721-9711',
    NULL,
    'robs@gmail.com',
    5
);

--2.4 UPDATE

UPDATE customer
    SET
        firstname = 'Robert',
        lastname = 'Walter'
WHERE
    customerid = 32;

SELECT
    *
FROM
    artist
WHERE
    name = 'Creedence Clearwater Revival';

UPDATE artist
    SET
        name = 'CCR'
WHERE
    artistid = 76;

--2.5 LIKE

SELECT
    *
FROM
    invoice
WHERE
    billingaddress LIKE 'T%';

--2.6 BETWEEN

SELECT
    *
FROM
    invoice
WHERE
    total BETWEEN 15 AND 50;

SELECT
    *
FROM
    employee
WHERE
    hiredate BETWEEN TO_DATE('01-JUN-03','dd-MON-yy') AND TO_DATE('01-MAR-04','dd-MON-yy');

--2.7 DELETE

SELECT
    *
FROM
    customer
WHERE
    lastname = 'Walter';

ALTER TABLE customer DROP CONSTRAINT fk_customersupportrepid;

DELETE FROM customer WHERE
    lastname = 'Walter';

--3.1 System Defined Functions

SELECT
    current_timestamp(0),
    localtimestamp(0)
FROM
    dual;

SELECT
    name,
    length(name) AS length_of_name
FROM
    mediatype;

--3.2 System Defined Aggregate Functions

SELECT
    AVG(total)
FROM
    invoice
GROUP BY
    total;

SELECT
    MAX(unitprice)
FROM
    track;

--3.3 User Defined Scalar Functions

CREATE OR REPLACE FUNCTION GET_AVG_PRICE RETURN NUMBER IS
    AVG_PRICE NUMBER(10,2);
BEGIN
    SELECT
        SUM(UNITPRICE)/COUNT(QUANTITY) INTO AVG_PRICE FROM INVOICELINE;

    RETURN AVG_PRICE;
END;

SELECT
    GET_AVG_PRICE
FROM
    DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION GET_EMP_BD RETURN SYS_REFCURSOR
AS
   EMP_BORN_AFTER_68 SYS_REFCURSOR; 
BEGIN
OPEN EMP_BORN_AFTER_68 FOR
SELECT LASTNAME FROM EMPLOYEE WHERE (EXTRACT(YEAR FROM TO_DATE(BIRTHDATE,'DD-MON-YY'))) > 1968;
RETURN EMP_BORN_AFTER_68;

CLOSE EMP_BORN_AFTER_68;
END;

SELECT
   GET_EMP_BD
FROM
    DUAL;

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

CREATE OR REPLACE PROCEDURE get_employee_name AS

    CURSOR c1 IS SELECT
        firstname,
        lastname
                 FROM
        employee;

    employee_firstname   employee.firstname%TYPE;
    employee_lastname    employee.lastname%TYPE;
BEGIN
    OPEN c1;
    LOOP
        FETCH c1 INTO employee_firstname,employee_lastname;
        EXIT WHEN c1%notfound;
        dbms_output.put_line(employee_firstname
        || ''
        || employee_lastname);
    END LOOP;

    CLOSE c1;
END get_employee_name;

BEGIN
    get_employee_name;
END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee

CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO (
    EMPLOYEE_ID      IN NUMBER,
    NEW_LASTNAME     IN VARCHAR2,
    NEW_FIRSTNAME    IN VARCHAR2,
    NEW_BIRTHDATE    IN DATE,
    NEW_ADDRESS     IN VARCHAR2,
    NEW_CITY        IN VARCHAR2,
    NEW_STATE        IN VARCHAR2,
    NEW_COUNTRY      VARCHAR2,
    NEW_POSTALCODE   VARCHAR2,
    NEW_PHONE       VARCHAR2,
    NEW_FAX         VARCHAR2,
    NEW_EMAIL        VARCHAR2
)
    AS
BEGIN
    UPDATE EMPLOYEE
        SET
            LASTNAME =
                CASE
                    WHEN NEW_LASTNAME IS NULL 
                    THEN LASTNAME ELSE NEW_LASTNAME
                END,
            FIRSTNAME =
                CASE
                    WHEN NEW_FIRSTNAME IS NULL 
                    THEN FIRSTNAME ELSE NEW_FIRSTNAME
                END,
            BIRTHDATE = NEW_BIRTHDATE,
            ADDRESS = NEW_ADDRESS,
            CITY = NEW_CITY,
            STATE = NEW_STATE,
            COUNTRY = NEW_COUNTRY,
            POSTALCODE = NEW_POSTALCODE,
            PHONE = NEW_PHONE,
            FAX = NEW_FAX,
            EMAIL = NEW_EMAIL
            
    WHERE
        EMPLOYEEID = EMPLOYEE_ID;

END UPDATE_EMPLOYEE_INFO;

BEGIN 
UPDATE_EMPLOYEE_INFO(4, 'Huang', 'Jason', '09-JUN-87', '510 Clinton Ave', 'Brooklyn','NY', 'USA', '111-HHR', '+1 416-987-9087', NULL, 'huangj@chinook.com');
END;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGEROF_EMPLOYEE(
            EMPLOYEE_ID IN NUMBER) AS
    MANAGER EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    SELECT REPORTSTO INTO MANAGER FROM EMPLOYEE WHERE EMPLOYEEID=EMPLOYEE_ID;
     DBMS_OUTPUT.PUT('THE MANAGER OF THIS EMPLOYEE IS '||''||MANAGER);
END GET_MANAGEROF_EMPLOYEE;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY_OFCUSTOMER(
        CUSTOMER_ID IN NUMBER, CUSTOMER_FIRST_NAME OUT VARCHAR2, CUSTOMER_LAST_NAME OUT VARCHAR2, COMPANY_NAME OUT VARCHAR2) AS
    BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO CUSTOMER_FIRST_NAME, CUSTOMER_LAST_NAME, COMPANY_NAME FROM CUSTOMER WHERE CUSTOMERID =CUSTOMER_ID;
    DBMS_OUTPUT.PUT_LINE(CUSTOMER_FIRST_NAME ||''||CUSTOMER_LAST_NAME||''||COMPANY_NAME);
END GET_NAME_COMPANY_OFCUSTOMER;

--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out
--how to resolve them).
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE DISABLE CONSTRAINT PK_INVOICE CASCADE;

CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN NUMBER) AS
BEGIN
DELETE FROM INVOICE
    WHERE INVOICEID = INVOICE_ID;
COMMIT;
ROLLBACK;
END;

BEGIN
DELETE_INVOICE (110);
END;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_NEW_CUSTOMERRECORD(
    CUSTOMER_ID IN NUMBER,
    FIRST_NAME IN VARCHAR2,
    LAST_NAME IN VARCHAR2,
    COMPANY_NAME IN VARCHAR2,
    NEW_ADDRESS     IN VARCHAR2,
    NEW_CITY        IN VARCHAR2,
    NEW_STATE        IN VARCHAR2,
    NEW_COUNTRY      IN VARCHAR2,
    NEW_POSTALCODE   IN VARCHAR2,
    NEW_PHONE       IN VARCHAR2,
    NEW_FAX        IN  VARCHAR2,
    NEW_EMAIL       IN  VARCHAR2,
    SUPPORTREP_ID IN VARCHAR2
)
    AS
BEGIN

INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE,PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (CUSTOMER_ID, FIRST_NAME, LAST_NAME, COMPANY_NAME, NEW_ADDRESS, NEW_CITY, NEW_STATE, NEW_COUNTRY, NEW_POSTALCODE, NEW_PHONE, NEW_FAX, NEW_EMAIL, SUPPORTREP_ID);

COMMIT;
ROLLBACK;
END;
                    
EXEC INSERT_NEW_CUSTOMERRECORD(62, 'Huang', 'Jason', NULL, '510 Clinton Ave', 'Brooklyn','NY', 'USA', '111-HHR', '+1 416-987-9087', NULL, 'huangj@chinook.com', 3); 

--6.0 Triggers
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER NEW_EMPLOYEEID_TRIG
AFTER INSERT ON EMPLOYEE
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
BEGIN

IF INSERTING AND :NEW.EMPLOYEEID IS NOT NULL
    THEN
    RAISE_APPLICATION_ERROR(-20700,'new employeeid was inserted');
    END IF;
    END NEW_EMPLOYEEID_TRIG;

INSERT INTO EMPLOYEE(EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES(11,'JHON', 'LOCK');
    
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER UPDATE_ALBUM_TRIG
AFTER UPDATE ON ALBUM
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW
BEGIN
 IF UPDATING AND :NEW.ARTISTID IS NOT NULL
 THEN 
 RAISE_APPLICATION_ERROR(-20500, 'ALBUM TABLE WAS UPDATED');
 END IF;
 END;
 /
 UPDATE ALBUM SET TITLE = 'Volume' WHERE ARTISTID=146;
 
 --Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
 
 CREATE TABLE CUSTOMER_AUDIT (CUSTOMERID NUMBER, EMAIL VARCHAR2(100), DELETE_DATE DATE, DELETED_BY VARCHAR2(15));
 
 CREATE OR REPLACE TRIGGER AFTER_DELETE_TRIG
AFTER DELETE ON CUSTOMER
REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW

DECLARE
V_USERNAME VARCHAR2(10);
BEGIN
     SELECT user INTO V_USERNAME FROM DUAL;
     INSERT INTO CUSTOMER_AUDIT (CUSTOMERID, EMAIL, DELETE_DATE, DELETED_BY) VALUES ( :OLD.CUSTOMERID, :OLD.EMAIL, SYSDATE, V_USERNAME );
END AFTER_DELETE_TRIG;
/
DELETE FROM CUSTOMER WHERE CUSTOMERID=62;
SELECT * FROM CUSTOMER_AUDIT;
DROP TABLE CUSTOMER_AUDIT;

--7.0 JOINS
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.

SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;

--7.2 OUTER
--Task: Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL 
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON  CUSTOMER.CUSTOMERID=INVOICE.INVOICEID
ORDER BY CUSTOMER.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.

SELECT ARTIST.NAME, ALBUM.TITLE FROM ALBUM
RIGHT JOIN ARTIST ON ARTIST.ARTISTID=ALBUM.ARTISTID
ORDER BY ARTIST.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.

SELECT * FROM ALBUM CROSS JOIN ARTIST WHERE ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.

SELECT A.LASTNAME AS EMPLOYEE_LASTNAME_1, B.LASTNAME AS EMPLOYEE_LASTNAME_2, A.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID< >B.EMPLOYEEID AND A.REPORTSTO=B.REPORTSTO;

--9.0 Administration
--Task – Create a .bak file for the Chinook database
