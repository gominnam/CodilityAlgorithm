package JongManBook.Chapter8_DynamicProgramming;

import java.io.*;
import java.util.*;

public class JoinedLongestIncreasingSubsequence {
    static int n, m;
    static int[] A = new int[100], B = new int[100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());
        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<arr1.length; j++){
                arr1[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<arr2.length; j++){
                arr2[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(solve(arr1, arr2) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static int solve(int[] arr1, int[] arr2){
        return 1;
    }
}
