package Programmers.Level2;

import java.util.HashSet;
import java.util.Set;

public class SumConsecutiveCircleSubsequence {

    public static void main(String[] args){
        int[] elements = {7,9,1,1,4};
        Set<Integer> set = new HashSet<>();
        int n = elements.length;

        // 길이가 1인 부분 수열
        for (int i = 0; i < n; i++) {
            set.add(elements[i]);
        }

        // 길이가 2 이상인 부분 수열
        for (int len = 2; len <= n; len++) {//length 2 ~ n 까지 조건
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < i + len; j++) {
                    sum += elements[j % n];
                }
                set.add(sum);
            }
        }

        System.out.println(set.size());
    }
}

/*

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/131701

TEST CASE:

elements: {7,9,1,1,4}
==> 18


---------------------------------------------------------------------------------

thinking:

1)
- sum += elements[j % n];
원형 순환에서 사용
j가 n이 초과하더라도 나머지를 통해서 index 앞의 부분을 접근 가능

 */