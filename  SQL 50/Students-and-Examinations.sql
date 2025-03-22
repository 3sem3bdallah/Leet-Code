SELECT 
    ss.student_id,
    ss.student_name,
    sub.subject_name,
    COUNT(e.student_id) AS attended_exams
FROM Students ss
CROSS JOIN Subjects sub
LEFT JOIN Examinations e
    ON ss.student_id = e.student_id 
    AND sub.subject_name = e.subject_name
GROUP BY 
    ss.student_id, 
    ss.student_name, 
    sub.subject_name
ORDER BY 
    ss.student_id, 
    sub.subject_name;
