package Inflearn.Array;

import java.util.Scanner;

public class PrintLargeNumber {
    public String solution(String str, int n) {
        String[] nums = str.split(" ");
        StringBuilder sb = new StringBuilder(nums[0]);
        for(int i=1; i<n; i++){
            int n1 = Integer.parseInt(nums[i-1]);
            int n2 = Integer.parseInt(nums[i]);
            if(n2 > n1){
                sb.append(" " + n2);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        PrintLargeNumber m = new PrintLargeNumber();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        System.out.print(m.solution(str, n));
    }
}
/*
1. 큰 수 출력하기
설명

N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.

(첫 번째 수는 무조건 출력한다)


입력
첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.


출력
자신의 바로 앞 수보다 큰 수만 한 줄로 출력한다.

TEST CASE:
6
7 3 9 5 6 12


==> 7 9 6 12
 */
