package BaekJoon.DFS_BFS;

import java.io.*;

public class B_3085 {
    static char[][] board;
    static int[] mx = {0, 0, -1, 1};
    static int[] my = {1, -1, 0, 0};
    static int answer = 0;

    public static void calculator(){
        int N = board.length;
        for (int i=0 ; i<N; i++) {
            int count = 1;
            for (int j=0; j<N-1; j++) {
                if (board[i][j] == board[i][j+1]) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                }
            }
        }
        for (int i=0 ; i<N; i++) {
            int count = 1;
            for (int j=0; j<N-1; j++) {
                if (board[j][i] == board[j+1][i]) {
                    count++;
                    answer = Math.max(count, answer);
                } else {
                    count = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                board[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               for(int k=0; k<4; k++){
                   int nx = i+mx[k];
                   int ny = j+my[k];
                   if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                   if(board[i][j] != board[nx][ny]) {
                          char temp = board[i][j];
                          board[i][j] = board[nx][ny];
                          board[nx][ny] = temp;
                          calculator();
                          temp = board[i][j];
                          board[i][j] = board[nx][ny];
                          board[nx][ny] = temp;
                   }
               }
            }
        }
        sb.append(answer);
        bw.write(sb.toString());
        bw.flush();
    }
}
