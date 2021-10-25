package JongManBook.DivideConquer;

import java.io.*;
import java.util.StringTokenizer;

public class JumpGame {
    static int[][] cache;
    static int[][] board;
    static int cacheSize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            cacheSize = Integer.parseInt(br.readLine());
            cache = new int[cacheSize][cacheSize];
            board = new int[cacheSize][cacheSize];
            for(int j=0; j<cacheSize; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<cacheSize; k++){
                    board[j][k] = Integer.parseInt(st.nextToken());
                    cache[j][k] = -1;
                }
            }
            if(solve(0, 0) == 1) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int y, int x){
        //기저사례 보트판을 벗어난 경우
        if(y >= cacheSize || x >= cacheSize) return 0;
        if(y == cacheSize-1 && x == cacheSize-1) return 1;
        //메모제이션
        if(cache[y][x] != -1) return cache[y][x];
        int move = board[y][x];
        return cache[y][x] = solve(y+move, x) | solve(y, x+move); //비트연산자 둘중 하나라도 1이면 return 1;
    }
}
/*
TEST CASE:
2
7
2 5 1 6 1 4 1
6 1 1 2 2 9 3
7 2 3 2 1 3 1
1 1 3 1 7 1 2
4 1 2 3 4 1 2
3 3 1 2 3 4 1
1 5 2 9 4 7 0
7
2 5 1 6 1 4 1
6 1 1 2 2 9 3
7 2 3 2 1 3 1
1 1 3 1 7 1 2
4 1 2 3 4 1 3
3 3 1 2 3 4 1
1 5 2 9 4 7 0

==>
YES
NO
 */
