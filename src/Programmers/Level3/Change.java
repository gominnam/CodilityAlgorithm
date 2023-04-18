package Programmers.Level3;

import java.util.Arrays;
import java.util.Collections;

public class Change {
    static int[] dp = new int[100002];

    public int solution(int n, int[] money) {
        dp[0] = 1;
        for(int i=0; i<money.length; i++){
            for(int j=money[i]; j<=n; j++){
                dp[j] += dp[j-money[i]];
                dp[j] %= 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Change c = new Change();
        int n = 5;
        int[] money = {1,2,5};
        System.out.print(c.solution(n, money));
    }
}
/*
feedback:
아래의 완전 탐색으로 효율성 탐색 통과 실패

    public int calculator(int n, int idx, int[] money){
        if(idx == money.length-1 && n%money[idx] == 0)
            return 1;
        else if(idx == money.length-1)
            return 0;

        int j = n/money[idx];
        int curChange = money[idx];
        int cnt = 0;
        while(j >= 0) {
            cnt += calculator(n-(curChange*j), idx+1, money);
            j--;
        }
        return cnt;
    }

    public int solution(int n, int[] money) {
        int answer = 0;
        answer = answer+calculator(n, 0, money)%1000000007;
        return answer;
    }

how to?
=> dp, cache 소스로 수정


 */