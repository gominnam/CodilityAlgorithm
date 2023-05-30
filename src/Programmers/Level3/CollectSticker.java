package Programmers.Level3;

import java.util.Arrays;
import java.util.Collections;

public class CollectSticker {
    public int solution(int[] sticker) {
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);

        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[1];
        for(int i=0; i<dp.length-2; i++){
            dp[i+2] = Math.max(dp[i+2], dp[i]+sticker[i+2]);
            if(i+3 >= sticker.length) break;
            dp[i+3] = Math.max(dp[i+3], dp[i]+sticker[i+3]);
        }
        dp[sticker.length-1] = 0;

        int[] dp2 = new int[sticker.length];
        dp2[1] = sticker[1];
        dp2[2] = sticker[2];
        for(int i=1; i<dp2.length-2; i++){
            dp2[i+2] = Math.max(dp2[i+2], dp2[i]+sticker[i+2]);
            if(i+3 >= sticker.length) break;
            dp2[i+3] = Math.max(dp2[i+3], dp2[i]+sticker[i+3]);
        }

        int answer = Math.max(Arrays.stream(dp).max().getAsInt(), Arrays.stream(dp2).max().getAsInt());
        return answer;
    }


    public static void main(String[] args){
        CollectSticker cs = new CollectSticker();
        int[] sticker = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.print(cs.solution(sticker));
    }
}
/*
feed back:

    - 아래 dfs의 풀이법으로는 시간효율성에서 실패 소스
    static boolean[] check;
    static int answer = 0;

    public void dfs(int idx, int sum, int[] sticker){
        if(idx == sticker.length-1){
            if(check[0]) sum-=sticker[idx];
            answer = Math.max(answer, sum);
            return;
        }
        if(idx == sticker.length-2){
            answer = Math.max(answer, sum);
            return;
        }

        for(int i=idx+1; i<sticker.length; i++){
            if(check[i-1]) continue;
            check[i] = true;
            dfs(i, sum+sticker[i], sticker);
            check[i] = false;
        }
    }

    public int solution(int[] sticker) {
        check = new boolean[sticker.length];
        for(int i=0; i<sticker.length; i++){
            check[i] = true;
            dfs(i, sticker[i], sticker);
            check[i] = false;
        }

        return answer;
    }



 */
