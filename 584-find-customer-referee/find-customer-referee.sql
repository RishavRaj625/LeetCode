# Write your MySQL query statement below

SELECT name
FROM Customer
WHERE referee_id IS NULL 
   OR referee_id <> 2;

# select name from customer where referee_id != 2 or referee_id is null;