/*
Index of topic name in this file:
1. Create Table
2. Describe Table
3. View Constraint
4. Select
5. Insert
6. Create Table As Select (CTAS)
7. And, Or, Like
8. Delete
9. Update
10. Alter Table
	10.1. add column
	10.2. drop column
	10.3. rename column
	10.4. rename table

11. Alter with Modify
	11.1. change column datatype/size
	11.2. set default value
	11.3. make column NOT NULL

12. Alter with add
	12.1. add new column
	12.1. add constraint
		12.1.1. check constraint
			12.1.1.1. pattern check
			12.1.1.2. length check
			12.1.1.3. value check

		12.1.2. primary key
		12.1.3. foreign key

13. Rename Table
14. Truncate Table
15. Drop Table
16. Distinct function
17. Between, Order By
18. Group By and Having
19. In, Not In, Is Null, Is Not Null
20. Aggregate functions (COUNT, AVG, SUM, MAX, MIN)
21. Numeric functions (ROUND, TRUNC, CEIL, FLOOR, MOD, ABS, SQRT, POWER)
22. String functions (LENGTH, UPPER, LOWER, INITCAP, SUBSTR, CONCAT, TRIM, REPLACE, TRANSLATE)
23. ASCII and CHR functions
24. SYSDATE , EXTRACT (), DATE FORMAT functions TO_CHAR (), TO_DATE ()

25. JOIN examples
26. Subquery example
27. Create View
28. Set operations (UNION, UNION ALL, INTERSECT, MINUS/EXCEPT)
29. Commit and Rollback
30. Savepoint

31. PL/SQL Block Structure
	31.1. PL/SQL Block Structure demo structure

32. sql operations in PLSQL block (select, insert, update, delete)
33. get value from user, if, elsif, else, end if
34. Math operations: +, -, *, /, MOD, POWER
35. switch case
36. Loops: basic loop, exit when, for loop, while loop, do while loop
37. reverse loop control
38. Pattern print using for loop
	38.1. pyramid pattern print using for loop
	38.2. triangle pattern print

39. prime number between 1 to 50
40. palindrome string & number
41. factorial of a number
42. fibonacci series

43. Exception Handling in PL/SQL
	43.1. NO_DATA_FOUND
	43.2. TOO_MANY_ROWS
	43.3. ZERO_DIVIDE
	43.4. OTHERS

44. Cursors in PL/SQL
	44.1. implicit cursor
	44.2. explicit cursor
	44.3. cursor with parameters
	44.4. cursor for loop


*/







-- create table syntax
CREATE TABLE table_name(
	Column_1_name Datatype(Size), 
	Column_2_name Datatype(Size), 
	Column_3_name Datatype(Size)
);

-- Ex. 
Create Table Student(
	rollno number(2),
	name varchar2(10),
	age number(2)
);

-- Create table with constraint 

CREATE TABLE student (
	rollno VARCHAR2(5) CHECK(rollno LIKE 'B%') PRIMARY KEY,
	name VARCHAR2(20) NOT NULL,
	pincode NUMBER(6) CHECK(LENGTH(pincode) = 6) NOT NULL,
	degree VARCHAR2(10) CHECK(degree IN('BCA', 'BCOM'))
);

-- foreign key 

CREATE TABLE teacher (
	t_id number(2) PRIMARY KEY,
	t_name varchar2(20),
	s_rollno number(2) References student(rollno) 
);

-- display table structure only 
DESC table_name;
Ex. 
DESC student;

-- view constraint
SELECT CONSTRAINT_NAME, CONSTRAINT_TYPE, TABLE_NAME FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'STUDENT'; -- TABLE_NAME in uppercase
SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = 'STUDENT'; -- NOTE: table name in uppercase

-- select 
select * from CLIENT_MASTER;
select * from CLIENT_MASTER where c_no='C003';
select C_NO, CLIENT_NAME from CLIENT_MASTER;

-- Insert 
INSERT INTO student_tab(rollno, name, age) VALUES (1, 'a', 18);

-- Insert multiple row
INSERT INTO student_tab VALUES (&rollno, '&name', &age);

-- AS keyword (create + as)
create table client1 as select * from CLIENT_MASTER; 						-- copy full table with data
create table client2 as select * from CLIENT_MASTER where 12=10; 		-- only table structure copy 
create table client5 as select C_NO, CLIENT_NAME from CLIENT_MASTER; -- only this (C_NO, CLIENT_NAME) column add on client5 table

-- insert record from another table  (work wen only both table structure is same (column name, Datatype, all are same))
insert into client4 select * from CLIENT_MASTER								-- insert all record CLIENT_MASTER to client4
insert into client4 select * from CLIENT_MASTER where c_no='C003'; 	-- insert only this 'C003' record from CLIENT_MASTER add on client4 table;

-- AND -- both condition true then 
Select name from Student WHERE age=20 AND Name Like 'B%'; 
Select name from Student WHERE (age=20 AND Name Like 'B%');	-- both query are same

-- OR 	-- any one condition true then 
-- LIKE in select (need to write WHERE keyword)
Select name from Student WHERE Name LIKE 'A%' OR Name Like 'B%'; 	

-- Delete 
Delete from student; -- it deletes all rows from the student table (but not the table structure). 
Delete from student WHERE Rollno=1;

