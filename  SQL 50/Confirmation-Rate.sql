SELECT 
    A.user_id,
    ROUND(
        COALESCE(SUM(CASE WHEN B.action = 'confirmed' THEN 1 ELSE 0 END) / COUNT(B.action), 0),
        2
    ) AS confirmation_rate
FROM Signups AS A
LEFT JOIN Confirmations AS B 
    ON A.user_id = B.user_id
GROUP BY A.user_id;
