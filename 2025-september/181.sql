select e.name as Employee
from Employee e,
(
    select id, salary
    from Employee
) a
where e.managerId=a.id and e.salary>a.salary;