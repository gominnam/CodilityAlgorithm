package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_17404 {
    static final int INF = 1000001;
    static int N;
    static int[][] dp;
    static int[][] cost;

    public static int calculator(){
        int answer = INF;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //첫번째 집의 색을 고정하고 계산
                if (i == j) {
                    dp[0][j] = cost[0][j];
                } else {
                    dp[0][j] = INF;
                }
            }
            for (int j = 1; j < N; j++) {
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + cost[j][2];
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    answer = Math.min(answer, dp[N - 1][j]); //1번집과 n번집은 달라야함
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        cost = new int[N][3];
        for(int i=0; i<N; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            cost[i][0] = r;
            cost[i][1] = g;
            cost[i][2] = b;
        }
        bw.write(String.valueOf(calculator()));
        bw.flush();
        bw.close();
        br.close();
    }
}

/*

Thinking:
N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다. ( 원형 테이블 )
그러면 직전에 어떤 색으로 색칠하였는지에 대한 정보를 저장해야한다.

=> how? int[][][] dp; 3차원 배열로 이전에 어떤 색으로 색칠하였는지에 대한 정보를 저장한다.
  dp[firstColor][i][color] : i번째 집을 color로 색칠하였을 때, 0~i번째 집까지의 최소 비용

// 아래 calculaotr()는 1번째와 마지막 색을 고려하지 않았을 때 계산 메서드
public static void calculator(){
    dp[0][0] = cost[0][0];
    dp[0][1] = cost[0][1];
    dp[0][2] = cost[0][2];

    for (int i = 1; i < N; i++) {
        dp[i][0] = cost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
        dp[i][1] = cost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
        dp[i][2] = cost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
    }
}


TEST CASE:
1)
3
26 40 83
49 60 57
13 89 99

==> 110

2)
6
30 19 5
64 77 64
15 19 97
4 71 57
90 86 84
93 32 91

==> 253

 */

