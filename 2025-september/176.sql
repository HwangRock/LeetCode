select distinct max(salary) as SecondHighestSalary
from Employee
where salary not in (
    select distinct max(salary)
    from Employee
);