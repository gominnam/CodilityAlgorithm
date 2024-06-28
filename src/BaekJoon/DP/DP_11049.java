package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] p = new int[N + 1];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            p[i] = Integer.parseInt(input[0]);
            p[i + 1] = Integer.parseInt(input[1]);
        }

        long[][] dp = new long[N][N];
        for (int l = 2; l <= N; l++) { // 고려해야하는 행렬 갯수가 2개부터 시작
            for (int i = 0; i <= N - l; i++) { // 시작 행렬의 인덱스 (N - l을 하는 이유는 마지막에 l개 만큼의 행렬을 선택해야 하므로)
                int j = i + l - 1; // 끝 행렬의 인덱스(i에서부터 l개의 행렬이므로 마지막 행렬 인덱스)
                dp[i][j] = Long.MAX_VALUE;
                for (int k = i; k < j; k++) { // 분할지점으로 i와 j 사이에 변하는 인덱스
                    long cost = dp[i][k] + dp[k + 1][j] + (long) p[i] * p[k + 1] * p[j + 1];
                    // dp[i][k] 행렬 i ~ k 까지 최소비용
                    // dp[k+1][j] 행렬 k+1 ~ j 까지 최소비용
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}

/*

thinking:
Matrix Chain Multiplication

TEST CASE:
3
5 3
3 2
2 6

=> 90

TEST CASE:
8
5 10
10 20
20 40
40 20
20 10
10 5
5 2
2 1

=> 2110

5
5 3
3 2
2 6
6 4
4 4

 */