SELECT
    products.PRODUCT_ID,
    products.PRODUCT_NAME,
    SUM(products.PRICE * orders.AMOUNT) AS TOTAL_SALES
FROM
    FOOD_PRODUCT AS products
        JOIN
    FOOD_ORDER AS orders
    ON
        products.PRODUCT_ID = orders.PRODUCT_ID
WHERE
    DATE_FORMAT(orders.PRODUCE_DATE, '%Y-%m') = '2022-05'
GROUP BY
    products.PRODUCT_ID,
    products.PRODUCT_NAME
ORDER BY
    TOTAL_SALES DESC,
    PRODUCT_ID ASC
;

/*

Thinking:
총매출이라 하여 조건에
AND orders.OUT_DATE IS NOT NULL 를 추가하여 헤맸다.
매출이 실제로 발생한 시점을 기준으로 하기 때문에 NULL 체크를 해야하는게 아닌가

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131117

*/