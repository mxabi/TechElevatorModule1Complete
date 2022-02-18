-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database


-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)
SELECT park_name, state_abbreviation
FROM park
LEFT JOIN park_state ON park.park_id = park_state.park_id
ORDER BY park.park_name;

-- The park_state table is an associative table that can be used to connect the park and state tables.
-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
SELECT park_name, state_name
FROM park
LEFT JOIN park_state ON park.park_id = park_state.park_id
LEFT JOIN state ON park_state.state_abbreviation = state.state_abbreviation
ORDER BY park.park_name;

-- Modify the previous query to include the name of the state's capital city.

SELECT park_name,park_state.state_abbreviation, state_name, state.capital, city_name
FROM park
INNER JOIN park_state ON park_state.park_id = park.park_id -- only include parks in a state
INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id;

--You can also alias tables
SELECT park_name, s.state_abbreviation, state_name, s.capital, city_name
FROM park p
INNER JOIN park_state ps ON p.park_id = ps.park_id
INNER JOIN state s ON s.state_abbreviation = ps.state_abbreviation
INNER JOIN city c ON s.capital = c.city_id;

-- Modify the previous query to include the area of each park.
SELECT park_name,park_state.state_abbreviation, state_name, state.capital, city_name, park.area AS park_area
FROM park
INNER JOIN park_state ON park_state.park_id = park.park_id -- only include parks in a state
INNER JOIN state ON state.state_abbreviation = park_state.state_abbreviation
INNER JOIN city ON state.capital = city.city_id;

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
--city,state
--city has to live in the state foreign key?
--inner join

SELECT city_name, city.population
FROM city
--I could do a subquery and say WHERE state_abbreviation is in (SELECT state_abbreviation FROM state where census region = 'Midwest')
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest';

-- Write a query to retrieve the number of cities in the city table for each state in the Midwest census region.
SELECT COUNT(city_name) as number_of_cities
FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
WHERE census_region = 'Midwest';

-- Modify the previous query to sort the results by the number of cities in descending order.
SELECT COUNT(city_name) as number_of_cities, state_name
FROM city
INNER JOIN state ON city.state_abbreviation = state.state_abbreviation
GROUP BY state_name
ORDER BY number_of_cities DESC;



-- LEFT JOIN

-- Write a query to retrieve the state name and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.
SELECT state_name, MIN(date_established) AS earliest_pk
From state
INNER JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
INNER JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name;

SELECT * FROM STATE;

-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.
SELECT state_name, MIN(date_established) AS earliest_pk
From state
LEFT JOIN park_state ON state.state_abbreviation = park_state.state_abbreviation
LEFT JOIN park ON park_state.park_id = park.park_id
GROUP BY state_name;


-- UNION

-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state--how many times does it appear in the results?)
SELECT city_name AS place_name
FROM city
WHERE city_name LIKE 'W%'
UNION
--Want to add results to eachother
SELECT state_name AS place_name
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;
--ditches duplicates

-- Modify the previous query to include a column that indicates whether the place is a city or state.
SELECT city_name AS place_name, 'City' AS kind_of_place
FROM city
WHERE city_name LIKE 'W%'
UNION
--Want to add results to eachother
SELECT state_name AS place_name, 'State' AS kind_of_place
FROM state
WHERE state_name LIKE 'W%'
ORDER BY place_name;

--park name for a park that resides in a state with
-- at least two citiies with population > 1000000

--use a temporatry table to find the states i care about first
WITH states_w_2_big_cities AS (
	SELECT state_abbreviation
	FROM city
	WHERE population > 1000000
	GROUP BY state_abbreviation
	HAVING COUNT (city_name) >2
)

-- i can only use the temporary table in the next statement

select park_name, park_state.state_abbreviation
FROM park
INNER JOIN park_state ON park.park_id = park_state.park_id
INNER JOIN states_w_2_big_cities ON states_w_2_big_cities.state_abbreviation = park_state.state_abbreviation;

-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in DbVisualizer and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres
SELECT genre_name
from genre;

-- The titles of all the Comedy movies
SELECT title, genre_name
FROM genre
INNER JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
INNER JOIN movie ON movie_genre.movie_id = movie.movie_id
WHERE genre_name = 'Comedy';

---step by step if we don't do a join
--whats the id for comedies?
SELECT genre_id
FROM genre
WHERE genre_name = 'Comedy';

--what movie ids have genre 35?
SELECT movie_id from movie_genre WHERE genre_id = 35;

SELECT title FROM movie WHERE movie_id =992;

-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)

SELECT title, release_date, person_name
FROM movie
INNER JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
INNER JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Tom Hanks';


