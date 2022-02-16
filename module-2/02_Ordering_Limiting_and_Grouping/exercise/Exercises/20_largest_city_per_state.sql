-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)

SELECT state_abbreviation, MAX(population) as city_population
from city
GROUP BY state_abbreviation
ORDER BY city_population DESC;
