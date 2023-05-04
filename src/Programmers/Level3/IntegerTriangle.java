package Programmers.Level3;

public class IntegerTriangle {
    public static int[][] dp;

    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int n = triangle.length;
        dp = new int[n][n];

        if(n == 1) return triangle[0][0];

        dp[0][0] = triangle[0][0];
        for(int i=1; i<n; i++){
            dp[i][0] = dp[i-1][0]+triangle[i][0];
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+triangle[i][j];
            }
        }

        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }

        return answer;
    }

    public static void main(String[] args){
        IntegerTriangle it = new IntegerTriangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.print(it.solution(triangle));
    }
}
