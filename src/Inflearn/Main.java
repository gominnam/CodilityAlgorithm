package Inflearn;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] dp;
    static int N, limitTime;

    public static class Question{
        public int score, time;
        public Question(int s, int t){
            this.score = s;
            this.time = t;
        }
    }

    public int solve(ArrayList<Question> questions){
        for(int i=0; i<N; i++){
            Question q = questions.get(i);
            for(int j=limitTime; j>=q.time; j--){
                dp[j] = Math.max(dp[j], dp[j-q.time]+q.score);
            }
        }
        return dp[limitTime];
    }

    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        limitTime = sc.nextInt();
        ArrayList<Question> questions = new ArrayList<>();
        for(int i=0; i<N; i++) {
            questions.add(new Question(sc.nextInt(), sc.nextInt()));
        }
        dp = new int[limitTime+1];
        System.out.print(main.solve(questions));
    }
}
