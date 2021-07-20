package Inflearn.RecursiveTreeGraph;

import java.util.Scanner;

public class RecursiveMethod {
    public void Solve(int n) {
        if(n > 1) Solve(n-1);
        System.out.print(n + " ");
    }

    public static void main(String[] args){
        RecursiveMethod T = new RecursiveMethod();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        T.Solve(n);
    }
}