-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday
FROM person
INNER JOIN movie_actor ON person.person_id = movie_actor.actor_id
INNER JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE title = 'The Fifth Element';

-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. Order the results by the actor names (A-Z). (48 rows)
SELECT person_name, title
FROM person 
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
WHERE person_name Like '% Jones'
ORDER BY person_name;


-- 4. The titles and taglines of all the movies that are in the Fantasy genre. Order the results by title (A-Z) (81 rows)

SELECT title, tagline
From movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE genre_name = 'Fantasy'
ORDER BY title;

-- 5. The titles and release dates of all the movies that are in the Comedy genre. Order the results by release date, earliest to latest. (220 rows)
SELECT title, release_date
FROM movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE genre_name = 'Comedy'
ORDER BY release_date ASC;

-- 6. The genres of "The Wizard of Oz" (3 rows)
SELECT genre_name
From genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie_genre.movie_id = movie.movie_id
WHERE title = 'The Wizard of Oz';


-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
SELECT genre_name
From genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie_genre.movie_id = movie.movie_id
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Christopher Lloyd'
GROUP BY genre_name;

-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later (6 rows)
SELECT genre.genre_name
From genre
JOIN movie_genre ON genre.genre_id = movie_genre.genre_id
JOIN movie ON movie_genre.movie_id = movie.movie_id
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE person_name = 'Robert De Niro' AND release_date > '01-01-2010'
GROUP BY genre.genre_name;



-- 9. The titles of movies directed by James Cameron (6 rows)
SELECT title
From movie
JOIN person ON movie.director_id = person.person_id
WHERE person_name = 'James Cameron';


-- 10. The names of directors who have directed a movie over 3 hours [180 minutes] (15 rows)
SELECT DISTINCT person_name, 
From movie
JOIN person ON movie.director_id = person.person_id
WHERE length_minutes > 180;

-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent to earliest (9 rows)
SELECT title
From movie
JOIN collection ON movie.collection_id = collection.collection_id
WHERE collection_name = 'Star Wars Collection'
ORDER BY release_date DESC;

-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
SELECT title
From movie
JOIN collection ON movie.collection_id = collection.collection_id
JOIN person ON movie.director_id = person.person_id
WHERE person_name != 'George Lucas' AND collection_name = 'Star Wars Collection';


-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)
SELECT DISTINCT person_name
From movie
JOIN collection ON movie.collection_id = collection.collection_id
JOIN person ON movie.director_id = person.person_id
WHERE collection_name = 'Harry Potter Collection';

-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)

--SELECT DISTINCT person_name
--FRom movie
--JOIN collection ON movie.collection_id = collection.collection_id
--JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
--JOIN person ON movie_actor.actor_id = person.person_id
--WHERE collection_name = 'Back to the Future Collection'

SELECT DISTINCT person_name
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id = movie.movie_id
JOIN collection ON movie.collection_id = collection.collection_id
WHERE collection_name = 'Back to the Future Collection';



-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT title, person_name
From person 
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie_actor.movie_id  = movie.movie_id
AND person.person_id = movie.director_id;

-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT person_name, person.birthday
From person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie On movie_actor.movie_id = movie.movie_id
WHERE movie.release_date BETWEEN '01-01-1985' AND '12-30-1985' AND person.birthday BETWEEN '01-01-1950' AND '12-30-1959'

-- 17. The titles and taglines of movies that are in the "Family" genre and Samuel L. Jackson has acted in (4 rows)
SELECT title, tagline
From movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
WHERE genre_name = 'Family' AND person_name = 'Samuel L. Jackson'




--WHERE genre_name = 'Family' AND person_name = 'Samuel '

-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result around 110-120)
SELECT AVG(length_minutes) as average_length
From movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE genre_name = 'Science Fiction';


-- 19. The genre name and the number of movies in each genre. Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).

SELECT COUNT(movie.movie_id) as num_of_movies, genre.genre_name
From movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
GROUP BY genre_name;




-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
SELECT title, length_minutes, release_date
From movie
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE genre_name = 'Action'
ORDER BY length_minutes DESC, release_date DESC
LIMIT 5;




-- 21. For every person in the person table with the first name of "George", list the number of movies they've been in--include all Georges, even those that have not appeared in any movies. Display the names in alphabetical order. (59 rows)
-- Name the count column 'num_of_movies'
SELECT COUNT(movie_id) as num_of_movies, person_name, person.person_id
From person
LEFT JOIN movie_actor ON person.person_id = movie_actor.actor_id
WHERE person_name LIKE 'George %'
GROUP BY person_name, person.person_id
ORDER BY person_name;



