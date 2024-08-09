package Programmers.Level1;

import java.text.*;
import java.util.*;

public class PrivacyDate {

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int n = terms.length;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

        try {
            Date todayDate = sdf.parse(today);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(todayDate);

            Map<Character, Integer> termMap = new HashMap<>();
            for (String s : terms) {
                String[] term = s.split(" ");
                Character alphabet = term[0].charAt(0);
                Integer month = Integer.parseInt(term[1]);

                termMap.put(alphabet, month);
            }

            for (int i = 0; i < privacies.length; i++) {
                String[] privacy = privacies[i].split(" ");
                String date = privacy[0];
                Character alphabet = privacy[1].charAt(0);
                Date newDate = sdf.parse(date);
                calendar.setTime(newDate);
                calendar.add(Calendar.MONTH, termMap.get(alphabet));
                Date privacyDate = calendar.getTime();

                if ((privacyDate.equals(todayDate) || privacyDate.before(todayDate))) {
                    answer.add(i + 1);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace(); // 예외가 발생한 경우 스택 트레이스를 출력
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args){
        PrivacyDate privacyDate = new PrivacyDate();
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(privacyDate.solution(today, terms, privacies))); // [1, 4, 5]
    }
}

/*

Thinking:

1) Calendar class:
- methods
    - setTime(Date date): 지정된 날짜로 Calendar 객체를 설정
    - add(int field, int amount): 지정된 필드에 지정된 수량을 추가
        - Calendar.YEAR: 년
        - Calendar.MONTH: 월
        - Calendar.DATE: 일
    - getTime(): Calendar 객체의 날짜를 Date 객체로 반환

2) Date class:
- methods
    - equals(Object obj): 두 Date 객체가 같은 날짜를 나타내는지 확인
    - before(Date when): 이 Date 객체가 when Date 객체보다 이전인지 확인
    - after(Date when): 이 Date 객체가 when Date 객체보다 이후인지 확인

3) SimpleDateFormat class:
- methods
    - format(Date date): 지정된 Date 객체를 텍스트로 변환
        - 예) "yyyy.MM.dd" -> "2020.01.01"
    - parse(String text): 지정된 텍스트를 Date 객체로 변환
        - ParseException: 변환 중 오류가 발생한 경우 발생하는 예외 필수 (컴파일러 에러 발생)



-ref: https://school.programmers.co.kr/learn/courses/30/lessons/150370

 */