-- comments
--A database is an organized collection of data that can be accessed, managed, updated
--Data in a realtional database can accessed and assembled in different ways
--Columns are called attributes
--Rows represent individual records
--Interact with the database by executing SQL statements
--ANSI SQL - will exeucte on any database (PostgreSQL, MS Sql Server, Oracle, etc)
--  every RDBMS also has some proprietary features and syntax

-- SELECT
-- Use a SELECT statement to return a literal string
SELECT 'hello world' AS message;

-- Use a SELECT statement to add two numbers together (and label the result "sum")
SELECT 1+1 AS sum;


-- SELECT ... FROM
-- Write queries to retrieve...

--SELECT comma delimited column list
--FROM table you want to select those columns from

-- The names from all the records in the state table
SELECT state_name 
FROM state; 

-- The names and populations of all cities
SELECT city_name, population
FROM city;

-- All columns from the park table
SELECT * --i'm not a huge fan of using the *, just select by column name and just what you need
FROM park;


-- use the WHERE clause to limit the number of rows
-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
SELECT city_name
FROM city
WHERE state_abbreviation = 'CA';

-- The names and state abbreviations of cities NOT in California
SELECT city_name, state_abbreviation
FROM city
WHERE state_abbreviation != 'CA'; --or state_abbreviation <> 'CA';

-- The names and areas of cities smaller than 25 square kilometers 
SELECT city_name, area
FROM city
WHERE area < 25;

-- The names from all records in the state table that have no assigned census region
SELECT state_name, census_region
FROM state
WHERE census_region IS NULL; 

-- The names and census regions from all records in the state table that have an assigned census region
SELECT state_name, census_region 
FROM state
WHERE census_region IS NOT NULL;

-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
SELECT city_name, area, population
FROM city
WHERE area < 25 AND population > 100000;


-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
SELECT state_name, census_region
FROM state
WHERE census_region != 'Midwest' OR census_region IS NULL;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)
SELECT city_name, area, population
FROM city
WHERE state_abbreviation = 'CA' OR state_name = 'FL';


-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
SELECT city_name, area, population
FROM city
WHERE state_abbreviation IN ('CT','ME','MA','NH','RI','VT');
--WHERE state_abbreviation = 'CT' OR state_abbreviatino = 'ME' OR state_abbreviation = 'MA' OR ...


-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_meters"
SELECT park_name, area, (area * 1000) AS area_in_meters
FROM park;

-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)
--345 rows returned
SELECT city_name
FROM city;

-- Do it again, but without the repeats (note the difference in row count)
--330 rows returned
SELECT DISTINCT city_name
FROM city;


-- LIKE, ILIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
SELECT city_name
FROM city
WHERE city_name LIKE 'A%';   --% is my wildcard character 


-- The names of all cities that end with "Falls"
SELECT city_name
FROM city
WHERE city_name LIKE '%Falls';

--the names of all cities that end with 'Falls' or 'falls' or 'FaLs'
SELECT city_name
FROM city
WHERE city_name ILIKE '%falls';

-- The names of all cities that contain a space
SELECT city_name
FROM city
WHERE city_name LIKE '% %';

--find city kansas city
SELECT city_name
FROM city
WHERE city_name ILIKE 'kansas city'; --the % are optional for the wildcard

-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers
SELECT park_name, area
FROM park
WHERE area BETWEEN 100 AND 200; 

--BETWEEN is inclusive
--equiv to
--WHERE area >= 100 AND area <=200;


-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900
SELECT park_name, date_established AS happy_tuesday
FROM park
WHERE date_established < '01-01-1900';
