package Inflearn.SortingAndSearching;

import java.util.*;

public class OverlapConfirm {
    public String Solve(int n, int[] arr){
        String answer = "U";
        Queue<Integer> Q = new LinkedList<>();
        for(int x : arr){
            if(Q.contains(x)) return "D";
            else Q.offer(x);
        }

        return answer;
    }

    public static void main(String[] args){
        OverlapConfirm T = new OverlapConfirm();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.Solve(n, arr));
    }
}
