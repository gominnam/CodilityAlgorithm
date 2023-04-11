package Programmers.Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EqualSumOfTwoQueue {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sumQueue1 = 0;
        long sumQueue2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sumQueue1 += queue1[i];
            q2.add(queue2[i]);
            sumQueue2 += queue2[i];
        }
        while(!q1.isEmpty() && !q2.isEmpty() && answer < queue1.length*3){
            if(sumQueue1 == sumQueue2) break;
            else if(sumQueue1 > sumQueue2){
                int pValue = q1.poll();
                q2.add(pValue);
                sumQueue1 -= pValue;
                sumQueue2 += pValue;
            }
            else{
                int pValue = q2.poll();
                q1.add(pValue);
                sumQueue1 += pValue;
                sumQueue2 -= pValue;
            }
            answer++;
        }
        if(sumQueue1 == sumQueue2) return answer;
        else return -1;
    }

    public static void main(String[] args){
        EqualSumOfTwoQueue qsotq = new EqualSumOfTwoQueue();
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        System.out.print(qsotq.solution(queue1, queue2));
    }
}
