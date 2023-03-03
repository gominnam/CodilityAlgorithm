package Inflearn.BFSAndDFS;

import java.util.*;

public class NumberOfCombinations {
    int[][] cache = new int[35][35]; //memozation

    public int solution(int n, int r){ //combination
        if(cache[n][r] > 0) return cache[n][r];
        if(n==r || r==0) return 1;
        else return cache[n][r] = (solution(n-1, r-1) + solution(n-1, r));
    }

    public static void main(String[] args){
        NumberOfCombinations T = new NumberOfCombinations();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(T.solution(n, r));
    }
}
/*
조합의 경우수(메모이제이션)
설명

1. 메모제이션 활용(cache) // 중복연산
2. nCr 조합 ==> nCr = n-1Cr-1 + n-1Cr

입력
첫째 줄에 자연수 n(3<=n<=33)과 r(0<=r<=n)이 입력됩니다.


출력
첫째 줄에 조합수를 출력합니다.

TEST CASE:
5 3

=> 10

 */