package BaekJoon.DP;

import java.io.*;

public class DP_9461 {
    static long[] dp = new long[102];
    public long calculator(int t){
        if(t <= 3) return 1;
        if(dp[t]!=0) return dp[t];
        return dp[t] = calculator(t-2)+calculator(t-3);
    }
    public static void main(String[] args) throws IOException {
        DP_9461 main = new DP_9461();
        StringBuilder sb =  new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        int[] cases = new int[n];
        for(int i=0; i<n; i++){
            cases[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            sb.append(main.calculator(cases[i])+"\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

/*

##, feedback

처음에 int[] dp = new int[101] 로 하여 제출시 계속 실패함
데이터 크기를 고려시 int -> long 형으로 변경하여 테스트 성공

 */