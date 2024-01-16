package BaekJoon.Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2776 {
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void binarySearch(int target){
        int lo = 0, hi = nums.length-1;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            if(nums[mid] == target){
                sb.append("1").append("\n");
                return;
            }
            if(nums[mid] > target){
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        sb.append("0").append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            nums = new int[N];
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                nums[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(nums);

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                binarySearch(Integer.parseInt(st.nextToken()));
            }
        }
        System.out.print(sb.toString());
    }
}
/*

-BinarySearch(이분탐색)을 사용한 검색

## System.out.println 으로 한 경우 시간초과 발생

 */