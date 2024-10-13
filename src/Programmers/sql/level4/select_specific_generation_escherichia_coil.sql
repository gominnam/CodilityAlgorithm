WITH RECURSIVE generation_ecoli AS (
    SELECT
        ID,
        PARENT_ID,
        1 AS generation
    FROM
        ECOLI_DATA
    WHERE
        PARENT_ID IS NULL

    UNION ALL

    SELECT
        e.ID,
        e.PARENT_ID,
        g.generation + 1 as generation
    FROM
        ECOLI_DATA e

    INNER JOIN
        generation_ecoli g ON e.PARENT_ID = g.ID
)

SELECT
    ID
FROM
    generation_ecoli
WHERE
    generation = 3
ORDER BY
    ID ASC
;

/*

Thinking:
1) Recursive CTE 를 사용하여 계층적 데이터를 조회한다.
- 문법 구조
: WITH RECURSIVE CTE_NAME AS (
    1)
    SELECT
        ...(BASE CASE) 초기 쿼리
    2)
    UNION ALL

    SELECT
        ...(RECURSIVE CASE) 재귀 쿼리
    3) [ 필요시 조건 ]
    INNER JOIN
        CTE_NAME ON 조인 조건

2)
SELF JOIN 을 사용하는 방법도 있지만
실제 서비스에서 generation 값 마다 쿼리(self join 횟수)가 달라지므로 비효율적이다.

 */