package BaekJoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class DP_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] DP = new int[N+1];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for(int i=0; i<N+1; i++){
            max = Math.max(max, DP[i]);

            if(i + T[i] > N) continue;
            DP[i + T[i]] = Math.max(max + P[i], DP[i + T[i]]);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
        ## DynamicProgramming (DFS + Memorization)


    feedback!!
    - 재귀호출 방식으로 제출 시 시간초과. 메모제이션을 활용하자

    public static void DP(int day){
        if(day == N) return;
        Work work = arr.get(day);
        if(work.time + day >= N) return;
        if( profit[day + work.time] < profit[day] + work.profit){
            profit[day + work.time] = profit[day] + work.profit;
            ans = Math.max(ans, profit[day] + work.profit);
            DP(day + work.time);
        }
        DP(day + 1);
    }

    - 마지막 날(N일)에 만약  T=1 이라면 일을 할 수 있기 때문에 DP배열을 1~N+1까지 받아야 한다는 점이다.


 */
