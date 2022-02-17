-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database
-- I can do this with a subquery
SELECT city_name, state_abbreviation, (SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation)
FROM city
WHERE city_name = 'Columbus';

SELECT city.city_name, city.state_abbreviation, state_name
FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE city_name = 'Columbus';

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).
--above

-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)

--add a park that doesn't exist in a state
--INSERT INTO park(park_name, date_established, area, has_camping) VALUES ('Katie No State',CURRENT_DATE, 1,false);
SELECT * FROM park;

SELECT park_name, state_abbreviation
FROM park
--LEFT JOIN park_state ON park.park_id = park_state.park_id; --include parks that don't exist in a state
INNER JOIN park_state ON park.park_id = park_state.park_id; --only include parks that exist in a state



-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, park_state.state_abbreviation, state_name
FROM park
INNER JOIN park_state ON park_state.park_id =  park.park_id --only include parks that exist in a state
INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation;

-- Modify the previous query to include the name of the state's capital city.
SELECT park_name, state.state_abbreviation, state_name, state.capital, city_name
FROM park
INNER JOIN park_state ON park_state.park_id =  park.park_id --only include parks that exist in a state
INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id;

--you can also alias tables
SELECT park_name, s.state_abbreviation, state_name, s.capital, city_name
FROM park p
INNER JOIN park_state ps ON p.park_id = ps.park_id
INNER JOIN state s ON s.state_abbreviation = ps.state_abbreviation
INNER JOIN city c ON s.capital = c.city_id; 

-- Modify the previous query to include the area of each park.
SELECT park_name, state.state_abbreviation, state_name, state.capital, city_name, park.area AS park_area
FROM park
INNER JOIN park_state ON park_state.park_id =  park.park_id --only include parks that exist in a state
INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
--city, state
SELECT city_name, city.population
FROM city
--I could do a subquery and say WHERE state_abbreviation IN (SELECT state_abbreviation FROM state WHERE census_region = 'Midwest')
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE state.census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT state_name, COUNT(city_name) AS number_of_cities
FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name;

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT state_name, COUNT(city_name) AS number_of_cities
FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest'
GROUP BY state_name
ORDER BY number_of_cities DESC;


-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established) AS earliest_park
FROM state
JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation --JOIN means INNER JOIN
JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established) AS earliest_park
FROM state
LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name;

-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'City' AS kind_of_place
FROM city
WHERE city_name LIKE 'W%'
UNION
SELECT state_name AS place_name, 'State' AS kind_of_place
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;


-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

