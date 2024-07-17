
SELECT I.ANIMAL_ID,
       I.NAME
FROM ANIMAL_INS AS I
INNER JOIN ANIMAL_OUTS AS O
      ON I.ANIMAL_ID = O.ANIMAL_ID
WHERE TIMESTAMPDIFF(SECOND, I.DATETIME, O.DATETIME) < 0
ORDER BY I.DATETIME
;

/*

Thinking:
1)
TIMESTAMPDIFF(unit, datetime_expr1, datetime_expr2)
- unit: 시간 단위 (ex. SECOND, MINUTE, HOUR, DAY, WEEK, MONTH, QUARTER, YEAR)
- 위의 결과가 음수인 경우는 datetime_expr1이 datetime_expr2보다 늦은 시간이다.

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/59043

*/