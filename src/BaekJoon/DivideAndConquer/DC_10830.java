package BaekJoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DC_10830 {

    public static final int MOD = 1000;

    public static int[][] multiply(int[][] A, int[][] B) {
        int N = A.length;
        int[][] result = new int[N][N];
        for(int i=0; i<N; i++){ // 행
            for(int j=0; j<N; j++){ // 열
                for(int k=0; k<N; k++){ // i번째의 행과 j번째 열을 곱함
                    result[i][j] += A[i][k] * B[k][j] % MOD; // 행고정, 열고정
                }
            }
        }
        return result;
    }

    public static int[][] power(int[][] A, long B){
        if(B == 1){
            return A;
        }
        int[][] temp = power(A, B/2);
        if(B % 2 == 0){
            return multiply(temp, temp);
        }
        else {
            return multiply(multiply(temp, temp), A);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        long B = Long.parseLong(input[1]);
        int[][] A = new int[N][N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                A[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[][] result = power(A, B);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(result[i][j] % MOD).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

/*

-ref: https://www.acmicpc.net/problem/10830



TEST CASE:
2 5
1 2
3 4

==>
69 558
337 406


--------------------------------------------------------------------------

1)
Programming과 그래프 X 축과 Y 축

- int[][] arr = new int[2][3]; // 행(i)은 가로, 열(j)은 세로

ex)
for (int i = 0; i < arr.length; i++) {     // 행을 순회
    for (int j = 0; j < arr[i].length; j++) { // 각 행의 열을 순회
        // arr[i][j]를 처리
    }
}


 */