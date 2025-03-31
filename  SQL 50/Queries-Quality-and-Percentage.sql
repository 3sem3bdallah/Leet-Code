select query_name , ROUND(AVG(RATING/POSITION),2) quality,
ROUND(AVG(RATING<3)*100,2) poor_query_percentage 
from queries 
GROUP BY QUERY_NAME
