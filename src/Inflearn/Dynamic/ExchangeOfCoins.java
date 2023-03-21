package Inflearn.Dynamic;

import java.util.*;

public class ExchangeOfCoins {
    static int[] dy;
    static int n, m;

    public int solution(int[] coin){
        dy[0] = 0;
        for(int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                dy[j] = Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];
    }

    public static void main(String[] args){//todo: repeat
        ExchangeOfCoins T = new ExchangeOfCoins();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] coins = new int[n];
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        m = sc.nextInt();
        dy = new int[m+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        System.out.println(T.solution(coins));
    }
}
/*
feedback - Knapsack Algorithm[배낭 알고리즘]
=> Dynamic Programming 사용
=> DFS 는 시간초과 에러

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


//dfs 로는 time limit exceeded Error!!
public void dfs(int L, int count, int money){
        if(L==N && money == 0){
            answer = Math.min(answer, count);
        }
        if(count > answer) return;
        for(int i=L; i<N; i++){
            int curM = coins.get(L);
            for (int j=0; j<=money/curM; j++){
                dfs(L+1, count+j, money-curM*j);
            }
        }
    }
 */