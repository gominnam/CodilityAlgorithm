WITH RECURSIVE Generation_Ecoli AS (
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL

    UNION ALL
    SELECT
        e.ID,
        e.PARENT_ID,
        g.GENERATION + 1 AS GENERATION
    FROM
        ECOLI_DATA e
    INNER JOIN
        Generation_Ecoli g ON g.ID = e.PARENT_ID
),
Child_Count AS (
   SELECT
       g.ID,
       g.GENERATION,
       COUNT(c.ID) AS Child_Count
   FROM
       Generation_Ecoli g
   LEFT JOIN
       ECOLI_DATA c ON g.ID = c.PARENT_ID
   GROUP BY
       g.ID, g.GENERATION
)
SELECT
    COUNT(*) AS COUNT,
    GENERATION
FROM
    Child_Count
WHERE
    Child_Count = 0
GROUP BY
    GENERATION
ORDER BY
    GENERATION ASC
;

/*

Thinking:
1) Recursive CTE 를 사용하여 재귀 데이터를 조회한다.

2) Generation_Ecoli CTE 결과를 토대로 Child_Count 를 구한다.

3) Child_Count 가 0 인 데이터를 조회한다.

 */
