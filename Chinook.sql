
/*2.1 Task – Select all records from the Employee table.*/
SELECT * FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King. */
SELECT *  FROM EMPLOYEE WHERE LASTNAME = 'King';

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.*/
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL; 



/* 2.2 ORDER BY Task – Select all albums in Album table and sort result set in descending order by title.*/
SELECT * FROM Album ORDER BY TITLE DESC; 
--Task – Select first name from Customer and sort result set in ascending order by city*/
SELECT FIRSTNAME, CITY FROM CUSTOMER ORDER BY CITY ASC;

--Task – Select first name from Customer and sort result set in ascending order by city*/
SELECT FIRSTNAME, CITY FROM CUSTOMER ORDER BY CITY ASC;


/*2.3 INSERT INTO*/
--Task – Insert two new records into Genre table

INSERT INTO GENRE (GENREID, NAME) VALUES (26, 'Deep House');
INSERT INTO GENRE (GENREID, NAME) VALUES (27, 'Salsa');

-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9,'Pimentel', 'Massiel', 'Associate', 6, '21-SEP-90', '25-SEP-17', '85-40 89TH ST', 'Woodhaven', 'NY', 'US', '11421', '+1 (718) 607-3792', '+1 (718) 907-3792', 'massiepimentel@gmail.com');

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10,'Josh', 'Smith', 'IT Staff', 6, '03-jun-75', '01-SEP-11', '56-90 67TH ST', 'LIC', 'NY', 'US', '11321', '+1 (718) 907-3792', '+1 (718) 307-3792', 'joshsmith@gmail.com');

-- Task – Insert two new records into Customer table

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (60,'Massiel', 'Pimentel', 'Revature', '85-40 89TH ST', 'Woodhaven', 'NY', 'US', '11421', '+1 (718) 607-3792', '+1 (718) 907-3792', 'massiepimentel@gmail.com', 3);

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES (61,'Dave', 'Pimentel', 'Revature', '85-40 89TH ST', 'Woodhaven', 'NY', 'US', '11421', '+1 (718) 607-3792', '+1 (718) 907-3792', 'davepimentel@gmail.com', 3);

/*2.4 UPDATE*/
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';


/*2.5 LIKE
Task – Select all invoices with a billing address like “T%”*/
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';


/*2.6 BETWEEN*/
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50; 

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';


/*2.7 DELETE
Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).*/

ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;

DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

ALTER TABLE INVOICE 
ADD CONSTRAINT FK_INVOICECUSTOMERID
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID); -- NOT WORKING! AAAHHH! 



/*3.1 System Defined Functions*/
-- Task – Create a function that returns the current time.
SELECT CURRENT_TIMESTAMP FROM DUAL;

--Task – create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;



/*3.2 System Defined Aggregate Functions*/
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) FROM INVOICE;

--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;


/*3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table*/
SELECT AVG(UNITPRICE) FROM INVOICELINE; 

/*3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.*/
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '01-Jan-68';


/*4.1 Basic Stored Procedure
Task – Create a stored procedure that selects the first and last names of all the employees.*/
CREATE OR REPLACE PROCEDURE EMPLOYEE_SELECT (S OUT SYS_REFCURSOR)
IS
BEGIN 
OPEN S FOR 
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;


DECLARE 
S SYS_REFCURSOR;
SOME_FN EMPLOYEE.FIRSTNAME%TYPE;  
SOME_LN EMPLOYEE.LASTNAME%TYPE;
BEGIN
  GET_ALL_BEARS(S);
  LOOP 
    FETCH S INTO SOME_FN, SOME_LN;
    EXIT WHEN S%NOTFOUND;  
  END LOOP;
  CLOSE S;
END;



/*4.2 Stored Procedure Input Parameters*/
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_PERSONAL_INFO
IS
BEGIN 
UPDATE EMPLOYEE SET BIRTHDATE = '24-09-95'
WHERE FIRSTNAME = 'Massiel';
END;

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE MANAGER_EMPLOYEE_INFO (S OUT SYS_REFCURSOR)
IS
BEGIN 
OPEN S FOR 
SELECT REPORTSTO, FIRSTNAME, LASTNAME FROM EMPLOYEE
WHERE REPORTSTO = EMPLOYEEID;
END;

/*4.3 Stored Procedure Output Parameters
Task – Create a stored procedure that returns the name and company of a customer.*/
CREATE OR REPLACE PROCEDURE CUSTOMERNAME_COMPANY (S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR 
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER
ORDER BY COMPANY;
END;


/*5.0 Transactions*/
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

ALTER TABLE INVOICELINE
DISABLE CONSTRAINT FK_INVOICELINEINVOICEID;
DELETE FROM INVOICE WHERE INVOICEID = 1;
ALTER TABLE INVOICELINE
ENABLE CONSTRAINT FK_INVOICELINEINVOICEID;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE TASK_5
IS 
BEGIN
    INSERT INTO EMPLOYEE 
VALUES (11,'John', 'Doe', 'IT Staff', 6, '03-jun-76', '07-MAR-90', '58-80 127TH ST', 'NY', 'NY', 'US', '11321', '+1 (879) 907-3792', '+1 (878) 307-3792', 'john@gmail.com');
END;

BEGIN
TASK_5();
END;
/*6.1 AFTER/FOR*/
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_AFTER_INSERT
AFTER INSERT ON EMPLOYEE
FOR EACH ROW 
DECLARE
reminder_text varchar2(200);
BEGIN
    reminder_text := 'You have entered a new record!';
END;



--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER TR_AFTER_UPDATE
AFTER UPDATE ON ALBUM
FOR EACH ROW 
DECLARE
reminder_text varchar2(200);
BEGIN
    reminder_text := 'You have entered a row! ';
END;



--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.*/
CREATE OR REPLACE TRIGGER TR_AFTER_DELETE
AFTER DELETE ON CUSTOMER
FOR EACH ROW 
DECLARE
reminder_text varchar2(200);
BEGIN
    reminder_text := 'You have have deleted a row! ';
END;


/*7.1 INNER
Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId. */
SELECT INVOICE.INVOICEID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME
FROM CUSTOMER
INNER JOIN INVOICE ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID;

/*7.2 OUTER
Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.*/
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;


/*7.3 RIGHT
Task – Create a right join that joins album and artist specifying artist name and title.*/
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM ON ALBUM.ALBUMID = ARTIST.ARTISTID; 


/*7.4 CROSS
Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.*/
SELECT * FROM ARTIST CROSS JOIN ALBUM;


/*7.5 SELF
Task – Perform a self-join on the employee table, joining on the reportsto column.*/
SELECT FIRSTNAME, LASTNAME, REPORTSTO
FROM EMPLOYEE;

