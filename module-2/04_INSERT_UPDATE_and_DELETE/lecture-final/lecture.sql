-- INSERT  
-- syntax: INSERT INTO table_name(list,of,columns,comma,delimited) VALUES(value,for,each,column,in,order), (another,row)

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
SELECT * FROM park;
INSERT INTO park(park_name,date_established,area,has_camping) --since park_id is the surrogate key, the database will assign automatically
VALUES('Disneyland','1955-07-17',2.1,false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) 
-- and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
SELECT * FROM city;

INSERT INTO city(city_name,population,state_abbreviation,area) --the columns can be in any order
VALUES ('Hawkins',30000,'IN',38.1),                            --but the value column order must ma
       ('Cicely', 839, 'AK', 11.4);                            --i can insert two rows at once with one statement

-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
-- INSERT USING A SELECT
INSERT INTO park_state(park_id,state_abbreviation)
SELECT park_id, 'CA'
FROM park
WHERE park_name = 'Disneyland';

SELECT * FROM park_state;
SELECT * FROM park;

-- UPDATE
-- UPDATE tablename SET column1=something, column2=something2 WHERE somecolumn=somethingelse

-- Change the state nickname of California to "The Happiest Place on Earth."
UPDATE state
SET state_nickname = 'The Happiest Place on Earch'
WHERE state_abbreviation = 'CA';

SELECT * FROM state WHERE state_abbreviation = 'CA';

-- Increase the population of California by 1,000,000.
UPDATE state
SET population = population+1000000
WHERE state_abbreviation = 'CA';

-- Change the capital of California to Anaheim. we can have subqueries
UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';


-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
--can update multiple columns at once - comma delim
UPDATE state
SET state_nickname = 'The Golden State',
    population = population-1000000,
	capital = (SELECT city_id FROM city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';

--create a new park that is in OH called bengals2023, date-established is today, area is 100 yes has camping
INSERT INTO park(park_name, date_established,area,has_camping)
VALUES('bengals2023',CURRENT_DATE,100,true);

--how do i make it in ohio?
INSERT INTO park_state(park_id, state_abbreviation)
SELECT park_id, 'OH'
FROM park
WHERE park_name = 'bengals2023';

--then tailgates got out of hand chagne has camping to false
UPDATE park
SET has_camping=false
WHERE park_name = 'bengals2023';

--everyone is rooting for the bengals, change the area to 5000
UPDATE park
SET area=5000
WHERE park_name = 'bengals2023';

-- DELETE
-- DELETE syntax: DELETE FROM tablename WHERE ...

-- Delete Hawkins, IN from the city table.
SELECT COUNT(*) FROM city; --349 after  delete is 347

DELETE 
--SELECT *
FROM city 
WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

-- Delete all cities with a population of less than 1,000 people from the city table.
DELETE
--SELECT *
FROM city
WHERE population < 1000;


-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city(city_name, state_abbreviation,population,area)
VALUES('Springfield','XX',1,1);

--all of the constraints for the state table
SELECT con.*
       FROM pg_catalog.pg_constraint con
            INNER JOIN pg_catalog.pg_class rel
                       ON rel.oid = con.conrelid
            INNER JOIN pg_catalog.pg_namespace nsp
                       ON nsp.oid = connamespace
       WHERE nsp.nspname = 'public'
             AND rel.relname = 'state';

-- Try deleting California from the state table.
DELETE
FROM state
WHERE state_abbreviation = 'CA';

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.

DELETE FROM park
WHERE park_name = 'Disneyland';

DELETE FROM park_state
WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland');

--now try again
DELETE FROM park
WHERE park_name = 'Disneyland';

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.
INSERT INTO city(city_name,state_abbreviation)
VALUES('Smallville','KS');

-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.
INSERT INTO city(city_name,state_abbreviation,area)
VALUES('Smallville','KS',1);

-- Retrieve the new record to confirm it has been given a default, non-null value for population.
SELECT * 
FROM city
WHERE city_name = 'Smallville';

-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).
UPDATE state
SET state_nickname = 'Vacationland'
WHERE state_abbreviation = 'CA';

-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).
UPDATE state
SET census_region = 'Southeast'
WHERE state_abbreviation = 'FL';


--UPDATE WITH JOIN
--update the state_nickname for KY to be the name of its capital
UPDATE state  --this is my first table
SET state_nickname = city_name
FROM city --there's no FROM since its the update so I use FROM instead of JOIN here
WHERE city_id = capital --but since I didn't use JOIN there's no ON so I have to match the columns in a WHERE
  AND state.state_abbreviation = 'KY';
  
SELECT * FROM state WHERE state_abbreviation = 'KY';

-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
START TRANSACTION;

DELETE 
FROM city
WHERE city_name = 'Smallville' 
  AND state_abbreviation = 'KS';
 
COMMIT;


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
START TRANSACTION;

DELETE FROM park_state; -- this is deleting everything!!!
SELECT COUNT(*) FROM park_state;

ROLLBACK TRANSACTION; 

SELECT COUNT(*) FROM park_state;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
START TRANSACTION;
UPDATE city SET state_abbreviation='TX';
SELECT city_name, state_abbreviation FROM city LIMIT 5;
ROLLBACK;
SELECT city_name, state_abbreviation FROM city LIMIT 5;

-- Demonstrate two different SQL connections trying to access the same table where one is 
-- inside of a transaction but hasn't committed yet.
START TRANSACTION;
INSERT INTO city(city_name, state_abbreviation, area, population)
VALUES ('Shrodingers city','NJ',0,0);

--no commit or rollback
SELECT * FROM city WHERE city_name = 'Shrodingers city';
ROLLBACK;
