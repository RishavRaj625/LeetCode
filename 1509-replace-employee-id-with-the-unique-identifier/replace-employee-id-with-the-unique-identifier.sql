# Write your MySQL query statement below

-- select unique_id, name   -- This is also correct but good to define it 

select u.unique_id, E.name
from Employees E
left join EmployeeUNI u
on E.id = u.id;