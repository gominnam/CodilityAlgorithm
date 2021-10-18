package JongManBook.Chapter06_DFS;

import java.io.*;
import java.util.*;

public class BoardCover {
    static int[][][] pieces = { { {0, 0}, {0, 1}, {1, 0} },
                                { {0, 0}, {0, 1}, {1, 1} },
                                { {0, 0}, {1, 0}, {1, 1} },
                                { {0, 0}, {1, 0}, {1, -1} } };
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        board = new int[h][w];
        for(int i=0; i<h; i++){
            String str = br.readLine();
            for(int j=0; j<w; j++){
                if(str.charAt(j) == '#') board[i][j] = 1;
                else board[i][j] = 0;
            }
        }

        int answer = dfs();

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean set(int y, int x, int type, int cover){
        boolean ret = true;
        for(int i=0; i<3; i++){
            int ny = y + pieces[type][i][0];
            int nx = x + pieces[type][i][1];
            if(ny < 0 || ny >= board.length || nx < 0 || nx >= board[0].length) ret = false;
            else if((board[ny][nx] += cover) > 1) ret = false;
        }

        return ret;
    }

    public static int dfs(){
        int y = -1, x = -1;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 0){
                    y = i;
                    x = j;
                    break;
                }
            }
            if(y != -1) break;// <----------생략으로 실수한 부분
        }

        if(y == -1) return 1;//기저 사례: 모든칸을 채울 경우 1을 반환
        int ret = 0;
        for(int type=0; type<4; type++){
            if(set(y, x, type, 1)) ret += dfs();
            set(y, x, type, -1);
        }

        return ret;
    }
}
/*
보드판 채우기 문제

TEST CASE:  첫줄 h w : 높이 너비 // h크기만큼 map 정보 #은 차있는 구역 .은 빈공간
3 7
#.....#
#.....#
##...##

==> 0

3 7
#.....#
#.....#
##..###

==> 2

8 10
##########
#........#
#........#
#........#
#........#
#........#
#........#
##########

==> 1514
 */