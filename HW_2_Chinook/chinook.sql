/*Janine Lee 10/5/17 CHINOOK HW Assignment (2)*/

/*SQL Queries*/

/*Select statements: 1) gets all from Employee table, 
2)"" but with Lastname of King
3)"" but with Firstname of Andrew along with
Reporsto=null*/
SELECT * from EMPLOYEE;
SELECT * from EMPLOYEE where Lastname= 'King';

SELECT * from EMPLOYEE where Firstname= 'Andrew' 
UNION SELECT * from EMPLOYEE where 'REPORTSTO'= NULL;

/*Order by: 1) all from employee descending
2) Firstnames of customer, alphabetical from city*/
SELECT * from EMPLOYEE order by Title DESC;
SELECT FIRSTNAME from CUSTOMER order by CITY;

/*Insert into
1) Puts into table in category genre, 26, and into name, 'my_Inset_Genre
2)into table Employee...Employeid: 9, Firstname: 'Random Employee', Lastname: 'my_Insert_Employee'
3)into table customer...customerId:60, firstname:Random Customer, Lastname: my_insert_Customer, email:someEmail'*/
Insert into GENRE (GENREID, NAME) values (26, 'my_Insert_Genre');
Insert into EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) values (9,'Random Employee', 'my_Insert_Employee');
Insert into CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) values (60,'Random Customer', 'my_Insert_Customer', 'someEmail');

/*Update
changes in customer firstname Robert and lastname Walter to firstname Aaaron and lastname Michelle*/
Update CUSTOMER set FIRSTNAME='Robert', LASTNAME= 'Walter' where FIRSTNAME='Aaron' AND LASTNAME= 'Mitchell';
Update ARTIST set name='CCR' where name='Creedence Clearwater Revival'; 

/*Like... gets everything in invoice with a billingaddress containing T*/
SELECT * from INVOICE where BILLINGADDRESS like 'T%';

/*Between  1)invoice with total between 15 and 50
2)employee with hiredata in between june 1,2003- march 1, 2004*/
SELECT * from INVOICE where total between 15 and 50;
SELECT * from EMPLOYEE where HIREDATE between '01-june-2003' AND '01-mar-2004';

/*Delete
1) Dropped foreign key contraint in order to remove because it connected the child record
Then dropped foreign key for invoicecustomID
2)Deleted from customer with firstname Rober and lastname Walter*/
Alter table INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
Delete from CUSTOMER where FIRSTNAME='Robert' and LASTNAME='Walter';

/*SQL Functions*/

/*Defined Functions
1) got timestamp from dual
2) gets length of of the name from mediatype table*/
SELECT SYSTIMESTAMP AT TIME ZONE 'EST' FROM DUAL;
SELECT LENGTH(NAME)from MEDIATYPE;  

/*Aggregate Functions
1) gets average of the total from invoice, and changes the format to 00.0000
2) gets the max unitprice from table track*/
SELECT TO_CHAR(AVG(TOTAL) ,'00.0000')from INVOICE;
SELECT MAX(UNITPRICE) from TRACK;

/*User Defined Scalar Functions
1)Creates function unit_VL with arguements voice_Line1 and voice_Line1
This returns the average of the two arguements

gets average of unitprice of invoiceline*/

CREATE OR REPLACE FUNCTION unit_VL(voice_Line1 IN NUMBER, voice_Line2 IN NUMBER)
RETURN NUMBER
IS 
    VFINAL NUMBER;
BEGIN
    IF voice_Line1>voice_Line2 THEN
    VFINAL:=(voice_Line1+voice_Line2)/2; 
    ELSIF voice_Line1<voice_Line2 THEN
    VFINAL:=(voice_Line1+voice_Line2)/2;
    END IF;
    RETURN VFINAL;
END;

SELECT unit_VL(1,2) from dual; --test on getting averages

--geting avg invoiceline unitprices
SELECT TO_CHAR(AVG(UNITPRICE) ,'00.00')from INVOICELINE;
/*User Defined Table Valued Functions*/
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '01-Jan-68';
/*Store Procedures creates procedure on getting 
the firstname and lastname of the employee*/
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE(FIRSTNAME IN VARCHAR2, LASTNAME IN VARCHAR2)
    AS get_E SYS_REFCURSOR; --cursor get_Birth
BEGIN
    OPEN get_E for SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE; --uses cursor
END;

/*Triggers*/
/*After/for
-After inserting into employee, console outputs Inserting into Employee
-After inserting into album, console outputs Inserting into Album and
Updates the Album
-After Delete from customera, console outputs delete from customer*/
CREATE OR REPLACE TRIGGER t
BEFORE 
    INSERT INTO EMPLOYEE OR
    INSERT INTO ALBUM OR
    DELETE FROM EMPLOYEE
BEGIN
  CASE
    WHEN INSERTING INTO EMPLOYEE THEN
        DBMS_OUTPUT.PUT_LINE('Inserting into Employee');
    WHEN INSERTING INTO ALBUM THEN
        DBMS_OUTPUT.PUT_LINE('Inserting into Album');
        UPDATE ALBUM
    WHEN DELETE FROM CUSTOMER THEN
        DBMS_OUTPUT.PUT_LINE('Delete from customer');
    END CASE
END;
/*Joins*/
/*Inner joins table with cutomer's first and lastname, with invoiceid
based on customerid and invoiceid*/
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;
/*Outer joins table with cutomer's first and lastname, with invoice's id and total
based on customerid and invoiceid*/
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;
/*Right joins album title and artist name based on albumid and artistid*/
SELECT ALBUM.TITLE, ARTIST.NAME 
FROM ALBUM
RIGHT JOIN ARTIST ON ALBUM.ALBUMID = ARTIST.ARTISTID;
/*Cross join album title and artist name based on albumid and artistid
ordered by artist name ...note that use where instead of on*/
SELECT ALBUM.TITLE, ARTIST.NAME 
FROM ALBUM
CROSS JOIN ARTIST Where ALBUM.ALBUMID = ARTIST.ARTISTID
ORDER BY ARTIST.NAME;
/*Self joins firstname A and B of employees' based on reportsto
ordered by reportsto*/
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME
FROM EMPLOYEE A,EMPLOYEE B
WHERE A.REPORTSTO=B.EMPLOYEEID
ORDER BY A.REPORTSTO;