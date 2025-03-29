# Write your MySQL query statement below

select round(sum(if(cust.customer_pref_delivery_date = cust.first_order,1,0))*100/count(*),2) as immediate_percentage
from (
    
select customer_id, min(order_date) as first_order,min(customer_pref_delivery_date) as customer_pref_delivery_date

from Delivery
group by customer_id)cust

