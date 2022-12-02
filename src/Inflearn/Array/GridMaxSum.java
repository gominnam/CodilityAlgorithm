package Inflearn.Array;

import java.util.Scanner;

public class GridMaxSum {
    public int Solve(int n, int[][] arr){
        int max = Integer.MIN_VALUE;

        //각 열의 합 최대값 구하기
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += arr[i][j];
            }
            max = Math.max(max, sum);
        }

        //각 행의 합 최대값 구하기
        for(int i=0; i<n; i++){
            int sum = 0;
            for(int j=0; j<n; j++){
                sum += arr[j][i];
            }
            max = Math.max(max, sum);
        }
        int tmp = 0;
        for(int i = 0, j = 0; i<n; i++, j++){
            tmp += arr[i][j];
        }
        max = Math.max(max, tmp);

        int tmp2 = 0;
        for(int i = n-1, j = n-1; i>0; i--, j--){
            tmp2 += arr[i][j];
        }
        max = Math.max(max, tmp2);

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
/*
격자판 최대합
설명

5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


입력
첫 줄에 자연수 N이 주어진다.(2<=N<=50)

두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


출력
최대합을 출력합니다.

TEST CASE:
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

==>
155
 */
}