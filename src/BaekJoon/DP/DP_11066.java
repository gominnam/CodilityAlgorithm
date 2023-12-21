package BaekJoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class DP_11066 {
    public static int getMinCost(int[] numbers){
        int N = numbers.length;
        int[][] dp = new int[N][N];
        int[] sum = new int[N+1];
        for(int i=0; i<N; i++){
            sum[i+1] = sum[i] + numbers[i];
        }
        for(int i=0; i<N-1; i++){
            dp[i][i+1] = numbers[i] + numbers[i+1];
        }
        for(int i=2; i<N; i++){
            for(int j=0; j<N-i; j++){
                dp[j][j+i] = Integer.MAX_VALUE;
                for(int k=0; k<i; k++){
                    int test = dp[j][j+k] + dp[j+k+1][j+i] + sum[j+i+1] - sum[j];
                    dp[j][j+i] = Math.min(dp[j][j+i], dp[j][j+k] + dp[j+k+1][j+i] + sum[j+i+1] - sum[j]);
                }
            }
        }
        return dp[0][N-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            int K = Integer.parseInt(br.readLine());
            int[] numbers = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; j++){
                numbers[j] = Integer.parseInt(st.nextToken());
            }
            bw.write(getMinCost(numbers)+ "\n");
        }
        bw.flush();
        bw.close();
    }
}
/*

TEST CASE:
2
4
40 30 30 50
15
1 21 3 4 5 35 5 4 3 5 98 21 14 17 32


    [ TIP ]
- Solve: 동적계획법 + 누적합
- 점화식: DP[start][end] = DP[start][mid] + DP[mid+1][end] + (files[end] - files[start-1])


누적합 DP의 기본 식: f(x) = f(x-1) + Ax ...

- 1차원 누적합인 경우

int[] arr 이 누적합 값을 갖고 있는 배열이라 하면
int prefixSum = arr[b] - arr[a]; 는 => a+1 index에서 b 까지의 부분합을 나타낸다.


- 2차원 누적합인 경우

int[][] arr 이 누적합 값을 갖고 있는 배열이라 하면

{ { 1, 2, 3, 4},   <-- a, b, c, d
  { 5, 6, 7, 8},   <-- e, f, g, h 변수명으로 가정해보자
  { 9,10,11,12},   <-- i, j, k, l
  {13,14,15,16} }  <-- m, n, o, p 2차원 배열이 있다 하면 부분합은

=>
{ { 1, 3, 6,10},
      ________
  { 6,| 14,24,|36},
  {15,| 33,54,|78},
  {28,| 60,96,|136} } 이다. f변수의 부분합은 14의 결과가 도출되는데 이는 14 = f+(e+b-a) 이다.
      ---------

  그럼 블록을 친 부분합의 경우는? 63이 답이다.
  63 = 96 - 6 - 28 + 1 (==  o - c - m + a) 이다.
  각 블록 사각형의 꼭지점의 위 옆 위치

 */