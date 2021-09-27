package BaekJoon.Etc;

import java.io.*;
import java.util.StringTokenizer;

public class TwoPointer_1806 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = 0, sum = 0;
        int min = Integer.MAX_VALUE;
        while(true){
            if(sum >= S){
                min = Math.min(min, r - l);
                sum -= arr[l++];
            }
            else if(r == N) break;
            else sum += arr[r++];
        }

        if(min == Integer.MAX_VALUE) min = 0;

        System.out.println(min);
    }
}
/*
        ## 부분합

    TIP : Two Pointer
 */
