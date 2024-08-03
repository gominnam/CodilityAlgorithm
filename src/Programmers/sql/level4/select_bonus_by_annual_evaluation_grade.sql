WITH EMPLOYEES_GRADE AS (
    SELECT
        EMP_NO,
        YEAR,
        SUM(SCORE) / 2 AS SCORE
    FROM
        HR_GRADE
    GROUP BY
        EMP_NO, YEAR
)
SELECT
    HE.EMP_NO,
    HE.EMP_NAME,
    CASE
        WHEN EG.SCORE >= 96 THEN 'S'
        WHEN EG.SCORE >= 90 THEN 'A'
        WHEN EG.SCORE >= 80 THEN 'B'
        ELSE 'C'
    END AS GRADE,
    CASE
        WHEN EG.SCORE >= 96 THEN SAL * 0.2
        WHEN EG.SCORE >= 90 THEN SAL * 0.15
        WHEN EG.SCORE >= 80 THEN SAL * 0.1
        ELSE 0
    END AS BONUS
FROM
    HR_EMPLOYEES HE
JOIN
    EMPLOYEES_GRADE EG
ON  HE.EMP_NO = EG.EMP_NO
ORDER BY
    HE.EMP_NO ASC
;

/*

Thinking:
1)
IF 문 사용하기
- CASE WHEN 조건 THEN 결과 ELSE 결과 END

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/284528#

 */