package BaekJoon.Search;

import java.io.*;
import java.util.StringTokenizer;

public class B_2512 {
    static int N, total;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int L = 0;
        int R = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            R = Math.max(R, arr[i]);
        }
        st = new StringTokenizer(br.readLine());
        total = Integer.parseInt(st.nextToken());
        int ans = Integer.MIN_VALUE;
        while(L <= R){
            int mid = (L + R) / 2;
            int sum = 0;
            for(int x : arr){
                sum += Math.min(x, mid);
            }

            if(sum > total) R = mid-1;
            else {
                L = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        System.out.println(ans);
    }
}

/*
이분탐색 -Binary Search


 */
