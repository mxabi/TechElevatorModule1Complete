-- INSERT
--syntax INSERT INTO table_name ( list, of, columns, comma, delimited)
--
-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
SELECT * FROM park;
INSERT INTO park(park_name, date_established, area, has_camping)
VALUES('Disneyland', '1955-07-17',2.1, false);

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
SELECT * FROM city
INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES('Hawkins', 'IN', 30000, 38.1), ('Cicely','AK',839,11.4);


-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
--Insert using select

INSERT INTO park_state ( park_id, state_abbreviation)
SELECT park_id, 'CA'
FROM park
WHERE park_name = 'Disneyland';

SELECT * FROM park_state
SELECT * FROM park

-- UPDATE

--Update tablename SET column1=something, column2 = something where somecolumn = something else

-- Change the state nickname of California to "The Happiest Place on Earth."
SELECT * from state
UPDATE state 
SET state_nickname = 'The Happiest Place on Earth' 
WHERE state_abbreviation = 'CA';

SELECT * from state 




-- Increase the population of California by 1,000,000.
UPDATE state
SET population = 1000000
WHERE state_abbreviation = 'CA'

Select * from state where state_abbreviation = 'CA'

-- Change the capital of California to Anaheim.
--we can have subqueries here

UPDATE state
SET capital = (SELECT city_id FROM city WHERE city_name = 'Anaheim' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';


-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.
--can update multiple columns at once

UPDATE state
SET state_nickname = 'The Golden State',
	population = population - 100000,
	capital = (SELECT city_id from city WHERE city_name = 'Sacramento' AND state_abbreviation = 'CA')
WHERE state_abbreviation = 'CA';	

select * FROM state where state_abbreviation = 'CA'

--create a new park that is in OH called Bengals 2023 
SELECT * FROM park;
INSERT INTO park(park_name, date_established, area, has_camping)
VALUES('Bengals 2023','02-18-2022', 100, true)

--then tailgates got out of hand change camping to false
--everyone is rooting for bengals change area to 800
UPDATE park 
SET has_camping = 'false',
	area = 5800
WHERE park_name = 'Bengals 2023'	

SELECT * from park






-- DELETE

--Delete syntax : DELETE FROM table_name WHERE

-- Delete Hawkins, IN from the city table.
DELETE 
from city 
WHERE city_name = 'Hawkins' AND state_abbreviation = 'IN';

SELECT COUNT(*) FROM city; -- 349 --> 347

-- Delete all cities with a population of less than 1,000 people from the city table.
SELECT * from city
DELETE 
FRom city
WHERE population < 1000;




-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.
INSERT INTO city(city_name, state_abbreviation, population, area)
VALUES('Springfield', 'XX', 1, 1);


-- Try deleting California from the state table.
DELETE 
FROM state
WHERE state_abbreviation = 'CA';

--gives error because state_abbreviation  is referenced in city
--cannot delete a state when a city is referenced to it 

-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.
SELECT * from park_state
DELETE
FROM park_state
WHERE park_id = (SELECT park_id FROM park WHERE park_name = 'Disneyland')

-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.


-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.


-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).


-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).



-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.
START  TRANSACTION;

DELETE 
FROM city
WHERE city_name = 'Smallville' AND state_abbreviation = 'KS';

COMMIT;

-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.
START TRANSACTION;

DELETE FROM park_state;
SELECT COUNT(*) FROM park_state;

ROLLBACK TRANSACTION;

SELECT COUNT(*) FROM park_state;

-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.
START TRANSACTION;
UPDATE city SET state_abbreviation = 'TX';
SELECT city_name, state_abbreviation from city LIMIT 5;
ROLLBACK TRANSACTION;
SELECT city_name, state_abbreviation from city LIMIT 5;


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
