SELECT B.CATEGORY
     , SUM(BS.SALES) AS TOTAL_SALES
FROM BOOK AS B
         INNER JOIN BOOK_SALES AS BS
                    ON B.BOOK_ID = BS.BOOK_ID
                        AND MONTH(SALES_DATE) = 1
GROUP BY B.CATEGORY
ORDER BY CATEGORY ASC
;

/*

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/144855

 */