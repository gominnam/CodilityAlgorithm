WITH BookInfo AS(
    SELECT
        B.AUTHOR_ID,
        B.CATEGORY,
        SUM(PRICE*SALES) AS TOTAL_SALES
    FROM
        BOOK B
            JOIN
        BOOK_SALES BS
        ON
            B.BOOK_ID = BS.BOOK_ID
    WHERE
        SALES_DATE >= '2022-01-01' AND SALES_DATE < '2022-02-01'
    GROUP BY
        B.AUTHOR_ID, B.CATEGORY
)
SELECT
    BookInfo.AUTHOR_ID,
    A.AUTHOR_NAME,
    BookInfo.CATEGORY,
    BookInfo.TOTAL_SALES
FROM
    AUTHOR A
        JOIN
    BookInfo
    ON
        BookInfo.AUTHOR_ID = A.AUTHOR_ID
ORDER BY
    AUTHOR_ID ASC,
    CATEGORY DESC
;

/*

Thinking:
1)
매출액을 구하는 경우에서 계산 명령어 실수
= PRICE*SUM(SALES) => SUM(PRICE*SALES)

핵심 차이
SUM(PRICE * SALES)는 각 책에 대해 개별 판매액을 정확하게 계산하고 이를 합산하기 때문에 정확한 총 매출을 나타냅니다.
PRICE * SUM(SALES)는 각 책의 가격에 전체 판매량을 곱하는 것이기 때문에 논리적으로 맞지 않으며, 이 경우는 모든 판매량의 합계를 각 책의 가격에 곱하는 잘못된 결과를 가져온다.

2)
WHERE 절에서
DATE_FORMAT(SALES_DATE, '%Y-%m') = '2022-01' 구문을
SALES_DATE >= '2022-01-01' AND SALES_DATE < '2022-02-01'로 수정하면 인덱스를 더 효율적으로 사용할 수 있다.

- ref: https://school.programmers.co.kr/learn/courses/30/lessons/144856

 */