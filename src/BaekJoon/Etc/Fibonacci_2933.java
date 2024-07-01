package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_2933 {
    public static final long MOD = 1000000L;
    public static final long[][] unitMatrix = {{1, 1}, {1, 0}};

    static long[][] pow(long exp) { // exponential: 지수
        if (exp == 0) {
            return new long[][]{{1, 0}, {0, 1}}; // 항등원
        }
        long[][] matrix = pow(exp / 2);
        matrix = multiply(matrix, matrix);
        if (exp % 2 == 1) {
            matrix = multiply(matrix, unitMatrix);
        }
        return matrix;
    }

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                    C[i][j] %= MOD;
                }
            }
        }
        return C;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] result = pow(n - 1);
        System.out.println(result[0][0]);
    }
}

/*
-ref: https://www.acmicpc.net/problem/2749

thinking:
피보나치 수열의 n번째 항을 구하는 것을 행렬로 나타내기
| 1 1 |^n   = | F(n+1) F(n)   |
| 1 0 |       | F(n)   F(n-1) |


TEST CASE:
1000

==>228875

 */