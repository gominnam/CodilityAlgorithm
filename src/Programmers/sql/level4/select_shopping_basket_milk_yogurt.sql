SELECT
    CART_ID
FROM
    CART_PRODUCTS
WHERE
    NAME IN ('Milk', 'Yogurt')
GROUP BY
    CART_ID
HAVING
    COUNT(DISTINCT NAME) = 2
ORDER BY
    ID ASC
;


/*

Thinking:
1)
CART_PRODUCTS 테이블에서 NAME이 'Milk' 또는 'Yogurt'인 CART_ID를 찾는방법
Group by 조건문 `Having`을 사용


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/62284

 */