-- Update
Update EMP SET salary = 50000; -- this Update all rows
Update EMP SET salary = 50000 WHERE salary > 20000;

-- ALTER
ALTER TABLE Student ADD city VARCHAR2(15);  -- adds new column
ALTER TABLE Student DROP COLUMN city;  -- deletes a column
ALTER TABLE Student RENAME COLUMN age TO student_age; -- renames a column
ALTER TABLE Student RENAME TO Students; -- renames the table

-- ALTER with MODIFY
ALTER TABLE Student MODIFY name VARCHAR2(20); -- changes column size/type
ALTER TABLE Student MODIFY rollno NUMBER(3); -- change data type/size
ALTER TABLE Student MODIFY age DEFAULT 18; -- set default value
ALTER TABLE Student MODIFY name NOT NULL; -- make column NOT NULL

ALTER TABLE Student ADD CONSTRAINT chk_roll CHECK(rollno > 0); -- add check constraint
ALTER TABLE Student ADD CONSTRAINT chk_name CHECK(name LIKE 'B%'); -- check pattern

ALTER TABLE Student ADD pincode NUMBER(6); -- add new column

ALTER TABLE Student ADD CONSTRAINT chk_pin CHECK(LENGTH(pincode)=6); -- check length

ALTER TABLE Student ADD degree VARCHAR2(10); -- add new column

ALTER TABLE Student ADD CONSTRAINT chk_deg CHECK(degree IN('BCA','BCOM'));-- check allowed values

ALTER TABLE Student ADD CONSTRAINT pk_student PRIMARY KEY(rollno); -- set primary key

ALTER TABLE Student ADD dept_id NUMBER(2); -- add foreign key column

ALTER TABLE Student ADD CONSTRAINT fk_dept FOREIGN KEY(dept_id) REFERENCES Department(dept_id); -- add foreign key

-- renames the table
RENAME Student TO Students; 

-- Truncate
Truncate Table student; -- deletes all rows only (not destroy table structure) 

-- Drop
Drop Table student; -- destroy table data and structure both

-- distinct function 
select distinct(deptno) from emp; -- Display only unique departments (deptno) from EMP table

-- BETWEEN, ORDER BY
SELECT * FROM Student WHERE age BETWEEN 18 AND 25; -- use of BETWEEN (number range)
SELECT * FROM Student ORDER BY age; -- ascending order by number
SELECT * FROM Student ORDER BY name; -- ascending order by varchar
SELECT * FROM Student ORDER BY age DESC; -- descending order by number
SELECT * FROM Student ORDER BY name DESC; -- descending order by varchar

-- GROUP BY and HAVING
SELECT dept_id, COUNT(*) FROM Student GROUP BY dept_id; -- group by dept_id and count students
SELECT dept_id, AVG(age) FROM Student GROUP BY dept_id HAVING AVG(age) > 20; -- group by dept_id with average age greater than 20

-- IN, NOT IN, IS NULL, IS NOT NULL
SELECT * FROM Student WHERE name IN ('Amit', 'Vijay', 'Rahul'); -- use of IN (multiple value check)
SELECT * FROM Student WHERE name NOT IN ('Amit', 'Vijay', 'Rahul'); -- use of NOT IN (multiple value check)
SELECT * FROM Student WHERE name IS NULL; -- check for NULL value
SELECT * FROM Student WHERE name IS NOT NULL; -- check for NOT NULL value

-- Aggregate functions
SELECT COUNT(*) FROM Student; -- count total rows in Student table
SELECT AVG(age) FROM Student; -- average age from Student table
SELECT SUM(age) FROM Student; -- sum of age from Student table
SELECT MAX(age) FROM Student; -- maximum age from Student table
SELECT MIN(age) FROM Student; -- minimum age from Student table

-- Numeric functions
SELECT name, ROUND(age, 0) FROM Student; -- round age to nearest integer
SELECT ROUND(5.68, 1) FROM dual; -- round to 1 decimal place, returns 5.7
SELECT ROUND(5.64, 1) FROM dual; -- round to 1 decimal place, returns 5.6
SELECT ROUND(5.66, 0) FROM dual; -- round to nearest integer, returns 6
SELECT ROUND(5.34, 0) FROM dual; -- round to nearest integer, returns 5

SELECT TRUNC(5.67) FROM dual; -- truncate decimal, returns 5
SELECT TRUNC(5.89, 1) FROM dual; -- truncate to 1 decimal place, returns 5.8
SELECT TRUNC(5.89, 0) FROM dual; -- truncate to integer, returns 5
SELECT TRUNC(5.12, 1) FROM dual; -- truncate to 1 decimal place, returns 5.1
SELECT TRUNC(5.12, 2) FROM dual; -- truncate to 2 decimal places, returns 5.12

SELECT name, CEIL(age) FROM Student; -- ceiling value of age
SELECT CEIL(5.12) FROM dual; -- ceiling value, returns 6
SELECT CEIL(5.89) FROM dual; -- ceiling value, returns 6

SELECT name, FLOOR(age) FROM Student; -- floor value of age
SELECT FLOOR(5.89) FROM dual; -- floor value, returns 5
SELECT FLOOR(5.12) FROM dual; -- floor value, returns 5

