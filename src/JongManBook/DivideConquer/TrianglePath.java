package JongManBook.DivideConquer;

import java.io.*;
import java.util.*;

public class TrianglePath {
    static int[][] tri;
    static int[][] cache = new int[100][100];//memozation

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
            //bw.write(solve(0, 0, N, 0) + "\n");
            bw.write(solve2(0, 0, N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve2(int y, int x, int N){
        if(y==N-1) return tri[y][x];
        //메모제이션
        int ret = cache[y][x];
        if(ret != 0) return ret;
        return Math.max(solve2(y+1, x, N), solve2(y+1, x+1, N)) + tri[y][x];
    }

    /* 시간초과 */
    public static int solve(int y, int x, int N, int ret){
        if(y==N) return ret;

        int cur = tri[y][x] + ret;
        return Math.max(solve(y+1, x, N, cur), solve(y+1, x+1, N, cur));
    }
}
/*
feedBack - 일반 완전탐색으로 할 경우 길이가 100인 경우 2^100-1의 경우의 수 가 있으므로 시간초과가 발생한다.
           메모제이션인 경우에는 길이만큼 전부 메모리를 할당하는 경우 메모리 사용량이 너무 많다.
           즉, 점화식을 변경해야 하는데 전체 경로의 최대 합을 반환하는 것이 아니라 !!부분 경로의 최대합!!을 반환하는것이 중요 포인트다.
           -> 거꾸로 계산하면서 올라간다.

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