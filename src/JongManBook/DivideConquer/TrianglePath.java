package JongManBook.DivideConquer;

import java.io.*;
import java.util.*;

public class TrianglePath {
    static int[][] tri;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int N = Integer.parseInt(br.readLine());
            tri = new int[N][N];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<=j; k++){
                    tri[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write(solve(0, 0, N, 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int y, int x, int N, int ret){
        if(y==N) return ret;

        int cur = tri[y][x] + ret;
        return Math.max(solve(y+1, x, N, cur), solve(y+1, x+1, N, cur));
    }
}
/*
TEST CASE:
2
5
6
1  2
3  7  4
9  4  1  7
2  7  5  9  4
5
1
2 4
8 16 8
32 64 32 64
128 256 128 256 128

==>
28
341
 */