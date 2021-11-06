package JongManBook.Chapter8_DynamicProgramming;

import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {
    static int dy[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(arr) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int solve(int[] arr){
        int ret = 0;
        dy = new int[arr.length];
        dy[0] = 1;
        for(int i=1; i<arr.length; i++){
            int max = 0;
            for(int j=i-1; j>=0; j--){
                if(arr[j] < arr[i] && dy[j] > max) max = dy[j];
            }
            dy[i] = max+1;
            ret = Math.max(ret, dy[i]);
        }

        return ret;
    }

}
/*
동적계획법 - 시간복잡도 O(n^2)
           각 배열의 최대 길이의 max 값을 cache에 저장한다. 그리고 자신보다 값이 작을 경우 cache에 저장된 값중 가장 큰 값 + 1을 cache에 저장
           max 계산하여 최대 길이를 구한다.

TESTCASE:
3
4
1 2 3 4
8
5 4 3 2 1 6 7 8
8
5 6 7 8 1 2 3 4

==>
4
4
4
 */