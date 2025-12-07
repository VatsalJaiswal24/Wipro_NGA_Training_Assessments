-- Done by Vatsal Jaiswal
SELECT 
    s.year,
    s.semester,
    COUNT(DISTINCT s.professor_id) AS no_of_professor
FROM 
    schedule s
WHERE 
    s.course_id BETWEEN 1 AND 10
GROUP BY 
    s.year, s.semester
ORDER BY 
    s.year ASC;