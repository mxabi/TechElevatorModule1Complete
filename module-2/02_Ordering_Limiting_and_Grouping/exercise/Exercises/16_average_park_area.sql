-- 16. The average area of national parks that have camping. Name the column 'average_park_area'.
-- Expected answer is around 3,900.
-- (1 row)
SELECT AVG(area) as average_park_area
from park
WHERE has_camping;
