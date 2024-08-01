SELECT
    YEAR(OS.SALES_DATE) AS YEAR,
    MONTH(OS.SALES_DATE) AS MONTH,
    UI.GENDER,
    COUNT(DISTINCT OS.USER_ID) AS USERS
FROM
    USER_INFO UI
    JOIN
    ONLINE_SALE OS
ON  UI.USER_ID = OS.USER_ID
WHERE
    UI.GENDER IS NOT NULL
GROUP BY
    YEAR, MONTH, GENDER
ORDER BY
    YEAR ASC,
    MONTH ASC,
    GENDER ASC
;

/*

Thinking:
1)
group by의 결과를 생각해보기 user_id 중복 count
==> DISTINCT 사용하여 중복 유저 제거

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131532

 */