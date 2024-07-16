SELECT ANIMAL_ID
     , NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = 'Dog'
  AND NAME LIKE '%el%'
ORDER BY NAME ASC;


/*

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/59047

 */