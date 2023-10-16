package BaekJoon.DP;

import java.io.*;

public class DP_14501 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] t = new int[n];
        int[] p = new int[n];
        for(int i=0; i<n; i++){
            String[] tmp = br.readLine().split(" ");
            t[i] = Integer.parseInt(tmp[0]);
            p[i] = Integer.parseInt(tmp[1]);
        }
        for (int i=0; i<n; i++) {
            if (i+t[i]<=n) {
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i]+p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        sb.append(dp[n]);
        bw.write(sb.toString());
        bw.flush();
    }
}
