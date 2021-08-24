package Inflearn.Dynamic;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    static int n;
    static int[] sub;
    int answer = 0;

    public void solution(int cur,  int i, int sum){
        //고르고 안고르고 다음수가 더 커야 아니면 안고르고
        if(n==i) {
            answer = Math.max(sum, answer);
            return;
        }
        solution(cur, i+1, sum);
        if(sub[cur] < sub[i+1]) solution(i+1, i+1, sum+1);
    }

    public static void main(String[] args){
        LongestIncreasingSubsequence T = new LongestIncreasingSubsequence();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sub = new int[n];
        for(int i=0; i<n; i++){
            sub[i] = sc.nextInt();
        }
        T.solution(0, 0, 1);//고르고
        T.solution(0, 0, 0);//안고르고

        System.out.println(T.answer);
    }
}
/*
설명

N개의 자연수로 이루어진 수열이 주어졌을 때, 그 중에서 가장 길게 증가하는(작은 수에서 큰 수로) 원소들의 집합을 찾는 프로그램을 작성하라.

예를 들어, 원소가 2, 7, 5, 8, 6, 4, 7, 12, 3 이면 가장 길게 증가하도록 원소들을 차례대로 뽑아내면 2, 5, 6, 7, 12를 뽑아내어

길이가 5인 최대 부분 증가수열을 만들 수 있다.


입력
첫째 줄은 입력되는 데이터의 수 N(3≤N≤1,000, 자연수)를 의미하고,

둘째 줄은 N개의 입력데이터들이 주어진다.


출력
첫 번째 줄에 부분증가수열의 최대 길이를 출력한다.

TEST CASE:
8
5 3 7 8 6 2 9 4

==> 4
 */