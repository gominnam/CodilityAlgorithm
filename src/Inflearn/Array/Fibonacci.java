package Inflearn.Array;

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

/*
피보나치 수열
설명

1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


입력
첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


출력
첫 줄에 피보나치 수열을 출력합니다.

TESTCASE:
11

=> 1 1 2 3 5 8 13 21 34 55 89
 */