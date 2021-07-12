package Inflearn.TwoPinterAndSlidingWindow;

import java.util.Scanner;

public class ContinuityNaturalNumberSum {
    public int solution(int n){
        int answer = 0;
        int sum = 0, lp = 0;
        for (int p = 0; p < n; p++) {
            sum += p;
            if(sum == n) answer++;
            while(sum > n){
                sum -= lp++;
                if(sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        ContinuityNaturalNumberSum T = new ContinuityNaturalNumberSum();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }
}

/*
N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.

만약 N=15이면

7+8=15

4+5+6=15

1+2+3+4+5=15

와 같이 총 3가지의 경우가 존재한다.

TEST CASE:
15

==> 3
 */
