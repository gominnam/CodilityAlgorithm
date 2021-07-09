package Inflearn;

import java.util.Scanner;

public class ScoreCalculation {
    public int Solve(int n, int[] arr){
        int answer = 0;
        int contCor = 1;
        for(int x : arr){
            if(x == 1){
                answer += contCor;
                contCor++;
            }
            else contCor = 1;
        }

        return answer;
    }

    public static void main(String[] args){
        ScoreCalculation T = new ScoreCalculation();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(T.Solve(n, arr));
    }
}
