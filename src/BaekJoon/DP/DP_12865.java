package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            input = br.readLine().split(" ");
            W[i] = Integer.parseInt(input[0]);
            V[i] = Integer.parseInt(input[1]);
        }
        for (int i = 1; i <= N; i++) { // i 번째의 물건까지 고려
            for (int j = 1; j <= K; j++) { // 무게 제한이 j 일 때의 최대 가치
                if (j < W[i]) { //  현재 아이템의 무게가 배낭의 용량을 초과한다면, 이 아이템을 추가할 수 없으므로, 이전 아이템들만 고려한 최대 가치를 그대로 유지합니다.
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
//                    1. 현재 아이템을 추가하는 경우: 현재 아이템의 가치(value[i - 1])와, 이 아이템을 추가하기 전의 최대 가치(K[i - 1][w - weight[i - 1]])를 합산합니다.
//                    2. 현재 아이템을 추가하지 않는 경우: 현재 아이템을 추가하지 않고 이전 아이템들만 고려한 최대 가치(K[i - 1][w]).
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}

/*

TEST CASE:
4 7
6 13
4 8
3 6
5 12

==> 14


#, Knapsack Algorithm(냅색 알고리즘)

- DP의 대표적인 예시 문제이다.
- 한정된 용량에 최대의 효용을 갖는 방법을 찾는 문제

위의 문제는 0/1 냅색 문제이다.
- 0/1 냅색 문제란, 물건을 쪼갤 수 없는 경우를 말한다.
  즉, 0: 넣지 않기, 1: 넣기


 */