package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DP_2186 {
    static int N, M, K;
    static char[][] board;
    static int[][][] dp;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static String letter;

    // dp[][][] 메모제이션을 사용하지 않으면 Time Limit Exceeded
    public static int dfs(int x, int y, int idx){
        if(idx == letter.length() - 1) return 1;
        if(dp[x][y][idx] != -1) return dp[x][y][idx];

        dp[x][y][idx] = 0;

        for(int i=0; i<4; i++){
            for(int j=1; j<=K; j++){
                int nx = x + directions[i][0]*j;
                int ny = y + directions[i][1]*j;
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(board[nx][ny] == letter.charAt(idx + 1)) {
                    dp[x][y][idx] += dfs(nx, ny, idx + 1);
                }
            }
        }

        return dp[x][y][idx];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        board = new char[N][M];
        dp = new int[N][M][81];
        for(int i=0; i<N; i++){
            String words = br.readLine();
            for(int j=0; j<M; j++){
                Arrays.fill(dp[i][j], -1);
                board[i][j] = words.charAt(j);
            }
        }
        letter = br.readLine();
        int answer = 0 ;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == letter.charAt(0)){
                    answer += dfs(i, j, 0);
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
/*

Thinking:

dp[][][] 메모제이션을 사용하지 않으면 dfs 문제로 풀이 시간초과 발생 ( dfs 메서드 )
어떻게 메모제이션을 해야할지 고민 3차원 배열까지 사고


TEST CASE:
1)
4 4 1
KAKT
XEAS
YRWU
ZBQP
BREAK

==> 3

*/