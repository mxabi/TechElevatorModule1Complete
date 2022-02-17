-- 1. The name and population of all cities in Ohio (OH) (6 rows)
SELECT city_name, population
FROM city
WHERE state_abbreviation = 'OH';
-- 2. The name and area of all cities in Pennsylvania (PA) (4 rows)
SELECT city_name, area
FROM city 
WHERE state_abbreviation = 'PA';
-- 3. The name, population, and sales tax of the states in the "West" census region (13 rows)
SELECT state_name, population, sales_tax
FROM state
WHERE census_region = 'West';
-- 4. The name, population, and nickname of the states in the "Northeast" census region (9 rows)
SELECT state_name, population, state_nickname
FROM state
WHERE census_region = 'Northeast';
-- 5. The name, state abbreviation, and population of cities with a population greater than 1,000,000 people (10 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE population > 1000000;
-- 6. The name, abbreviation, population, and area of states with an area greater than 200,000 square kilometers (16 rows)
SELECT state_name, state_abbreviation, population, area
FROM state
WHERE area > 200000;
-- 7. The name, date established, and area of parks with an area less than 100 square kilometers (6 rows)
SELECT park_name, date_established, area
FROM park
WHERE area < 100;

-- 8. The name and population of cities in California (CA) with a population less than 150,000 people (37 rows)
SELECT city_name, population
FROM city
WHERE state_abbreviation = 'CA' AND population < 150000;
-- 9. The name, abbreviation, population, and sales tax of all states and territories with a sales tax greater than 6.6% (9 rows)
SELECT state_name, state_abbreviation, population, sales_tax
FROM state
WHERE sales_tax > 6.6;
-- 10. The name and area of parks that have an area less than or equal to 700 square kilometers and provides camping (21 rows)
SELECT park_name, area, has_camping
FROM park
WHERE area <= 700 AND has_camping;

-- 11. The name, state, and population of all cities in Colorado (CO) or Arizona (AZ) (22 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE state_abbreviation = 'CO' OR state_abbreviation = 'AZ';

-- 12. The state name, nickname, and sales tax from records in the state table in the "West" and "South" census regions with a sales tax that isn't 0% (26 rows)
SELECT state_name, state_nickname, sales_tax, census_region
FROM state
WHERE sales_tax !=0 AND census_region IN ('WEST', 'SOUTH');

-- 13. The name, abbreviation, and population of all records in the state table with no official nickname (NULL) (5 rows)
SELECT state_name, state_abbreviation, population, state_nickname
FROM state
WHERE state_nickname IS NULL; 

-- 14. The state name, nickname, and census region for states that start with the word "New" (4 rows)
SELECT state_name, state_nickname, census_region
FROM state
WHERE state_name LIKE 'New%';

-- 15. The name, state abbreviation, and population for cities that end with the word "City" (11 rows)
SELECT city_name, state_abbreviation, population
FROM city
WHERE city_name LIKE '%City';

-- 16. The name, date established, and area of parks that contain the string "Canyon" anywhere in the name (5 rows)
SELECT park_name, date_established, area
FROM park
WHERE park_name LIKE '%Canyon%';

-- 17. The name, population, and area of all records in the state table with no census region (NULL) and area less than 5000 square kilometers (3 rows)
SELECT state_name, population, area
FROM state
WHERE census_region IS NULL AND area < 5000; 

-- 18. The name, population, and sales tax of all records in the state table with a sales tax of at least 7% or have a population of less than 1,000,000 (17 rows)
SELECT state_name, population, sales_tax
FROM state
WHERE sales_tax >=7 OR population <=1000000;

-- 19. The name, population, area, and population density (name the column 'population_density') of all states, territories, and districts (56 rows)
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
SELECT state_name, population, area, population/area AS population_density
FROM state;

-- 20. The name, population, area, and population density (name the column 'population_density') of states, territories, and districts with more than 100 people per square kilometer (12 rows)
-- Population density is expressed as people per square kilometer. In other words, population divided by area.

SELECT state_name, population, area, population/area AS population_density
FROM state
WHERE population/area > 100;

-- 21. The name and nickname for all records in the state table with no official nickname (NULL) or nickname starts with the word "The" (13 rows)
SELECT state_name, state_nickname
FROM state
WHERE state_nickname IS NULL OR state_nickname LIKE 'The%';

-- 22. The name and sales tax for states and territories with sales tax greater than or equal to 2% and less than or equal to 5% (15 rows)
SELECT state_name, sales_tax
FROM state
WHERE sales_tax BETWEEN 2 AND 5;

-- 23. The name and date established of parks opened in the 1960s (6 rows)
SELECT park_name, date_established
FROM park
WHERE date_established BETWEEN '1-1-1960' AND '12-31-1969';

--HWK 2

-- 1. The city name, state abbreviation, and population of all cities in the states that border Ohio.
-- The states are: Pennsylvania (PA), West Virginia (WV), Kentucky (KY), Indiana (IN), and Michigan (MI).
-- The city name and state abbreviation should be returned as a single column called 'name_and_state' and should contain values such as "Detroit, MI".
-- Order the results alphabetically by state abbreviation and then by city name.
-- (20 rows)

SELECT city_name || ', ' || state_abbreviation AS name_and_state, population
FROM city
WHERE state_abbreviation IN ('PA', 'WV', 'KY', 'IN', 'MI')
ORDER BY state_abbreviation ASC, city_name ASC;


-- 2. The name and nickname of all states and territories that have a nickname (not NULL).
-- The name and nickname should be returned as a single column named 'state_and_nickname' and should contain values such as "New Jersey (Garden State)".
-- Order the results alphabetically by nickname.
-- (51 rows)

SELECT state_name || ' (' || state_nickname || ')' AS state_and_nickname
FROM state
WHERE state_nickname IS NOT NULL
ORDER BY state_nickname ASC;



-- 3. The name, population, area, and population density (name the column 'population_density') of cities with more than 5,000 people per square kilometer.
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
-- Order the results by population density, highest number first.
-- (9 rows)

SELECT city_name, population, area, population/area AS population_density
FROM city
WHERE population/area > 5000
ORDER BY population/area DESC;



-- 4. The average population of states in the "West" census region. Name the column 'average_population'.
-- Expected answer is around 6,000,000
-- (1 row)
SELECT AVG(population) as average_population
from state
WHERE census_region = 'West';



-- 5. The sum of the population of all cities in California. Name the column 'california_population'.
-- Expected answer is around 20,000,000
-- (1 row)

SELECT SUM(population) as california_population
FROM city
WHERE state_abbreviation = 'CA';




-- 6. The sum of the population of all states in the "South" census region. Name the column 'south_population'.
-- Expected answer is around 125,000,000
-- (1 row)

SELECT SUM(population) as south_population
FROM state
WHERE census_region = 'South';




-- 7. The population of the state with the highest population. Name the column 'largest_state_population'.
-- Expected answer is around 39,500,000
-- (1 row)
SELECT MAX(population) as largest_state_population
FROM state;




-- 8. The area of the smallest state in the "Northeast" census region. Name the column 'smallest_northeast_area'.
-- Expected answer is around 4,000
-- (1 row)

SELECT MIN(area) as smallest_northeast_area
from state
WHERE census_region = 'Northeast';



-- 9. The population of the city with the highest population. Name the column 'largest_city_population'.
-- Expected answer is around 8,300,000
-- (1 row)

SELECT MAX(population) as largest_city_population
from city;




-- 10. The population of the city with the smallest population in Oregon (OR). Name the column 'smallest_oregon_population'.
-- Expected answer is around 100,000
-- (1 row)

SELECT min(population)
from city
WHERE city.state_abbreviation = 'OR';




-- 11. The average sales tax of all states, territories, and districts. Name the column 'average_sales_tax'.
-- Expected answer is around 4.9%
-- (1 row)

SELECT AVG(sales_tax) as average_sales_tax
from state;




-- 12. The average population of all cities in Washington (WA). Name the column 'average_washington_population'.
-- Expected answer is around 202,000
-- (1 row)

SELECT AVG(population) as average_washington_population
from city
WHERE city.state_abbreviation = 'WA';




-- 13. The state (or territory) name and sales tax for the top five highest sales of tax of all states and territories. 
-- Order the results by sales tax with the highest number first, then by state name alphabetically.
-- (5 rows)

SELECT state_name, sales_tax
from state
ORDER BY sales_tax DESC, state_name ASC
LIMIT 5;




-- 14. The name and date established of the top 10 oldest national parks.
-- Order the results with the oldest park first.
-- (10 rows)

SELECT park_name, date_established
from park
ORDER BY date_established ASC
LIMIT 10;




-- 15. The name and date established of the newest national park.
-- (1 row)
SELECT park_name, date_established
from park
ORDER BY date_established DESC
LIMIT 1;


-- 16. The average area of national parks that have camping. Name the column 'average_park_area'.
-- Expected answer is around 3,900.
-- (1 row)
SELECT AVG(area) as average_park_area
from park
WHERE has_camping;



-- 17. The highest population density of all records in the state table. Name the column 'population_density'.
-- Population density is expressed as people per square kilometer. In other words, population divided by area.
-- Exepcted answer is around 4,000
-- (1 row)

SELECT MAX(population/area) as population_density
from state;




-- 18. The count of the number of cities (name column 'num_cities') and the state abbreviation for each state and territory (exclude state abbreviation DC).
-- Order the results by state abbreviation.
-- (55 rows)

SELECT COUNT(city_name) as num_cities, state_abbreviation
from city
WHERE state_abbreviation != 'DC'
GROUP BY state_abbreviation
ORDER BY state_abbreviation;



-- 19. The census region and the number of records in the state table (name column 'num_states') for each census region. Exclude ones that don't have a census region.
-- Order the results from highest to lowest.
-- (Note: DC is in a census region, but the territories aren't, so the sum of the counts will equal 51).
-- (4 rows)

SELECT census_region, COUNT (state_name) as num_states
from state
WHERE census_region IS NOT NULL
GROUP BY census_region
ORDER BY num_states DESC;



-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)

SELECT state_abbreviation, MAX(population) as city_population
from city
GROUP BY state_abbreviation
ORDER BY city_population DESC;





-- 21. The census region, and the average, minimum, and maximum population of states and districts in each census region. Exclude ones that don't have a census region.
-- Name the population columns 'average_population, 'min_population', and 'max_population'.
-- Order the results from lowest to highest average population.
-- (4 rows)

SELECT census_region, AVG(population) as average_population, MIN(population) as min_population, MAX(population) as max_population
from state
WHERE census_region IS NOT NULL
GROUP BY census_region
ORDER BY average_population ASC;











