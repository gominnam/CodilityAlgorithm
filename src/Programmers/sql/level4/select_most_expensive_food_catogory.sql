-- 1) 서브쿼리
SELECT
    FP.CATEGORY,
    maxPrices.MAX_PRICE,
    FP.PRODUCT_NAME
FROM
    FOOD_PRODUCT FP
        JOIN
    (
        SELECT
            CATEGORY,
            MAX(PRICE) AS MAX_PRICE
        FROM
            FOOD_PRODUCT
        WHERE
            CATEGORY IN ('과자', '국', '김치', '식용유')
        GROUP BY
            CATEGORY
    ) AS maxPrices
    ON FP.CATEGORY = maxPrices.CATEGORY
        AND FP.PRICE = maxPrices.MAX_PRICE
ORDER BY
    MAX_PRICE DESC
;

-- 2) 윈도우 함수와 WITH 절
WITH RankedProducts AS (
    SELECT
        CATEGORY,
        PRODUCT_NAME,
        PRICE,
        RANK() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) AS RANKING
    FROM
        FOOD_PRODUCT
    WHERE
        CATEGORY IN ('과자', '국', '김치', '식용유')
)
SELECT
    CATEGORY,
    PRICE AS MAX_PRICE,
    PRODUCT_NAME
FROM
    RankedProducts
WHERE
    RANKING = 1
ORDER BY
    MAX_PRICE DESC
;


/*

Thinking:

1) 서브쿼리로 해결하기

2) 윈도우 함수 사용하기
- RANK() OVER (PARTITION BY CATEGORY ORDER BY PRICE DESC) AS RANKING
  - PARTITION BY: 같은 CATEGORY 내에서 순위를 매김
  - ORDER BY: PRICE를 기준으로 내림차순 정렬

3) WHERE 절 IN 사용
  ( A조건 or B조건 or C조건 )  <= column IN (A, B, C) 로 간결하게 표현

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131116

 */