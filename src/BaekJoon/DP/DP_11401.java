package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_11401 {
    public static final int MOD = 1000000007;

    // 거듭제곱을 모듈러로 계산하는 함수
    public static long power(long x, long y) {
        long res = 1L;
        while (y > 0) {
            if (y % 2 == 1) {
                res *= x;
                res %= MOD;
            }
            x *= x;
            x %= MOD;
            y /= 2;
        }
        return res;
    }

    // 팩토리얼 초기화 및 계산 함수
    public static long factorial(int n) {
        long fact = 1L;
        for (int i = 1; i <= n; i++) {
            fact = (fact * i) % MOD;
        }
        return fact;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long factN = factorial(N);
        long factK = factorial(K);
        long factNK = factorial(N - K);
        long denominator = (factK * factNK) % MOD; // K! * (N-K)! % MOD
        long result = (factN * power(denominator, MOD - 2)) % MOD; // MOD-2는 p-2를 의미

        System.out.println(result);
    }
}

/*
TEST CASE:
5 2

=> 10

--------------------------------------------------------------------
Thinking:

!!! DP 방법으로는 메모리 초과 발생 크기가 작은 경우에는 해결 가능
!!! 수학적 접근으로 해결해야 함


이항계수 식
nCk = n-1Ck-1 + n-1Ck

++ 시간초과와 메모리 초과로 인한 해결방법

1)
모듈러연산
a = b(mod p) // b는 a를 p로 나눈 나머지

모듈러의 역원
a * b ≡ 1 (mod p) // a와 p는 서로소

ex) 2 * a^-1 ≡ 1 (mod 7) // 2의 역원은 4

2)
페르마의 소정리
- a^(p-1) ≡ 1 (mod p) // a^p ≡ a (mod p)
- a는 정수이고 p는 소수일 때. 단, a와 p는 서로소

페르마 소정리와 곱의 역원
- a^(p-1) ≡ 1 (mod p)
- a * a^(p-2) ≡ 1 (mod p) // a를 각 변에 나누면 a^(p-2)가 a의 역원
- a^(p-2) = a^-1(mod p)를 이용해 역원을 구할 수 있음
- !! 최종이항계수 계산: nCk = n! * k!^(p-2) * (n-k)!^(p-2) (mod p) // % p


-위의 공식 이해 reference site: https://latte-is-horse.tistory.com/9

 */