package Programmers.Level2;

import java.util.*;

public class DiscountOffer {
    static Map<String, Integer> basket = new HashMap<>();

    public boolean isPossible(Map<String, Integer> wantMap){
        for(Map.Entry<String, Integer> entry : wantMap.entrySet()){
            if(!basket.getOrDefault(entry.getKey(), 0).equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount){
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i=0; i<want.length; i++){
            wantMap.put(want[i], number[i]);
            basket.put(want[i], 0);
        }

        for(int right=0, left = 0; right<discount.length; right++){
            String current = discount[right];
            basket.put(current, basket.getOrDefault(current, 0) + 1);

            if(right - left >= 10){
                String expired = discount[left++];
                basket.put(expired, basket.get(expired) - 1);
            }

            if(isPossible(wantMap)) answer++;
        }

        return answer;
    }

    public static void main(String[] args){
        DiscountOffer discountOffer = new DiscountOffer();
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount = {"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        System.out.println(discountOffer.solution(want, number, discount));
    }
}

/*

Thinking:
1)
HashMap 더 잘 사용해보기
- for문으로 사용:
  ex) for(Map.Entry<String, Integer> entry : map.entrySet()){
        entry.getKey();
        entry.getValue();
      }

- getOrDefault()


-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131127

 */
