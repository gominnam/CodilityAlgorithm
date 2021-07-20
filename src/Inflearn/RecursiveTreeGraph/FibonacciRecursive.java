package Inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class FibonacciRecursive {
    public int Solve(int n) {
        if(n == 1) return 1;
        if(n == 2) return 1;
        else return Solve(n-1) + Solve(n-2);
    }

    public static void main(String[] args){
        FibonacciRecursive T = new FibonacciRecursive();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1; i<=n; i++){
            System.out.print(T.Solve(i) + " ");
        }
    }
}
