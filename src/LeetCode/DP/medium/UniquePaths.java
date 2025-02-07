package LeetCode.DP.medium;

import java.util.LinkedList;
import java.util.Queue;

public class UniquePaths {
    final int[][] move = new int[][]{{0, 1}, {1, 0}};

    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] mv : move){
                int ny = cur[0] + mv[0];
                int nx = cur[1] + mv[1];
                if(ny < m && nx < n && map[ny][nx] == 0) {
                    int sumY = ny - 1 < 0 ? 0 : map[ny - 1][nx];
                    int sumX = nx - 1 < 0 ? 0 : map[ny][nx - 1];

                    map[ny][nx] = sumY + sumX;
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
        return map[m-1][n-1];
    }

    public static int uniquePaths_dp(int m, int n) {
        // DP 테이블 생성
        int[][] dp = new int[m][n];

        // 첫 번째 행과 첫 번째 열을 1로 초기화
        for (int i = 0; i < m; i++) dp[i][0] = 1;  // 첫 번째 열
        for (int j = 0; j < n; j++) dp[0][j] = 1;  // 첫 번째 행

        // DP 테이블 채우기
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // 최종 결과 반환 (우측 하단)
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths o = new UniquePaths();
        System.out.println(o.uniquePaths(3, 7));//28
        System.out.println(o.uniquePaths(3, 2));//3
        System.out.println(o.uniquePaths(7, 3));//28
        System.out.println(o.uniquePaths(3, 3));//6
        System.out.println(o.uniquePaths(1, 2));//1
        System.out.println(o.uniquePaths(2, 1));//1
    }
}

/*

Thinking:
1. BFS와 Backtracking으로 시도
- int sumY = ny - 1 < 0 ? 0 : map[ny - 1][nx]; 이 부분에서 조건을 <= 0 으로 두어 시간이 오래 걸림
- 시간복잡도 DP에 비하면 현저히 느림 // LeetCode 기준 3ms Beats 2.76%

2. DP로 시도
- 시간 복잡도 개선 // LeetCode 기준 0ms Beats 100%

-ref: https://leetcode.com/problems/unique-paths/

 */