package Inflearn.Dynamic;

import java.util.*;

public class ExchangeOfCoins {
    static int[] dy;
    static int n, m;

    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args){
        ExchangeOfCoins T = new ExchangeOfCoins();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];
        System.out.println(T.solution(arr));
    }
}
/*
feedback - Knapsack Algorithm[배낭 알고리즘]
         - 큰 수부터 차례로 나누는 간단한 로직으로는 1원이 없을 때 전부 못거슬러주는 문제가 생길 수 있다. 그러므로 dp를 사용해야 한다.
         - 1이 없으면..? 에러가 뜬다. 어떻게 해야할까(나머지를 못나눠주니 상관 없으려나 고민)

설명

다음과 같이 여러 단위의 동전들이 주어져 있을때 거스름돈을 가장 적은 수의 동전으로 교환해주려면 어떻게 주면 되는가?

각 단위의 동전은 무한정 쓸 수 있다.


입력
첫 번째 줄에는 동전의 종류개수 N(1<=N<=50)이 주어진다.

두 번째 줄에는 N개의 동전의 종류가 주어지고, 그 다음줄에 거슬러 줄 금액 M(1<=M<=500)이 주어진다.

각 동전의 종류는 100원을 넘지 않는다.


출력
첫 번째 줄에 거슬러 줄 동전의 최소개수를 출력한다.


TEST CASE:
3
1 2 5
15

==> 3
 */