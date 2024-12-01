package LeetCode.Array.medium;


public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }

        int maxLen = 0;
        int h = matrix.length;
        int w = matrix[0].length;
        int[][] dp = new int[h+1][w+1];

        for(int i=1; i<=h; i++){
            for(int j=1; j<=w; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }

    public static void main(String[] args){
        MaximalSquare ms = new MaximalSquare();
        char[][] matrix = {{'1','0','1','0','0'},
                           {'1','0','1','1','1'},
                           {'1','1','1','1','1'},
                           {'1','0','0','1','0'}}; //answer:4

        System.out.println(ms.maximalSquare(matrix));
    }
}

/*

#Feedback
: BFS, DFS 로만 접근하려고함. (시간초과 발생)
: BruteForce 먼저 고려하고, 시간 복잡도 문제 때문에 DP가 가능한지 고려해야함.
    - 반복되는 부분 문제가 있는지
    - 특정 위치에서 가장 큰 정사각형을 찾기 위해 그 위치의 왼쪽, 위쪽, 대각성 위쪽 값을 참조하기


#Thinking
:Dynamic Programming, DP
- 문제에서 정사각형으로 한정지은 것에 생각해봐야함. (힌트)
- 첫번째 열만 dp가 없으므로 잘 고려한다. (index out of range)

-ref: https://leetcode.com/problems/maximal-square/description/

 */