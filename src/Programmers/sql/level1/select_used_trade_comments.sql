SELECT UGB.TITLE
     , UGB.BOARD_ID
     , UGR.REPLY_ID
     , UGR.WRITER_ID
     , UGR.CONTENTS
     , DATE_FORMAT(UGR.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD AS UGB
     INNER JOIN USED_GOODS_REPLY AS UGR
             ON UGB.BOARD_ID = UGR.BOARD_ID
WHERE SUBSTR(UGB.CREATED_DATE, 1, 7) = '2022-10'
ORDER BY UGR.CREATED_DATE, UGB.TITLE ASC;

/*

Thinking:
1)
WHERE SUBSTR(UGB.CREATED_DATE, 1, 7) = '2022-10'
- 날짜 비교 방식을 SUBSTR 함수를 사용하는 대신, 날짜 범위를 직접 비교하는게 더 효율적일 수 있따.
  SUBSTR 함수는 인덱스 활용을 방해할 수 있기 때문에

2)
인덱스 활용:
- CREATED_DATE 와 BOARD_ID 컬럼에 인덱스가 없다면, 이러한 컬럼에 인덱스를 추가하여
  JOIN과 WHERE 조건의 성능을 향상시킬 수 있다.


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/164673

*/