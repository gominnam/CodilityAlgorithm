SELECT MEMBER_ID
     , MEMBER_NAME
     , GENDER
     , DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') AS DATE_OF_BIRTH
FROM MEMBER_PROFILE
WHERE GENDER = 'W'
  AND TLNO IS NOT NULL
 -- AND SUBSTR(DATE_OF_BIRTH, 6, 2) = '03'
  AND MONTH(DATE_OF_BIRTH) = 3
ORDER BY MEMBER_ID ASC;


/*
1)
월을 추출하는 함수: MONTH(DATE_COLUMN) = 3
- SUBSTR 대신 MONTH 함수를 사용하면 날짜 관련 처리를 데이터베이스가 더 최적화하여 수행할 수 있다.
- YEAR, DAY 함수도 마찬가지로 사용하면 된다.

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131120

*/