package BaekJoon.DP;

import java.io.*;
import java.util.StringTokenizer;

public class DP_11066 {
    static int[] ar = new int[501];
    static int[][] dp = new int[501][501];
    static int[] mem = new int[501];

    public static int getMinCost(int i, int j){
        if(i == j) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        dp[i][j] = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            dp[i][j] = Math.min(dp[i][j], getMinCost(i, k) + getMinCost(k+1, j));
        }
        return dp[i][j] += mem[j] - (i > 0 ? mem[i-1] : 0); // cache the result
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            dp = new int[501][501];
            int K = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<K; i++){
                ar[i] = Integer.parseInt(st.nextToken());
                mem[i] = ar[i] + (i > 0 ? mem[i - 1] : 0);
            }
            bw.write(getMinCost(0, K-1)+ "\n");
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