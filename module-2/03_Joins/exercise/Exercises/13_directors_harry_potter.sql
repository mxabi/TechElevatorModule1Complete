-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)
SELECT DISTINCT person_name
From movie
JOIN collection ON movie.collection_id = collection.collection_id
JOIN person ON movie.director_id = person.person_id
WHERE collection_name = 'Harry Potter Collection';
