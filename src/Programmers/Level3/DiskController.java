package Programmers.Level3;

import java.util.*;

public class DiskController {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0;
        int idx = 0;
        int end = 0;
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        while(count < jobs.length){
            while(idx < jobs.length && jobs[idx][0] <= end){
                pq.add(jobs[idx++]);
            }

            if(pq.isEmpty()){
                end = jobs[idx][0];
            }
            else{
                int[] tmp = pq.poll();
                answer += tmp[1]+end-tmp[0];
                end += tmp[1];
                count++;
            }
        }
        return answer/jobs.length;
    }

    public static void main(String[] args){
        DiskController dc = new DiskController();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        //int[][] jobs = {{0, 3}, {4, 3}, {8, 3}};
        System.out.println(dc.solution(jobs));
    }
}
/*
Greedy 한 문제이지만
end time 기준으로 shortest 한 job들을 먼저 처리하는 방식이므로
PriorityQueue를 사용하여 job time 시간이 짧은 것 먼저 처리한다.
 */
