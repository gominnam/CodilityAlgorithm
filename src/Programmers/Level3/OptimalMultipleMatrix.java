package Programmers.Level3;

public class OptimalMultipleMatrix {

    public static void main(String[] args){
        int[][] matrix_sizes = {{5, 3}, {3, 10}, {10, 6}, {6, 8}};
        int n = matrix_sizes.length;
        int dp[][] = new int[n][n];
        for (int len = 1; len < n; len++) { // 문제의 길이 (1부터 n-1까지)
            for (int i = 0; i < n - len; i++) { // 시작점 인덱스
                int j = i + len; // 끝점 인덱스
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) { // 중간점 인덱스
                    // k 분기점 기준으로 좌측 우측 dp 값 더하고 마지막 행렬곱 계산
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k+1][j] + matrix_sizes[i][0] * matrix_sizes[k][1] * matrix_sizes[j][1]);
                }
            }
        }
        System.out.println(dp[0][n-1]);
    }
}

/*

Thinking:
1)
Dynamic Programming
- dp[i][j] = i번째 행렬부터 j번째 행렬까지의 곱셈 연산의 최소값

-ref: https://school.programmers.co.kr/learn/courses/30/lessons/12942

 */
