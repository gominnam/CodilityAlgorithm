package JongManBook.Chapter8_DynamicProgramming;

import java.io.*;
import java.util.*;

public class JoinedLongestIncreasingSubsequence {
    static int N, M;
    static int[] A, B;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            cache = new int[N+1][M+1];
            for(int j=0; j<N+1; j++){
                Arrays.fill(cache[j], -1);
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<A.length; j++){
                A[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<B.length; j++){
                B[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(-1, -1) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int solve(int indexA, int indexB){
        int ret = cache[indexA+1][indexB+1];
        if(ret != -1) return ret;
        //A[indexA], B[indexB]가 이미 존재하므로 2개는 항상 있다.
        ret = 0;
        long a = (indexA == -1 ? Long.MIN_VALUE : A[indexA]);
        long b = (indexB == -1 ? Long.MIN_VALUE : B[indexB]);
        long maxElement = Math.max(a, b);

        //다음 원소 찾기
        for(int nextA = indexA+1; nextA < N; nextA++){
            if(maxElement < A[nextA]){
                ret = Math.max(ret, solve(nextA, indexB) + 1);
            }
        }
        for(int nextB = indexB+1; nextB < M; nextB++){
            if(maxElement < B[nextB]){
                ret = Math.max(ret, solve(indexA, nextB) + 1);
            }
        }

        return cache[indexA+1][indexB+1] = ret;
    }
}
/*
TESTCASE:
4
3 3
1 2 4
3 4 7
3 3
1 2 3
4 5 6
5 3
10 20 30 1 2
10 20 30
3 3
1 9 4
3 4 7
==>
5
6
5
5


1
3 3
1 9 4
3 4 7
 */
