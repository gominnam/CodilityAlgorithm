package Programmers.Level2;

public class SumConsecutiveSubsequence {

    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] answer = {0, 1000001};
        int left = 0;
        for(int right = 0; right < sequence.length; right++) {
            k -= sequence[right];
            while(k < 0) {
                k += sequence[left++];
            }
            if(k == 0 && answer[1] - answer[0] > right - left) {
                answer[0] = left;
                answer[1] = right;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}

/*
- ref: https://school.programmers.co.kr/learn/courses/30/lessons/178870
two pointer algorithm

TEST CASE:

1)
sequence = {1, 2, 3, 4, 5}
k = 7

answer: {2, 3}

2)
sequence = {1, 1, 1, 2, 3, 4, 5}
k = 5

answer = {6, 6}

 */