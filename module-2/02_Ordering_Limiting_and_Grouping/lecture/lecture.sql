-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT population, state_name
FROM state
ORDER BY population DESC; --ORDER BY


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name ASC; --multiple can do a primary and secondary sort


-- The biggest park by area
SELECT park_name, area
FROM park
ORDER BY area DESC; -- order by column does not need to be in the select statement but it does have to exist in the table


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT city_name, population
FROM city
ORDER BY population DESC
LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
SELECT park_name, date_established
FROM park
ORDER BY date_established ASC, park_name ASC
LIMIT 20;

--we want the age to be in years
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name -- difference between dates is in days
From park
ORDER BY age_in_years DESC, park_name ASC -- can order by an alias
LIMIT 20;


--we want the next 20 oldest parks, so 21-40
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name -- difference between dates is in days
From park
ORDER BY age_in_years DESC, park_name ASC -- can order by an alias
LIMIT 20
OFFSET 20; -- skip first 20 rows from the results

-- we want parks 5-15 in age
SELECT (CURRENT_DATE - date_established)/365 AS age_in_years, park_name -- difference between dates is in days
From park
ORDER BY age_in_years DESC, park_name ASC -- can order by an alias
LIMIT 10
OFFSET 5; -- skip first 20 rows from the results, starts at 6


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || '(' || state_abbreviation || ')' AS city_state
from city
ORDER BY city_name;


-- The all parks by name and date established.
SELECT park_name || ' ' || '(' || date_established ||')' AS name_and_date
from park
ORDER BY date_established; 

-- The census region and state name of all states in the West & Midwest sorted in ascending order. censusregion: statename
select (upper(census_region), state_name) AS region_and_name
from state
WHERE census_region = 'West' OR census_region = 'Midwest'
ORDER BY census_region ASC;

-- AGGREGATE FUNCTIONS (AVG, SUM, COUNT, MIN, MAX)

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT round(AVG (population)) AS avg_state_pop
FROM state;

--round to 2 decimal places

-- Total population in the West and South census regions
SELECT sum(population) AS total_population
FROM state
WHERE census_region = 'West' OR census_region = 'South';

-- The number of cities with populations greater than 1 million
SELECT count(city) AS num_cities_over_million
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT count(state_nickname) AS state_with_nicknames
FROM state;

-- The area of the smallest and largest parks.
SELECT min(area) AS smallest_park, max(area) AS largest_park 
From park;



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
--group by state
SELECT COUNT(city_name) AS city_count, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY city_count DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT round(AVG(area)) AS avg_park_area, has_camping
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT sum(population) AS sum_city_population, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation ASC;

-- The smallest city population in each state ordered by city population.
SELECT min(population) AS min_city_population, state_abbreviation
FROM city
GROUP BY state_abbreviation
ORDER BY min_city_population DESC;

--Print state name and number of cities for states that have at least 10 cities 
SELECT state_abbreviation, COUNT(city_name) AS city_count
FROM city
GROUP BY state_abbreviation
HAVING COUNT(city_name) >=10 --limit rows AFTER the group by/aggregate is done, no aliases are allowed
ORDER BY city_count DESC; 

-- Print the state name fort states that have at least 2 cities with populations greater than 1 million
SELECT state_abbreviation, COUNT(city_name) AS count_city
FROM city
WHERE population > 1000000
GROUP BY state_abbreviation
HAVING COUNT(city_name) >=2 --having happens after the aggregate
ORDER BY state_abbreviation;

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
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY; -- change the offset to  10 to get the next 10 rows


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT state_abbreviation, COUNT(city_name) as city_count, (SELECT state_name FROM state WHERE state_abbreviation = city.state_abbreviation) AS state_name
FROM city
GROUP BY state_abbreviation;


-- Include the names of the smallest and largest parks
SELECT min(area) AS smallest_park, max(area) AS largest_park
From park;

SELECT park_name, area
FROM park
WHERE area = (SELECT min(area) FROM park) OR area = (SELECT max(area) FROM park);


-- List the capital cities for the states in the Northeast census region.
SELECT state_abbreviation, (SELECT city_name FROM city WHERE capital = city.city_id) AS capital_city
from state
WHERE census_region = 'Northeast'
ORDER BY state_abbreviation;
