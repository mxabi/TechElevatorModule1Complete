-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT state_name, population
FROM state
ORDER BY population DESC;  --ORDER BY column name

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC; --can do a primary and secondary sort; comma delimited

-- The biggest park by area
SELECT park_name
FROM park
ORDER BY area DESC; --my order by column doesn't have to be in the select statement, but it does have to exist on the table


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;  --LIMIT is not ANSI Standard, it won't work on SQL Server, it's postgreSQL specific

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established
FROM park
ORDER BY date_established ASC, park_name ASC  --sorting by name doesn't do a lot unless parks were on exact same day
LIMIT 20;

--we want the age to be in years
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name  --difference between dates is in days
FROM park
ORDER BY age_in_years DESC, park_name ASC --we are allowed to order by an alias, park name sort only comes into play if parks were in same year
LIMIT 20;

--if we do a calculation and don't alias the column, the name is ?column? in the results
SELECT (CURRENT_DATE - date_established)/365 , park_name  --difference between dates is in days
FROM park;

--we want the "next" 20 oldest parks, so 21-40
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name  --difference between dates is in days
FROM park
ORDER BY age_in_years DESC, park_name ASC --we are allowed to order by an alias, park name sort only comes into play if parks were in same year
LIMIT 20
OFFSET 20; --skip the first 20 rows from the results

--we want parks 5-15 in age
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name  --difference between dates is in days
FROM park
ORDER BY age_in_years DESC, park_name ASC --we are allowed to order by an alias, park name sort only comes into play if parks were in same year
LIMIT 10 --limit the resuls to 10
OFFSET 5; --skip the first 5 rows from the results

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- concatenate with ||
SELECT city_name || ' (' || state_abbreviation || ')' AS city_state
FROM city
ORDER BY city_name;

-- The all parks by name and date established. Name: parkname Date Established: 
SELECT ('Name: ' || park_name || ' Date Established: ' || date_established) as park_date
FROM park
ORDER BY park_name;

-- The census region and state name of all states in the West & Midwest sorted in ascending order. censusregion: statename
SELECT (upper(census_region) || ': ' || state_name) AS region_and_state
FROM state
WHERE census_region ILIKE '%west'
ORDER BY region_and_state;
-- ORDER BY census_region, state_name; -- Alternative producing the same results

-- AGGREGATE FUNCTIONS AVG, SUM, COUNT, MIN, MAX
--Aggregate without a group by does it on the whole result set, but we can filter the result set first using WHERE

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population) AS avg_state_pop
FROM state;

--round to 2 decimal places
SELECT round(AVG(population),2) AS avg_state_pop
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population) AS sum_pop
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT COUNT(population) AS count_big
--count(*) vs count(column) only have different results if the column contains nulls. * will include nulls, column will not
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT COUNT(*) AS state_with_nicknames
FROM state
WHERE state_nickname IS NOT NULL; --limit the result set first to not include state_nickname of null

SELECT COUNT(state_nickname) --this will only include where state_nickname is not null
FROM state;

SELECT COUNT(*) --counting all rows
FROM state; 

--FAILS - if i have an aggregate it's smushing all rows into one so i can't have any column values other than other aggregates
--SELECT COUNT(state_nickname), state_abbreviation
--FROM state;

-- The area of the smallest and largest parks.
SELECT MIN(area) AS smallest, MAX(area) AS largest
FROM park;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
--group by the state
--I'm allowed to select columns that I've grouped by
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
--WHERE goes here if you have one
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY (has_camping);

--i could figure this out with two queries without the group by
SELECT AVG(area) AS avg_has_camping_area
FROM park
WHERE has_camping;

SELECT AVG(area) AS avg_has_camping_area
FROM park
WHERE has_camping = false;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population) AS sum_pop
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city_pop
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city_pop;


--HAVING (filter final results based on AGGREGATE columns)

-- Count the number of cities in each state, ordered from most cities to least
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
--WHERE goes here if you have one
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Print state name and number of cities for states that have at least 10 cities in the database
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
--WHERE goes here if you have one - this limits rows BEFORE the group by/aggregate is done
GROUP BY state_abbreviation
HAVING COUNT(city_name) >= 10  --limits rows AFTER the group by/aggregate is done, no aliases are allowed
ORDER BY city_count DESC;

--Print the state abbreviation for states that have at least two cities with a population over 1 million
SELECT state_abbreviation, COUNT(city_name) AS count_city
FROM city
WHERE population > 1000000  --limit the results before the aggreagate
GROUP BY state_abbreviation
HAVING COUNT(city_name) >= 2  --having happens after the aggregate
ORDER BY state_abbreviation; 

--nonsense query to test
SELECT state_abbreviation, COUNT(city_name) AS count_city
FROM city
WHERE population > 1000000  --limit the results before the aggreagate
GROUP BY state_abbreviation
HAVING SUM(population) >= 2  --having happens after the aggregate, and can include any aggregate
ORDER BY state_abbreviation; 

--SELECT
--FROM
--WHERE
--GROUP BY
--HAVING
--ORDER BY 

-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, population
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;  --change the offset to 10 to get the next 10 rows


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT state_abbreviation, COUNT(city_name) AS city_count, 
  ( SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation ) AS state_name
FROM city
GROUP BY state_abbreviation;

--accessing the column by table.column is only necesary if there are two tables present in the query otherwise it's implied
SELECT city.city_name, city.state_abbreviation
FROM city;

-- Include the names of the smallest and largest parks
SELECT MIN(area), MAX(area)
FROM park;

SELECT park_name, area
FROM park
WHERE area = ( SELECT MIN(area) FROM park )
   OR area = ( SELECT MAX(area) FROM park );
   



-- List the capital cities for the states in the Northeast census region.
SELECT state_abbreviation, city_name
FROM city
WHERE city_id IN 
  (SELECT capital FROM state WHERE census_region = 'Northeast')
ORDER BY state_abbreviation; 

SELECT state_abbreviation, (SELECT city_name FROM city WHERE city.city_id = state.capital)
FROM state
WHERE census_region = 'Northeast'
ORDER BY state_abbreviation;


