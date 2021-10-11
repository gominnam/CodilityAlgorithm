package BaekJoon.Etc;

import java.io.*;

public class G_2023 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dfs("", 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(String s, int depth){
        if(depth == N){
            sb.append(s).append("\n");
        }
        for(int i=1; i<=9; i++){
            int cur = Integer.parseInt(s + i);
            if(isPrime(cur)){
                dfs(cur + "", depth + 1);
            }
        }
    }

    public static boolean isPrime(int a){
        if(a == 1) return false;
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a % i == 0) return false;
        }
        return true;
    }
}
/*
        ## 에라토스의 체 활용
 */