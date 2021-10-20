package JongManBook.Chapter06_DFS;

import java.util.*;
import java.io.*;

public class ClockFocus {
    static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
    static char[][] linked = {
            {'x','x','x','.','.','.','.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','x','.','.','.','x','.','x','.','x','.','.','.','.'},
            {'.','.','.','.','x','.','.','.','.','.','x','.','.','.','x','x'},
            {'x','.','.','.','x','x','x','x','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','x','x','x','.','x','.','x','.','.','.'},
            {'x','.','x','.','.','.','.','.','.','.','.','.','.','.','x','x'},
            {'.','.','.','x','.','.','.','.','.','.','.','.','.','.','x','x'},
            {'.','.','.','.','x','x','.','x','.','.','.','.','.','.','x','x'},
            {'.','x','x','x','x','x','.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','x','x','x','.','.','.','x','.','.','.','x','.','.'}
            };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] clocks = new int[16];
        for(int i=0; i<16; i++){
            clocks[i] = Integer.parseInt(st.nextToken());
        }

        int answer = solve(clocks, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
    //모든 시계가 12시인지 확인하는 매서드
    public static boolean areAligned(int[] clocks){
        for(int i=0; i<clocks.length; i++){
            if(clocks[i] != 12) return false;
        }
        return true;
    }
    //swtch번 스위치를 누른다.
    public static void push(int[] clocks, int swtch){
        for(int clock = 0; clock < CLOCKS; ++clock){
            if(linked[swtch][clock] == 'x'){
                clocks[clock] += 3;
                if(clocks[clock] == 15) clocks[clock] = 3;
            }
        }
    }

    public static int solve(int[] clocks, int swtch){
        if(swtch == SWITCHES) return areAligned(clocks) ? 0 : INF;
        int ret = INF;
        for(int cnt = 0; cnt < 4; ++cnt){
            ret = Math.min(ret, cnt + solve(clocks, swtch+1));
            push(clocks, swtch);
        }
        return ret;
    }
}
/*
시계 맞추기

TEST CASE:
12 6 6 6 6 6 12 12 12 12 12 12 12 12 12 12

==> 2

12 9 3 12 6 6 9 3 12 9 12 9 12 12 6 6

==> 9

 */