SELECT name, MOD(age, 5) FROM Student; -- modulus of age by 5
SELECT ABS(-10) FROM dual; -- absolute value, returns 10
SELECT SQRT(16) FROM dual; -- square root, returns 4
SELECT POWER(2, 3) FROM dual; -- power function, returns 8 (2^3)

-- String functions
SELECT name, LENGTH(name) FROM Student; -- get length of name column
SELECT name, UPPER(name) FROM Student; -- convert name to uppercase
SELECT name, LOWER(name) FROM Student; -- convert name to lowercase
SELECT INITCAP('This is a test string.') FROM dual; -- capitalize first letter of each word
SELECT name, SUBSTR(name, 1, 3) FROM Student; -- get substring of name (first 3 characters), SUBSTR(column, start_position, length)
SELECT SUBSTR('Hello World', 7, 5) FROM dual; -- returns 'World'
SELECT name, CONCAT(name, '_2024') FROM Student; -- concatenate '_2024' to name, returns name_2024
SELECT name, TRIM(name) FROM Student; -- trim spaces from name
SELECT TRIM('  Hello World  ') FROM dual; -- returns 'Hello World', removes extra spaces from both ends
SELECT name, REPLACE(name, 'a', '@') FROM Student; -- replace 'a' with '@' in name
SELECT TRANSLATE('abcdef', 'abc', '123') FROM dual; -- returns '123def', replaces a->1, b->2, c->3
SELECT TRANSLATE('12345', '126', 'ABC') FROM dual; -- returns 'AB345', replaces 1->A, 2->B, 6->C
SELECT TRANSLATE('12345','12','AB') FROM dual; -- returns 'AB345', replaces 1->A, 2->B
SELECt TRANSLATE('12345','12','A') FROM dual; -- returns 'A345', replaces 1->A, 2->(removed)

-- ASCII and CHR functions
SELECT name, ASCII(name) FROM Student; -- get ASCII value of first character of name
SELECT ASCII('A') FROM dual; -- get ASCII value of character 'A'
SELECT CHR(65) FROM dual; -- get character from ASCII value 65

-- SYSDATE , EXTRACT (), DATE FORMAT functions TO_CHAR (), TO_DATE ()
SELECT SYSDATE FROM dual; -- get current system date, eg. '12-FEB-2024 14:30:45'
SELECT name, EXTRACT(YEAR FROM SYSDATE) AS current_year FROM Student; -- extract current year
select to_char(dob, 'Month dd, yyyy') from Student_Master; -- format date of birth column ex. February  12, 1998
SELECT TO_CHAR(SYSDATE, 'DD-MON-YYYY') AS formatted_date FROM dual; -- format current date, date to string, returns e.g. '12-FEB-2024'
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') AS current_time FROM dual; -- format current time, date to string, returns time in 24-hour format eg. '14:30:45'
SELECT TO_CHAR(SYSDATE, 'Day, DDth Month YYYY HH24:MI:SS') AS full_format FROM dual; -- full date time format, returns e.g. 'Monday, 12th February 2024 14:30:45'
SELECT name, SYSDATE - TO_DATE('2000-01-01', 'YYYY-MM-DD') AS days_since_2000 FROM Student; -- days since 1st Jan 2000
-- TO_DATE() function use to string into a date value, Converts the text '2000-01-01' into a real DATE value (1st Jan 2000)

SELECT name, EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM dob) AS age FROM Student_Master; -- calculate age from date of birth






-- JOIN examples
SELECT s.name, t.t_name FROM Student s JOIN Teacher t ON s.rollno = t.s_rollno; -- inner join, JOIN by default means INNER JOIN in Oracle (and most SQL databases).
SELECT s.name, t.t_name FROM Student s LEFT JOIN Teacher t ON s.rollno = t.s_rollno; -- left join
SELECT s.name, t.t_name FROM Student s RIGHT JOIN Teacher t ON s.rollno = t.s_rollno; -- right join
SELECT s.name, t.t_name FROM Student s FULL JOIN Teacher t ON s.rollno = t.s_rollno; -- full join

-- 📋 Table 1: Students
-- ID | Name
-- 1  | John
-- 2  | Anna
-- 3  | Bob

-- 📋 Table 2: Marks
-- ID | Marks
-- 1  | 90
-- 3  | 85
-- 4  | 75

SELECT S.ID, S.Name, M.Marks FROM Students S INNER JOIN Marks M ON S.ID = M.ID; -- INNER JOIN → returns only matching IDs (common records from both tables)
-- ID | Name | Marks
-- 1  | John | 90
-- 3  | Bob  | 85
SELECT S.ID, S.Name, M.Marks FROM Students S LEFT JOIN Marks M ON S.ID = M.ID; -- LEFT JOIN → all students + matching marks, unmatched marks are NULL
-- ID | Name | Marks
-- 1  | John | 90
-- 2  | Anna | NULL
-- 3  | Bob  | 85
SELECT S.ID, S.Name, M.Marks FROM Students S RIGHT JOIN Marks M ON S.ID = M.ID; -- RIGHT JOIN → all marks + matching students, unmatched students are NULL
-- ID | Name | Marks
-- 1  | John | 90
-- 3  | Bob  | 85
-- 4  | NULL | 75
SELECT S.ID, S.Name, M.Marks FROM Students S FULL JOIN Marks M ON S.ID = M.ID; -- FULL JOIN → all rows from both tables, matched where possible, else NULL
-- ID | Name | Marks
-- 1  | John | 90
-- 2  | Anna | NULL
-- 3  | Bob  | 85
-- 4  | NULL | 75

