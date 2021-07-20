package Inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class Factorial {
    public int Solve(int n) {
        if(n == 1) return 1;
        return n * Solve(n-1);
    }

    public static void main(String[] args){
        Factorial T = new Factorial();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.Solve(n));
    }
}
