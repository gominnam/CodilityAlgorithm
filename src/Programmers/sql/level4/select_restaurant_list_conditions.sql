WITH RANK_REVIEW AS (
    SELECT
        MP.MEMBER_ID,
        MP.MEMBER_NAME,
        RANK() OVER(ORDER BY SUM(RR.REVIEW_SCORE) DESC) AS RANKING
    FROM
        MEMBER_PROFILE MP
    JOIN
        REST_REVIEW RR
    ON  MP.MEMBER_ID = RR.MEMBER_ID
    GROUP BY
        MP.MEMBER_ID
)
SELECT
    RA.MEMBER_NAME,
    REV.REVIEW_TEXT,
    DATE_FORMAT(REV.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM
    RANK_REVIEW RA
JOIN
    REST_REVIEW REV
ON  RA.MEMBER_ID = REV.MEMBER_ID
WHERE
    RA.RANKING = 1
ORDER BY
    REV.REVIEW_DATE ASC,
    REV.REVIEW_TEXT ASC
;

/*
Thinking:
1)
CTE (Common Table Expression)
- WITH 키워드를 사용하여 정의 되는 테이블을 말한다 (WITH 절이라고도 함)

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131124

 */