1)
SELECT
    FLAVOR
FROM
    (
        SELECT
            FH.FLAVOR,
            SUM(FH.TOTAL_ORDER) + SUM(J.TOTAL_ORDER) AS TOTAL_ORDER
        FROM
            FIRST_HALF FH
                JOIN
            JULY J
            ON FH.FLAVOR = J.FLAVOR
        GROUP BY FLAVOR
        ORDER BY TOTAL_ORDER DESC
            LIMIT 3
    ) AS TOTAL
;

2)
WITH RankedFlavors AS (
    SELECT
        FLAVOR,
        SUM(TOTAL_ORDER) AS TOTAL_ORDER,
        RANK() OVER (ORDER BY SUM(TOTAL_ORDER) DESC) AS RANKING
    FROM
        (
            SELECT
                FLAVOR,
                TOTAL_ORDER
            FROM
                FIRST_HALF
            UNION ALL
            SELECT
                FLAVOR,
                TOTAL_ORDER
            FROM
                JULY
        ) AS TOTAL
    GROUP BY FLAVOR
)
SELECT
    FLAVOR
FROM
    RankedFlavors
WHERE
    RANKING <= 3


/*

Thinking:
1)
Limit 3을 사용하여 상위 3개의 결과만 출력하는 방법

2)
Rank() Over 사용하여 3개의 결과값만 갖고오는 방법

UNION
- UNION All: 두 개 이상의 SELECT 문에서 반환된 결과 집합을 결합하는데 사용한다.
- UNION: 중복된 행을 제거하고 결과 집합을 반환


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/133027

 */