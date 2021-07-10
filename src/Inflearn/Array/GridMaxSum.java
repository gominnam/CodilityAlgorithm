package Inflearn.Array;

import java.util.Scanner;

public class GridMaxSum {
    public int Solve(int n, int[][] arr){
        int max = Integer.MIN_VALUE;
        int sum1 = 0, sum2 = 0;
        //각 행의 합 최대값 구하기, 각 열의 합 최대값 구하기
        for(int i=0; i<n; i++){
            sum1=sum2=0;
            for(int j=0; j<n; j++){
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        //대각선의 최대값 구하기
        sum1=sum2=0;
        for(int i = 0; i<n; i++){
            sum1 += arr[i][i];
            sum2 += arr[n-i-1][n-i-1];
        }

        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        return max;
    }

    public static void main(String[] args){
        GridMaxSum T = new GridMaxSum();

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int arr[][] = new int[num][num];
        for(int i=0; i<num; i++){
            for (int j=0; j<num; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.Solve(num, arr));
    }
}

/*

설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

Image1.jpg

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.

 */