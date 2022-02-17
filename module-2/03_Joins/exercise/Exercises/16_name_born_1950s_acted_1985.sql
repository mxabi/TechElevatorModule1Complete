-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985 (20 rows)
SELECT DISTINCT person_name, person.birthday
From person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie On movie_actor.movie_id = movie.movie_id
WHERE movie.release_date BETWEEN '01-01-1985' AND '12-30-1985' AND person.birthday BETWEEN '01-01-1950' AND '12-30-1959'

