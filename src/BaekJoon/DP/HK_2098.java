package BaekJoon.DP;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class HK_2098 {
    private static int N;
    private static int[][] W;
    private static int[][] dp;
    private static final int INF = 1000000 * 16 + 1;

    private static int tsp(int current, int visited) {
        // 모든 도시를 방문 했을 경우
        if (visited == (1 << N) - 1) { // 1 << N(4) - 1 = 15 ==> 1111(2)
            //마지막 위치에서 처음 위치로 이동 ( 처음호출 때 tsp(0, 1) 이므로 W[current][0] 에서 0의 값의 의미
            return W[current][0] == 0 ? INF : W[current][0];
        }

        // 메모제이션: 이미 계산된 값이면 반환하여 중복 계산 방지
        if (dp[current][visited] != -1) {
            return dp[current][visited];
        }

        // 다음 도시 탐색
        dp[current][visited] = INF; // 가능한 경로 탐색 전에 현재 상태를 INF로 설정
        for (int next = 0; next < N; next++) {
            // 다음 도시가 이미 방문한 도시 || 현재도시에서 다음 도시로 갈 수 없는 경우
            if((visited & (1 << next)) == 1 || W[current][next] == 0){
                continue;
            }

            // 다음도시를 방문 처리 하기 위해 비트 마스킹
            int nextVisited = visited | (1 << next);
            // 현재 도시에서 다음 도시로 가는 비용과 다음 도시에 시작하여 출발점으로 돌아오는 최소 비용  재귀적 계산
            int cost = W[current][next] + tsp(next, nextVisited);
            // 최소 비용 계산
            dp[current][visited] = Math.min(dp[current][visited], cost);
        }

        return dp[current][visited];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0 ; j<N; j++){
                W[i][j] = Integer.parseInt(input[j]);
            }
        }
        dp = new int[N][1 << N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        bw.write(String.valueOf(tsp(0, 1)));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*

Thinking:
외판원 문제(Traveling Salesman Problem, TSP)

TSP는 NP-hard 문제로, 효율적인 알고리즘을 찾기가 어렵습니다. 하지만 기본적인 해결 방법은 다음과 같습니다:
- 브루트 포스(Brute Force) 접근법: 모든 가능한 경로를 탐색하고 가장 짧은 경로를 찾습니다.
- 동적 프로그래밍(Dynamic Programming) 접근법: 메모이제이션을 사용하여 중복 계산을 피하면서 최적의 경로를 찾습니다.
  예를 들어, 헬드-카프(Held-Karp) 알고리즘(시간 복잡도는 O(N^2 * 2^N))이 있습니다.


-ref: https://withhamit.tistory.com/246

TEST CASE:
1)
4
0 10 15 20
5 0 9 10
6 13 0 12
8 8 9 0

==> 35

*/