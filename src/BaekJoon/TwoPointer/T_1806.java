package BaekJoon.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class T_1806 {

    public static int getAnswer(int[] arr, int S){
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = Integer.MAX_VALUE;
        while(true){
            if(sum >= S){
                len = Math.min(len, right - left);
                sum -= arr[left++];
            }else if(right == arr.length){
                break;
            }else{
                sum += arr[right++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int arr[] = new int[N];
        input = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        System.out.print(getAnswer(arr, S));
    }
}

/*

투 포인터로 해결하는 문제


 */