-- 3 table join example, joining Student, Teacher, Department tables
SELECT s.name, t.t_name, d.dept_name FROM Student s
JOIN Teacher t ON s.rollno = t.s_rollno
JOIN Department d ON t.dept_id = d.dept_id;










-- Subquery example
SELECT name FROM Student WHERE rollno IN (SELECT s_rollno FROM Teacher WHERE t_name = 'John Doe'); -- subquery to find students taught by 'John Doe'

-- subquery with GROUP BY and HAVING
-- day-7 10. List the student detail whose total credit is same as that of `Kapil'
select fname from student where rollno in(
	select rollno from enroll group by rollno having sum(earn_credit) = (select sum(earn_credit) from enroll where rollno=(select rollno from student where fname='Kapil'))
); 
-- start from inner subquery to outer subquery to main query
-- first get rollno of kapil
-- then get total credit of kapil
-- then get rollno(s) whose total credit is same as kapil by group by rollno and having sum(earn_credit)=kapil's total credit
-- then get fname of those rollno(s) from student table by main query and use IN operator








-- create view
CREATE OR REPLACE VIEW Student_View AS SELECT name, age FROM Student; -- create view for all students
CREATE OR REPLACE VIEW Student_View AS SELECT name, age FROM Student WHERE age >= 18; -- create view for students aged 18 and above

create or replace view APPLICANT_view as select * from APPLICANT;
select * from APPLICANT_view; -- select through view
update APPLICANT_view set A_NAME='Dip' where A_NAME='Deepak'; -- update through view

drop view APPLICANT_view;	-- drop view

-- CASCADE CONSTRAINTS  -- table not dropped because of foreign key constraint, now we use CASCADE CONSTRAINTS
DROP TABLE Department CASCADE CONSTRAINTS; -- drop table along with its dependent constraints
-- means — when you drop the table, it also removes all related foreign key constraints in other tables that reference it.
-- For those tables and columns only the relationship is deleted, now that column behave like a normal column.


/*
General rules:
	- Both SELECT statements must return the same number of columns.
	- Corresponding columns must have compatible data types (or be cast).
	- Column order matters for matching rows; result column names come from the first SELECT.
	- The final result set has no guaranteed row order unless you use ORDER BY on the combined query.
	- You can apply ORDER BY only once, after the last SELECT of the set operation.

UNION:
	- Combines rows from both queries and returns only distinct (unique) rows.
	- Duplicate rows that appear in both queries are removed from the result.
	- Use when you want a combined list with duplicates eliminated.
	- Removing duplicates can be slower because the database must compare rows.

UNION ALL:
	- Combines rows from both queries and returns all rows, including duplicates.
	- Faster than UNION because it does not perform duplicate elimination.
	- Use when you want to preserve duplicates or when you know the results are already distinct.

INTERSECT:
	- Returns only the rows that appear in both queries (the intersection).
	- Duplicates are removed in the result (unless the DBMS supports INTERSECT ALL).
	- Use when you need the common records shared by both result sets.

MINUS / EXCEPT:
	- Returns rows from the first query that do NOT appear in the second query.
	- In many systems this is called EXCEPT; some systems use MINUS.
	- Duplicates are removed in the result (variants like EXCEPT ALL exist in some DBMS).
	- Use to find items present in one set but absent from another.

Performance tips:
	- Prefer UNION ALL when you do not need duplicate elimination.
	- Ensure appropriate indexing on the columns involved if joining or filtering before performing set operations.
	- If column types differ, CAST explicitly to avoid errors and make comparisons clear.
*/
-- Set operations
SELECT name FROM Student_A UNION SELECT name FROM Student_B; -- union of two student tables
SELECT name FROM Student_A UNION ALL SELECT name FROM Student_B; -- union all of two student tables
SELECT name FROM Student_A INTERSECT SELECT name FROM Student_B; -- intersection of two student tables
SELECT name FROM Student_A MINUS SELECT name FROM Student_B; -- difference of two student tables, records in Student_A but not in Student_B

-- Example tables for set operations
SQL> SELECT * FROM FYRankers;

 ENROL_NO   NAME             SPI
----------  ---------------- ----
         1  John Doe         8.2
         2  Jane Smith       7.5
         3  Emily Davis      6.9
         4  Michael Brown    8.7

SQL> SELECT * FROM SYRankers;

 ENROL_NO   NAME             SPI
----------  ---------------- ----
         3  Emily Davis      8.1
         4  Michael Brown    7.8
         5  Chris Lee        8.3
         6  Anna White       6.8

SQL> -- 1. Display the name of the student who is ranker in 'FY' or 'SY'
SELECT name FROM FYRankers UNION SELECT name FROM SYRankers; -- removes duplicate data, only unique names

NAME
--------------------
Anna White
Chris Lee
Emily Davis
Jane Smith
John Doe
Michael Brown

SQL> -- 2. Display the name of the student who is ranker in 'FY' or 'SY' including duplicate data
SELECT name FROM FYRankers UNION ALL SELECT name FROM SYRankers; -- all names including duplicates

NAME
--------------------
John Doe
Jane Smith
Emily Davis
Michael Brown
Emily Davis
Michael Brown
Chris Lee
Anna White

SQL> -- 3. Display the name of the students who is ranker in 'FY' or 'SY' and having SPI more than 7
SELECT name FROM FYRankers WHERE spi > 7 UNION SELECT name FROM SYRankers WHERE spi > 7;

NAME
--------------------
Chris Lee
Emily Davis
Jane Smith
John Doe
Michael Brown

SQL> -- 4. Display the name of the student who is ranker in both FY and SY
SELECT name FROM FYRankers INTERSECT SELECT name FROM SYRankers; -- common names in both tables

NAME
--------------------
Emily Davis
Michael Brown

SQL> -- 5. Display the name of the student who is ranker in FY but not in SY
SELECT name FROM FYRankers MINUS SELECT name FROM SYRankers; -- names in FY but not in SY

NAME
--------------------
Jane Smith
John Doe

SQL> -- 6. Display the name of the student who is ranker in SY but not in FY
SELECT name FROM SYRankers MINUS SELECT name FROM FYRankers; -- names in SY but not in FY

NAME
--------------------
Anna White
Chris Lee





-- Commit and Rollback
COMMIT; -- save changes
ROLLBACK; -- undo changes	

-- example of rollback
UPDATE Student SET age = age + 1 WHERE rollno = 1; -- update operation
select * from Student; -- verify the update
ROLLBACK; -- undo the update operation
select * from Student; -- verify rollback

-- Savepoint
SAVEPOINT sp1; -- create a savepoint	
ROLLBACK TO sp1; -- rollback to savepoint

-- 🧾 DEMO: SAVEPOINT & ROLLBACK in Oracle SQL


SELECT * FROM PRODUCT;
-- PROD_ID | PROD_NAME | PRICE
-- 1       | Product 1 | 10
-- 2       | Product 2 | 20
-- 3       | Product 3 | 30

-- 🧩 demo 1️⃣:
SAVEPOINT sp1; -- create SAVEPOINT sp1
UPDATE PRODUCT SET price = 100 WHERE prod_id = 1; -- change Product 1 → 100

SAVEPOINT sp2; -- create SAVEPOINT sp2
UPDATE PRODUCT SET price = 200 WHERE prod_id = 2; -- change Product 2 → 200

SELECT * FROM PRODUCT;
-- PROD_ID | PROD_NAME | PRICE
-- 1       | Product 1 | 100
-- 2       | Product 2 | 200
-- 3       | Product 3 | 30

ROLLBACK TO SAVEPOINT sp1; -- undo all after sp1 (both updates)
SELECT * FROM PRODUCT; -- noted that both updates are undo
-- PROD_ID | PROD_NAME | PRICE
-- 1       | Product 1 | 10    ← reverted
-- 2       | Product 2 | 20    ← reverted
-- 3       | Product 3 | 30


-- 🧩 demo 2️⃣:
SAVEPOINT sp1; -- create SAVEPOINT sp1
UPDATE PRODUCT SET price = 100 WHERE prod_id = 1; -- change Product 1 → 100

SAVEPOINT sp2; -- create SAVEPOINT sp2
UPDATE PRODUCT SET price = 200 WHERE prod_id = 2; -- change Product 2 → 200

SELECT * FROM PRODUCT;
-- PROD_ID | PROD_NAME | PRICE
-- 1       | Product 1 | 100
-- 2       | Product 2 | 200
-- 3       | Product 3 | 30

ROLLBACK TO SAVEPOINT sp2; -- undo only changes after sp2 (none yet, so Product 2 undo)
SELECT * FROM PRODUCT;
-- PROD_ID | PROD_NAME | PRICE
-- 1       | Product 1 | 100  ← kept (before sp2)
-- 2       | Product 2 | 20   ← reverted (after sp2)
-- 3       | Product 3 | 30


-- ✅ Summary:
-- sp1 → marks start point
-- sp2 → marks point after product 1 update
-- rollback to sp1 → undo all updates (both)
-- rollback to sp2 → undo only changes after sp2 (product 2 only)

-- You can have multiple savepoints active at the same time.
-- They don’t “end” automatically — they stay valid until:
-- 	You rollback to them (which removes newer savepoints), or
-- 	You commit or rollback the whole transaction.





-- PL/SQL Block Structure


set serveroutput on; -- enable DBMS_OUTPUT


--- PL/SQL Block Structure with Exception Handling
DECLARE
	-- Declaration section: declare variables, constants, cursors, exceptions
	v_student_name VARCHAR2(50);
	v_student_age NUMBER;
BEGIN
	-- Execution section: procedural code, control structures, loops, sql operations (insert, update, delete, select)
	SELECT name, age INTO v_student_name, v_student_age FROM Student WHERE rollno = 1;
	DBMS_OUTPUT.PUT_LINE('Student Name: ' || v_student_name);
	DBMS_OUTPUT.PUT_LINE('Student Age: ' || v_student_age);
EXCEPTION
	-- Exception handling section: handle exceptions/errors
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('No student found with the given roll number.');
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END;
/


-- sql operations in PLSQL block (select, insert, update, delete)
-- Write a PLSQL block to display total number of products ordered in Order_ID = 3
DECLARE
	total_products NUMBER;
BEGIN
	SELECT COUNT(prod_id) INTO total_products FROM ORDER_DETAILS WHERE ORDER_ID = 3;
	DBMS_OUTPUT.PUT_LINE('Total number of products in Order_ID 3: ' || total_products);
END;
/

-- Write a PLSQL block to insert any product whose cat_id = 3
BEGIN
	INSERT INTO PRODUCTS (Prod_ID, Prod_Name, Supplier_ID, Cat_ID, Unit, Price) VALUES (3, 'Product 3', 103, 3, 'Pack', 30);
END;

-- Write a PLSQL block to update the price (actual price + 5) of product with Id = 2
BEGIN
	UPDATE PRODUCTS SET PRICE = PRICE + 5 WHERE PROD_ID = 2;
END;
/

-- Write a PLSQL block to delete the products of Cat_Id = 3
BEGIN
	DELETE FROM PRODUCTS WHERE CAT_ID = 3;
END;
/

-- Write a PLSQL block to display Supplier_Id and their total number of products they supply
BEGIN
	dbms_output.put_line('SUPPLIER_ID	TOTAL_PRODUCTS');
	dbms_output.put_line('--------------------------------');
	for data in(select Supplier_ID, count(Prod_ID) as total_products from PRODUCTS group by Supplier_ID)
	loop
		dbms_output.put_line('	' || data.Supplier_ID || '		' || data.total_products);
	end loop;
END;
/


-- get value from user
-- if, elsif, else, end if
-- AND (both true), OR (any one true)
-- comparison operators: =, !=, <>, >, <, >=, <=

-- find max of 3 numbers
DECLARE
	n1 NUMBER;
	n2 NUMBER;
	n3 NUMBER;
BEGIN
	-- get input from user
	n1 := &n1;
	n2 := &n2;
	n3 := &n3;
	-- find max
	IF n1 >= n2 AND n1 >= n3 THEN
		DBMS_OUTPUT.PUT_LINE('Maximum is: ' || n1);
	elsif n2 >= n3 THEN
		DBMS_OUTPUT.PUT_LINE('Maximum is: ' || n2);
	ELSE
		DBMS_OUTPUT.PUT_LINE('Maximum is: ' || n3);
	END IF;
END;
/


-- math operations: +, -, *, /, MOD, POWER
-- calculator program
DECLARE
	num1 NUMBER;
	num2 NUMBER;
	op VARCHAR2(1);
	result NUMBER;
BEGIN
	-- get input from user
	num1 := &num1;
	num2 := &num2;
	dbms_output.put_line('Enter operator (+, -, *, /, MOD, POWER): ');
	op := '&op';
	-- perform operation
	IF op = '+' THEN
		result := num1 + num2;
	ELSIF op = '-' THEN
		result := num1 - num2;
	ELSIF op = '*' THEN
		result := num1 * num2;
	ELSIF op = '/' THEN
		IF num2 != 0 THEN
			result := num1 / num2;
		ELSE
			DBMS_OUTPUT.PUT_LINE('Error: Division by zero');
			RETURN;
		END IF;
	ELSIF op = 'MOD' THEN
		result := MOD(num1, num2);
	ELSIF op = 'POWER' THEN
		result := POWER(num1, num2);
	ELSE
		DBMS_OUTPUT.PUT_LINE('Error: Invalid operator');
		RETURN;
	END IF;
	-- display result
	DBMS_OUTPUT.PUT_LINE('Result: ');
	DBMS_OUTPUT.PUT_LINE(num1 || ' ' || op || ' ' || num2 || ' = ' || result);
END;
/ 



-- calculate marks of 3 subjects and percentage
DECLARE
	name varchar2(50);
	s1 NUMBER;
	s2 NUMBER;
	s3 NUMBER;
	total NUMBER;
	per NUMBER;
BEGIN
	-- get input from user
	name := '&name';
	s1 := &s1;
	s2 := &s2;
	s3 := &s3;
	-- calculate total and percentage
	total := s1 + s2 + s3;
	per := (total / 300) * 100;
	-- display result
	DBMS_OUTPUT.PUT_LINE('Student Name: ' || name);
	DBMS_OUTPUT.PUT_LINE('Total Marks: ' || total);
	DBMS_OUTPUT.PUT_LINE('Percentage: ' || per || '%');
END;
/

-- switch case example
-- Calculate the grade of all students, based to total (>70 AA, >60 A, >50 B, >35 C, else Fail)
BEGIN
	update student1 set grade=
	case
		when total>270 then 'AA'
		when total>250 then 'A'
		when total>200 then 'B'
		when total>150 then 'C'
	else 'Fail'
	end;
END;
/

-- loops: basic loop, exit when, for loop, while loop, do while loop
-- basic loop, exit when, print 1 to 10
DECLARE
	i NUMBER := 1; -- Initialize counter variable
BEGIN
	loop
		EXIT WHEN i > 10; -- Exit loop when counter exceeds 10
		DBMS_OUTPUT.PUT_LINE(i); -- Print the current value of counter
		i := i + 1; -- Increment counter
	END LOOP;
END;
/

-- for loop, print 1 to 10 odd numbers
DECLARE
BEGIN
	FOR i IN 1..10 LOOP
		IF MOD(i, 2) = 1 THEN -- Check if the number is odd
			DBMS_OUTPUT.PUT_LINE(i); -- Print the odd number
		END IF;
	END LOOP;
END;
/

-- while loop, print 1 to 10
DECLARE
	i NUMBER := 1; -- Initialize counter variable
BEGIN
	WHILE i <= 10 LOOP -- Continue loop while counter is less than or equal to 10
		DBMS_OUTPUT.PUT_LINE(i); -- Print the current value of counter
		i := i + 1; -- Increment counter
	END LOOP;
END;
/

-- do while loop, print 1 to 10
DECLARE
	i NUMBER := 1; -- Initialize counter variable
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE(i); -- Print the current value of counter
		i := i + 1; -- Increment counter
		EXIT WHEN i > 10; -- Exit loop when counter exceeds 10
	END LOOP;
END;
/

-- divisible by 3 between 4 to 40
DECLARE
	i NUMBER;
BEGIN
	FOR i IN 4..40 LOOP
		IF MOD(i, 3) = 0 THEN
			DBMS_OUTPUT.PUT_LINE(i);
		END IF;
	END LOOP;
END;


-- reverse loop control
-- reverse for loop, print 10 to 1
DECLARE
BEGIN
	FOR i IN REVERSE 1..10 LOOP
		DBMS_OUTPUT.PUT_LINE(i); -- Print the current value of counter
	END LOOP;
END;


-- pattern print using for loop

-- pyramid pattern print using for loop
declare
	i number;
	j number;
begin
	for i in 1..5 loop
		for j in 1..5 loop
			if i>=j then
				dbms_output.put('* '); -- use put to stay on same line
			end if;
		end loop;
		dbms_output.put_line(''); -- use put_line to move to next line
	end loop;
end;
/

-- triangle pattern print (not pyramid)
DECLARE
	i NUMBER;
	j NUMBER;
BEGIN
	FOR i IN 1..5 LOOP
		for j IN i..5 LOOP
			DBMS_OUTPUT.PUT(' '); -- use put to stay on same line
		END LOOP;
		FOR j IN 1..i LOOP
			DBMS_OUTPUT.PUT('* '); -- use put to stay on same line
		END LOOP;
		DBMS_OUTPUT.PUT_LINE(''); -- use put_line to move to next line
	END LOOP;
END;
/

-- prime number between 1 to 50
DECLARE
	i NUMBER;
	j NUMBER;
	flag BOOLEAN;
BEGIN
	for i in 1..50 loop
		flag:=true;
		for j in 2..TRUNC(SQRT(i)) loop -- start from 2 to sqrt(i)
			if MOD(i,j)=0 then -- mod is 0 means not prime
				flag:=false;
			end if;
		end loop;
		if flag THEN
			DBMS_OUTPUT.PUT_LINE(i);
		END IF;
	END LOOP;
END;
/
-- 2..TRUNC(SQRT(i)) - check divisibility up to sqrt(i), TRUNC(SQRT(i)) to avoid decimal, EX. SQRT(10)=3.16, TRUNC(3.16)=3, basic logic of prime number, no need to check beyond sqrt(i)


-- palindrome string check
DECLARE
	str VARCHAR2(20);
	str_rev VARCHAR2(20);
BEGIN
	str := '&str'; -- input string, ex. wow
	for i IN REVERSE 1..LENGTH(str) LOOP
		str_rev := str_rev || SUBSTR(str, i, 1); -- concatenate characters in reverse order
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('original string: ' || str);
	DBMS_OUTPUT.PUT_LINE('reverse string: ' || str_rev);
	IF str = str_rev THEN
		DBMS_OUTPUT.PUT_LINE('palindrome string');
	ELSE
		DBMS_OUTPUT.PUT_LINE('not palindrome string');
	END IF;
END;
/

-- palindrome number check
DECLARE
	num NUMBER := &num; -- 121
	num_rev NUMBER := 0;
	num_copy NUMBER := num;
	rem NUMBER;
BEGIN
	WHILE num_copy > 0 LOOP
		rem := MOD(num_copy, 10);
		num_rev := rem + (num_rev * 10);
		num_copy := TRUNC(num_copy / 10);
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('original number: ' || num);
	DBMS_OUTPUT.PUT_LINE('reverse number: ' || num_rev);
	IF num = num_rev THEN
		DBMS_OUTPUT.PUT_LINE('palindrome number');
	ELSE
		DBMS_OUTPUT.PUT_LINE('not palindrome number');
	END IF;
END;


-- factorial of a number
DECLARE
	num NUMBER := &num; -- input number, ex. 5
	fact NUMBER := 1;
BEGIN
	FOR i IN 1..num LOOP
		fact := fact * i;
	END LOOP;
	DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is: ' || fact);
END;

-- fibonacci series
DECLARE
	n NUMBER := &n; -- number of terms, ex. 10
	a NUMBER := 0;
	b NUMBER := 1;
	next_term NUMBER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('Fibonacci Series:');
	FOR i IN 1..n LOOP
		DBMS_OUTPUT.PUT(a || ' ');
		next_term := a + b;
		a := b;
		b := next_term;
	END LOOP;
END;


-- Exception Handling
-- predefined exceptions: NO_DATA_FOUND, TOO_MANY_ROWS, ZERO_DIVIDE, OTHERS
DECLARE
	num1 NUMBER := &num1; -- input numerator
	num2 NUMBER := &num2; -- input denominator
	result NUMBER;
BEGIN
	result := num1 / num2;
	DBMS_OUTPUT.PUT_LINE('Result: ' || result);
EXCEPTION
	WHEN ZERO_DIVIDE THEN
		DBMS_OUTPUT.PUT_LINE('Error: Division by zero is not allowed.');
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/

-- NO_DATA_FOUND example
DECLARE
	v_student_name VARCHAR2(50);
BEGIN
	SELECT name INTO v_student_name FROM Student WHERE rollno = -1; -- invalid rollno
	DBMS_OUTPUT.PUT_LINE('Student Name: ' || v_student_name);
EXCEPTION
	WHEN NO_DATA_FOUND THEN
		DBMS_OUTPUT.PUT_LINE('Error: No student found with the given roll number.');
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);
END;
/

-- TOO_MANY_ROWS example
DECLARE
	v_student_name VARCHAR2(50);
BEGIN
	SELECT name INTO v_student_name FROM Student; -- assuming multiple rows exist
	DBMS_OUTPUT.PUT_LINE('Student Name: ' || v_student_name);
EXCEPTION
	WHEN TOO_MANY_ROWS THEN
		DBMS_OUTPUT.PUT_LINE('Error: More than one student found.');
	WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('An unexpected error occurred: ' || SQLERRM);	
END;
/

-- user-defined exceptions example

-- write a user defined exception for above program where if age is less than 18 then appropriate error message must be shown as exception.
DECLARE
	name varchar2(15);
	s1 number;
	s2 number;
	s3 number;
	total number;
	per number;
	negativeMark exception;
BEGIN
	name := '&name';
	s1 := &s1;
	s2 := &s2;
	s3 := &s3;
	IF s1 < 0 OR s2 < 0 OR s3 < 0 THEN
		RAISE negativeMark; -- raise exception, raise keyword to trigger exception
	END IF;
	total := s1 + s2 + s3;
	per := total / 3;
	DBMS_OUTPUT.PUT_LINE('Student name: ' || name);
	DBMS_OUTPUT.PUT_LINE('Total marks: ' || total);
	DBMS_OUTPUT.PUT_LINE('Percentage: ' || per);
EXCEPTION
	WHEN negativeMark THEN
		DBMS_OUTPUT.PUT_LINE('Marks less than zero! Negative marks not allowed');
END;
/




-- Cursor 
-- implicit cursor example
/*

 1  -- normal cursor
  2  declare
  3  	j varchar2(15);
  4  	s number;
  5  	cursor cur1 is select job,sal from emp;
  6  begin 
  7  open cur1;
  8  	loop
  9  		fetch cur1 into j,s;
 10  		exit when cur1%NOTFOUND;
 11  		dbms_output.put_line(j || '		' ||s);
 12  	end loop;
 13  close cur1;
 14* end;
SQL> /

 1  -- cursor with parameater
  2  declare
  3     j varchar2(15);
  4     s number;
  5     cursor cur1(salary number) is select job,sal from emp where sal>salary; -- sal>salary this salary value from call argument
  6  begin
  7  open cur1(1500);
  8     loop
  9             fetch cur1 into j,s;
 10             exit when cur1%NOTFOUND;
 11             dbms_output.put_line(j || '             ' ||s);
 12     end loop;
 13  close cur1;
 14* end;



   1  -- cursor with parameater
  2  declare
  3     nm varchar2(12);
  4     j varchar2(15);
  5     s number;
  6     -- if you dot know which datatype of 'ename' than use 'emp.ename%type'
  7     cursor cur1(name emp.ename%type) is select ename,job,sal from emp where ename=name; 
  8  begin
  9  open cur1('SMITH');
 10     loop
 11             fetch cur1 into nm,j,s;
 12             exit when cur1%NOTFOUND;
 13             dbms_output.put_line(nm || '    ' || j || '    ' || s);
 14     end loop;
 15  close cur1;
 16* end;
SQL> /


SET SERVEROUTPUT ON;

DECLARE
    -- Outer cursor: gets each department
    CURSOR cur_dept IS SELECT deptno, dname FROM dept;

    -- Inner cursor: gets employees for a specific department
    CURSOR cur_emp(p_deptno dept.deptno%TYPE) IS 
        SELECT ename, job, sal 
        FROM emp 
        WHERE deptno = p_deptno;

    v_deptno dept.deptno%TYPE;
    v_dname  dept.dname%TYPE;
    v_ename  emp.ename%TYPE;
    v_job    emp.job%TYPE;
    v_sal    emp.sal%TYPE;
BEGIN
    OPEN cur_dept;
    LOOP
        FETCH cur_dept INTO v_deptno, v_dname;
        EXIT WHEN cur_dept%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Department: ' || v_dname || ' (' || v_deptno || ')');
        DBMS_OUTPUT.PUT_LINE('-------------------------------------');

        OPEN cur_emp(v_deptno);
        LOOP
            FETCH cur_emp INTO v_ename, v_job, v_sal;
            EXIT WHEN cur_emp%NOTFOUND;
            DBMS_OUTPUT.PUT_LINE('   ' || v_ename || ' | ' || v_job || ' | ' || v_sal);
        END LOOP;
        CLOSE cur_emp;

        DBMS_OUTPUT.PUT_LINE(''); -- blank line between departments
    END LOOP;
    CLOSE cur_dept;
END;
/


*/