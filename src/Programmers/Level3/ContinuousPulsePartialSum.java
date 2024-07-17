package Programmers.Level3;

public class ContinuousPulsePartialSum {

    public long solution(int[] sequence){
        int size = sequence.length;
        long[] dpOdd = new long[size + 1];
        long[] dpEven = new long[size + 1];
        long answer = 0;

        for (int i = 1; i <= size; i++) {
            int current = sequence[i - 1];
            int currentNeg = -current;

            if (i % 2 == 1) { // Odd index
                dpOdd[i] = Math.max(dpOdd[i - 1] + current, current);
                dpEven[i] = Math.max(dpEven[i - 1] + currentNeg, currentNeg);
            } else { // Even index
                dpOdd[i] = Math.max(dpOdd[i - 1] + currentNeg, currentNeg);
                dpEven[i] = Math.max(dpEven[i - 1] + current, current);
            }

            answer = Math.max(answer, Math.max(dpOdd[i], dpEven[i]));
        }

        return answer;
    }

    public static void main(String[] args){
        ContinuousPulsePartialSum cpps = new ContinuousPulsePartialSum();

        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        System.out.println(cpps.solution(sequence));
    }
}

/*

Thinking:

부분합 Dynamic Programming 문제

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/161988

 */