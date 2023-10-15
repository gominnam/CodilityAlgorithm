package BaekJoon.DP;

import java.io.*;

public class DP_2839 {
    public static int[] dp = new int[5001];
    int[] bag = {3, 5};
    public int calculator(int w){
        if(w==0) return 0;
        if(w<0) return -1;
        if(dp[w]!=0) return dp[w];
        int min = Integer.MAX_VALUE;
        for(int i=0; i<bag.length; i++){
            int tmp = calculator(w-bag[i]);
            if(tmp>=0 && tmp<min){
                min = tmp+1;
            }
        }
        if(min==Integer.MAX_VALUE){
            dp[w] = -1;
            return -1;
        }
        dp[w] = min;
        return min;
    }

    public static void main(String[] args) throws IOException {
        DP_2839 main = new DP_2839();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int weight = Integer.parseInt(br.readLine());
        sb.append(main.calculator(weight));
        bw.write(sb.toString());
        bw.flush();
    }
}
