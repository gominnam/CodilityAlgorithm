package Programmers.Level3;

import java.util.Collections;
import java.util.PriorityQueue;

public class OvertimeIndex {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<works.length; i++){
            pq.add(works[i]);
        }
        while(!pq.isEmpty() && n-- > 0){
            int cur = pq.poll()-1;
            if(cur == 0) continue;
            pq.add(cur);
        }

        if(pq.isEmpty()) return 0;

        while(!pq.isEmpty()){
            int num = pq.poll();
            answer = answer + (num*num);
        }

        return answer;
    }

    public static void main(String[] args){
        OvertimeIndex oi = new OvertimeIndex();
        int n = 4;
        int[] works = {4, 3, 3};
        System.out.print(oi.solution(n, works));
    }
}
/*
야근 지수


 */