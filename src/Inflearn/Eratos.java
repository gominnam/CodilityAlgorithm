package Inflearn;

import java.util.Scanner;

public class Eratos {
    public int Solve(int n){
        int answer = 0;

        for(int i=2; i<=n; i++){
            if(isPrime(i)) answer++;
        }

        return answer;
    }

    public boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0)  return false;
        }

        return true;
    }

    public static void main(String[] args){
        Eratos T = new Eratos();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(T.Solve(num));
    }
}
