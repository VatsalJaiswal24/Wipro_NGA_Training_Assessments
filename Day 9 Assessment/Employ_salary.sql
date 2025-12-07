-- Done by Vatsal Jaiswal
-- Write your query below
-- Retrieve employees who earn more than the average salary in their department
SELECT 
    e.FirstName,
    e.LastName,
    d.DepartmentName,
    e.Salary
FROM 
    Employees e
JOIN 
    Departments d
ON 
    e.DepartmentID = d.DepartmentID
WHERE 
    e.Salary > (
        SELECT 
            AVG(Salary)
        FROM 
            Employees
        WHERE 
            DepartmentID = e.DepartmentID
    )
ORDER BY 
    e.Salary ASC;