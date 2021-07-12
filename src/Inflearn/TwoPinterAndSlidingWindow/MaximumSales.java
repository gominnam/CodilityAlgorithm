package Inflearn.TwoPinterAndSlidingWindow;

import java.util.Scanner;

public class MaximumSales {
    public int solution(int n, int m, int[] a){
        int max = 0;
        int p1 = 0, p2 = m;
        for(int i=0; i<m; i++){
            max += a[i];
        }
        int tmp = max;
        while(p2 < n){
            tmp = tmp - a[p1++] + a[p2++];
            max = Math.max(max, tmp);
        }

        return max;
    }

    public static void main(String[] args){
        MaximumSales T = new MaximumSales();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, m, a));
    }
}
/*
SlidingWindow 문제
현수의 아빠는 제과점을 운영합니다. 현수 아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액이 얼마인지 구하라고 했습니다.

만약 N=10이고 10일 간의 매출기록이 아래와 같습니다. 이때 K=3이면

12 1511 20 2510 20 19 13 15

연속된 3일간의 최대 매출액은 11+20+25=56만원입니다.

여러분이 현수를 도와주세요.

TEST CASE:
10 3
12 15 11 20 25 10 20 19 13 15

==> 56

 */