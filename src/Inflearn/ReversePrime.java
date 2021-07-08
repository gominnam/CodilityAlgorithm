package Inflearn;

import java.util.Scanner;

public class ReversePrime {
    public void Solve(int n, String s){
        String[] str = s.split(" ");

        for(String x : str){
            int tmp = Integer.parseInt(new StringBuilder(x).reverse().toString());
            if(isPrime(tmp)){
                System.out.print(tmp + " ");
            }
        }
    }

    public boolean isPrime(int a){
        if(a == 1) return false;
        for(int n=2; n<=Math.sqrt(a); n++){
            if(a%n == 0) return false;
        }
        return true;
    }

    public static void main(String[] args){
        ReversePrime T = new ReversePrime();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        T.Solve(num, s);
    }
}


/* 기본 틀

    public int[] Solve(int n){

    }

    public static void main(String[] args){
        Fibonacci T = new Fibonacci();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        for(int i : T.Solve(num)){
            System.out.print(i + " ");
        }
    }

*/