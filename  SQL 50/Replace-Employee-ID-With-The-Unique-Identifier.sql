SELECT EUNI.unique_id, EMP.name
FROM Employees EMP
LEFT JOIN EmployeeUNI EUNI ON EMP.id = EUNI.id;
