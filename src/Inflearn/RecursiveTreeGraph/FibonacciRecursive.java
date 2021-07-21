package Inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class FibonacciRecursive {
    static int[] fibo;
    public int Solve(int n) {
        if(fibo[n] > 0) return fibo[n];
        if(n == 1) return fibo[n] = 1;
        if(n == 2) return fibo[n] = 1;
        else return fibo[n] = Solve(n-1) + Solve(n-2);
    }

    public static void main(String[] args){
        FibonacciRecursive T = new FibonacciRecursive();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n+1];
        T.Solve(n);
        for(int i=1; i<=n; i++){
            System.out.print(fibo[i] + " ");
        }
    }
}

/*
static 배열 활용하기
+ 메모제이션(기존에 구한 값 활용하기)
 */