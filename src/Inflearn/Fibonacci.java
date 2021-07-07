package Inflearn;

import java.util.*;

public class Fibonacci {
    public int[] Solve(int n){
        int[] answer = new int[n];

        for(int i=0; i<n; i++){
            if(i <= 1)
                answer[i] = 1;
            else
                answer[i] = answer[i-1] + answer[i-2];
        }

        return answer;
    }

    public static void main(String[] args){
        Fibonacci T = new Fibonacci();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i : T.Solve(num)){
            System.out.print(i + " ");
        }
    }
}
