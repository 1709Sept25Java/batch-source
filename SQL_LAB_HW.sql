--2.0 SQL Queries
--2.1 SELECT
--Task: Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Task: Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE
WHERE LASTNAME='KING';

--Task: Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task: Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;

--Task:  Select first name from Customer and sort result set in ascending order by city.
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
--Task: Insert two new records into Genre table
INSERT INTO GENRE VALUES(26,'White Noise');
INSERT INTO GENRE VALUES(27,'Smooth Jazz');

--Task: Insert two new records into Employee table
INSERT INTO EMPLOYEE VALUES(10,'Davis','Kevin','Sales Support Agent',2,'19-JUN-1994','17-MAY-2017','675 Columbia Boulevard West','Lethbridge','AB','Canada','T1K 5N8','+1 (403) 658-9321','+1 (403)289-5401','kevin@chinookcorp.com');
INSERT INTO EMPLOYEE VALUES(9,'Lancaster','Mariah','IT Staff',6,'5-OCT-1986','28-SEP-2017','1650 Bedford Ave','Brooklyn','NY','USA','11225','+1 (347) 789-3456','+1 (718) 984-6257','mariah@chinookcorp.com');

--Task: Insert two new records into Customer table
INSERT INTO CUSTOMER VALUES(60,'Carol','Harbinger','Kings Record Store','475 Melbourne Rd','New Rochelle','NY','USA','10801','+1 (917) 345-2667','+1 (718) 671-2443','charb@krs.com',10);
INSERT INTO CUSTOMER VALUES(61,'Franklin','Adam','Jack Threads','81 Prospect St','Brooklyn','NY','USA','11201','+1 (646) 210-3386','+1 (718) 455-9708','afranklin@jackthreads.com',5);

2.4 UPDATE 
--Task: Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

--Task: Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task: Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task: Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

--Task: Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE BETWEEN '1-JUN-2003' AND '1-MAR-2004';

--2.7 DELETE
--Task: Delete a record in Customer table where the name is Robert Walter
--(There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE
DROP CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE
ADD CONSTRAINT FK_NULL_UPON_DELETE
FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID)
ON DELETE SET NULL;

ALTER TABLE INVOICE
DROP CONSTRAINT SYS_C005121;

DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.0 SQL Functions
--3.1 System Defined Functions
--Task: Create a function that returns the current time.
SELECT LOCALTIMESTAMP FROM DUAL;

--Task: create a function that returns the length of name in MEDIATYPE table
SELECT MEDIATYPEID,NAME,LENGTH(NAME)
FROM MEDIATYPE
ORDER BY LENGTH(NAME);

--3.2 System Defined Aggregate Functions
--Task: Create a function that returns the average total of all invoices
SELECT AVG(TOTAL) FROM INVOICE;

--Task: Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;

--3.3 User Defined Scalar Functions
--Task: Create a function that returns the average price of invoiceline items in the invoiceline table

/*CREATE OR REPLACE FUNCTION FIND_COLUMN_AVERAGE(X IN COLUMN, Y IN TABLE)
--DECLARE VARIABLE
RETURN NUMBER
AS;
--ASSIGN FUNCTION, INITIALIZING VARIABLE
BEGIN
    AVERAGE := SELECT AVG(X) FROM Y;
    RETURN AVERAGE;
END;

--DECLARE VARIABLES AND EXECUTE FUNCTION */

--3.4 User Defined Table Valued Functions
--Task: Create a function that returns all employees who are born after 1968.
/*CREATE OR REPLACE FUNCTION GET_EMPLOYEES_BORN_AFTER_1968
IS
BEGIN
    SELECT * FROM EMPLOYEE
    WHERE BIRTHDATE > '31-DEC-1968';
END; */

--4.0 Stored Procedures
--4.1 Basic Stored Procedure
--Task: Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE STORED PROCEDURE SP_GET_EMPLOYEE_NAMES
IS
BEGIN
    /*DBMS_OUTPUT.PUT_LINE('Retrieving Data...');*/ --I haven't been able to get anything to print at all, not sure why
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE; --The query works but the procedure doesn't
END;

--4.2 Stored Procedure Input Parameters
--Task: Create a stored procedure that updates the personal information of an employee.


--Task: Create a stored procedure that returns the managers of an employee.


--4.3 Stored Procedure Output Parameters
--Task: Create a stored procedure that returns the name and company of a customer.















--6.0 Triggers
--Task: Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER CONFIRM_ADD_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    SELECT * INTO EMPLOYEE;
    SELECT LOCALTIMESTAMP FROM DUAL;
END;

--TEST TRIGGER

DELETE FROM EMPLOYEE WHERE LASTNAME = 'Lancaster' AND FIRSTNAME = 'Mariah';

INSERT INTO EMPLOYEE VALUES(9,'Lancaster','Mariah','IT Staff',6,'5-OCT-1986','28-SEP-2017','1650 Bedford Ave','Brooklyn','NY','USA','11225','+1 (347) 789-3456','+1 (718) 984-6257','mariah@chinookcorp.com');

--Task: Create an after update trigger on the album table that fires after a row is inserted in the table
--I just wanted to see if everything would work in lowercase
create or replace trigger after_album_insert
after insert on ALBUM
for each row
begin
    DBMS_OUT.PUT_LINE(:new.TITLE||' has been added to table ALBUM.');
end;

--Task: Create an after delete trigger on the customer table that fires after a row is deleted from the table.








--7.0 JOINS
-- 7.1 INNER
--Task: Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.LASTNAME, CUSTOMER.FIRSTNAME, INVOICE.INVOICEID FROM INVOICE
INNER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
ORDER BY INVOICEID ASC;

--7.2 OUTER
--Task: Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT INVOICE.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM INVOICE
LEFT OUTER JOIN CUSTOMER ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
ORDER BY INVOICEID ASC;

--7.3 RIGHT
--Task: Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM
RIGHT OUTER JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID
ORDER BY ALBUM.TITLE ASC;

--7.4 CROSS
--Task: Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ARTIST
CROSS JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME ASC;