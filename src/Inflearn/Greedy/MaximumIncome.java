package Inflearn.Greedy;

import java.util.*;

public class MaximumIncome {

    public static class Schedule implements Comparable<Schedule>{
        int pay;
        int day;
        public Schedule(int p, int d){
            this.pay = p;
            this.day = d;
        }
        @Override
        public int compareTo(Schedule s){
            return s.day - this.day;//내림차순 정렬
        }
    }

    public int solution(ArrayList<Schedule> arr, int day, int n){
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);
        int j=0;
        for(int i=day; i>=1; i--){
            for( ; j<n; j++){
                if(arr.get(j).day < i) break;
                pq.offer(arr.get(j).pay);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }
        return answer;
    }

    public static void main(String[] args){
        MaximumIncome T = new MaximumIncome();
        Scanner sc = new Scanner(System.in);
        ArrayList<Schedule> arr = new ArrayList<>();
        int n = sc.nextInt();
        int maxD = 0;
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr.add(new Schedule(a, b));
            maxD = Math.max(maxD, b);
        }

        System.out.println(T.solution(arr, maxD, n));
    }
}

/*
feedback - PriorityQueue를 사용해서 풀어야 함.

설명

현수는 유명한 강연자이다. N개이 기업에서 강연 요청을 해왔다. 각 기업은 D일 안에 와서 강연을 해 주면 M만큼의 강연료를 주기로 했다.

각 기업이 요청한 D와 M를 바탕으로 가장 많을 돈을 벌 수 있도록 강연 스케쥴을 짜야 한다.

단 강연의 특성상 현수는 하루에 하나의 기업에서만 강연을 할 수 있다.


입력
첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고, 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.


출력
첫 번째 줄에 최대로 벌 수 있는 수입을 출력한다.

TEST CASE:
6
50 2
20 1
40 2
60 3
30 3
30 1


==> 150

 */