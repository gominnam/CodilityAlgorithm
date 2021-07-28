package Inflearn.BFSAndDFS;

import java.util.*;

public class ExchangeOfCoin {
    static int n, money, answer = Integer.MAX_VALUE;

    public void solution(int L, int sum, Integer[] arr){
        if(sum > money) return;
        if(L >= answer) return;
        if(sum == money){
            answer = Math.min(answer, L);
        }
        else{
            for(int i=0; i<n; i++){
                solution(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args){
        ExchangeOfCoin T = new ExchangeOfCoin();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr, Collections.reverseOrder());
        money = sc.nextInt();
        T.solution(0, 0, arr);
        System.out.println(answer);
    }
}
/*
설명

다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.


입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=12)이 주어진다. 두 번째 줄에는 N개의 동전의 종류가 주어지고,

그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.각 동전의 종류는 100원을 넘지 않는다.


출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


TEST CASE:
3
1 2 5
15

==> 3

feedBack : Money를 전역변수로하여 큰수보다 크면 -(뺴기) 처리를 하는 로직을 짰는데 거슬러주지 못하는 경우의 수가 있음.
            그러므로, 더하기를 하여 sum이 money보다 크면 return을 하고 같으면 min 값을 업데이트 하는 방식의 로직을 짜야 한다.

           + 시간복잡도 이미 답을 구했으면 끝내는 로직 추가하기

           + BFS가 더 효율적일 수 있음 Level이 짧아서서
 */