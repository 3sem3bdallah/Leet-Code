# Write your MySQL query statement below
select case
when id%2=0 then id-1
when id%2=1 AND id + 1 <= (SELECT MAX(id) FROM seat) THEN id + 1
else id
end as id
, student from seat
order by id