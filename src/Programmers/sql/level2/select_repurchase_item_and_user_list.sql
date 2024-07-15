
SELECT USER_ID
     , PRODUCT_ID
FROM ONLINE_SALE
GROUP BY USER_ID, PRODUCT_ID
HAVING COUNT(*) > 1
ORDER BY USER_ID ASC, PRODUCT_ID DESC;


/*

thinking:
1)
group by 와 having 조건문을 이용하면 되는 기초 문제

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131536

*/