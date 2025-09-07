CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
declare fin int;
set fin = N-1;
  RETURN (
    select distinct salary
    from Employee
    order by salary desc
    limit fin, 1
  );
END