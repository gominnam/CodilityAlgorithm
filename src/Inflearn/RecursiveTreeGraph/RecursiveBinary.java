package Inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class RecursiveBinary {
    public void Solve(int n) {
        if(n==0) return;
        Solve(n/2);
        System.out.print(n%2);
    }

    public static void main(String[] args){
        RecursiveBinary T = new RecursiveBinary();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        T.Solve(n);
    }
}
