SELECT RI.REST_ID
     , RI.REST_NAME
     , RI.FOOD_TYPE
     , RI.FAVORITES
     , RI.ADDRESS
     , ROUND(AVG(RR.REVIEW_SCORE), 2) AS SCORE
  FROM REST_INFO RI
         INNER JOIN REST_REVIEW RR
                    ON RI.REST_ID = RR.REST_ID
 WHERE RI.ADDRESS LIKE '서울%'
GROUP BY REST_ID -- , REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS
ORDER BY SCORE DESC, FAVORITES DESC
;

/*

Thinking:
1) 주소 필터링:
- SUBSTR 대신 LIKE 연산자를 사용하면 인덱스 활용이 더 용이할 수 있음.

2) GROUP BY:
- GROUP BY 에서 유니크한 것들로만 그룹 형성하여 복잡성 줄이고 성능 향상

3) WHERE? HAVING?
- 원시적인 데이터에 대한 필터링은 WHERE 절에서 수행하는 것이 성능적으로 유리하다.
- HAVING 절에서는 집계 결과를 기반으로 추가적인 패턴 매칭을 수행할때 사용.

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131118

*/