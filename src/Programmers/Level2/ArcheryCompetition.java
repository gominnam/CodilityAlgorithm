package Programmers.Level2;

import java.util.Arrays;

public class ArcheryCompetition {
    public static int maxScore = Integer.MIN_VALUE;
    public static int[] answer = new int[11];
    public void getScore(int[] info, int[] comb){
        int score = 0;
        for(int i=0, j=10; i<=10; i++, j--){
            if(info[i] == 0 && comb[i] == 0) continue;
            if(info[i] >= comb[i]) score -= j;
            else score += j;
        }
        if(score <= 0) return;
        if(score>maxScore) {
            maxScore = score;
            answer = Arrays.copyOf(comb, 11);
        }
        else if(score == maxScore){
            for(int i=10; i>=0; i--){
                if(comb[i] < answer[i]) break;
                else if(comb[i] > answer[i]){
                    answer = Arrays.copyOf(comb, 11);
                    break;
                }
            }
        }
    }

    public void combi(int n, int l, int[] info, int[] comb){
        if(l == 10) {
            comb[l] = n;
            getScore(info, comb);
            return;
        }
        if(info[l] < n) {
            comb[l] = info[l]+1;
            combi(n-info[l]-1, l+1, info, comb);
            comb[l] = 0;
        }
        combi(n, l+1, info, comb);
    }

    public int[] solution(int n, int[] info) {
        combi(n, 0, info, new int[11]);
        if(maxScore > 0) return answer;
        return new int[]{-1};
    }

    public static void main(String[] args){
        ArcheryCompetition ac = new ArcheryCompetition();
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        for(int i : ac.solution(n, info)){
            System.out.print(i + " ");
        }
    }
}
/*
feedback:

깊은 복사를 안해서 생기는 오류
그리고 함수를 쪼갤때(조합에서) 어떻게 해야 더 효율적인지 고민해봐야 함

 */