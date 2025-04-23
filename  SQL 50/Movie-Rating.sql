# Write your MySQL query statement below

select results from (select name as results
from users join MovieRating  using(user_id)
group by name
order by count(*) desc, results asc
limit 1) as top_users

union all

select results from (select title as results
from movies
join MovieRating using(movie_id)
where month(created_at) =2 and year(created_at)=2020
group by title
order by avg(rating) desc, results asc
limit 1) as top_movies

