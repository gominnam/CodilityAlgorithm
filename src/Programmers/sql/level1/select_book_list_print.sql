SELECT BOOK_ID
     , DATE_FORMAT(PUBLISHED_DATE, '%Y-%m-%d') AS PUBLISHED_DATE
FROM BOOK
WHERE CATEGORY = '인문'
  AND SUBSTRING(PUBLISHED_DATE, 1, 4) = '2021'
ORDER BY PUBLISHED_DATE ASC;

/*

DATE FORMAT 에서 YYYY-MM-DD 형식으로 변경하는 매서드
ex)
SELECT DATE_FORMAT(your_date_column, '%Y-%m-%d') AS formatted_date
FROM your_table;

%y: y가 소문자이면 년도를 두자리로 표시합니다. 예를 들어 2019년은 19로 표시
%Y: Y가 대문자이면 년도를 네자리로 표시합니다. 예를 들어 2019년은 2019로 표시
%m: m이 소문자이면 월을 두자리로 표시합니다. 예를 들어 1월은 01로 표시
%M: M이 대문자이면 월을 세글자로 표시합니다. 예를 들어 1월은 Jan로 표시
%d: d가 소문자이면 일을 두자리로 표시합니다. 예를 들어 1일은 01로 표시
%D: D가 대문자이면 일을 세글자로 표시합니다. 예를 들어 1일은 Sun로 표시


- ref: https://school.programmers.co.kr/learn/courses/30/lessons/144

 */