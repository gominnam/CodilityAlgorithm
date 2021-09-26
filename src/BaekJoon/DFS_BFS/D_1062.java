package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class D_1062 {
    static boolean[] visited;
    static String[] words;
    static int N, K, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            words[i] = st.nextToken().replace("anta", "").replace("tica", "");
        }
        if(K < 5) {
            System.out.println(0);
            return;
        } else if(K == 26){
            System.out.println(N);
            return;
        }

        visited = new boolean[26];
        visited['a' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;

        bactracking(0, 0);
        System.out.println(max);
    }
    public static void bactracking(int s, int l){
        if(l == (K - 5)){
            int count = 0;
            for(String str : words){
                boolean chk = true;
                for(char c : str.toCharArray()){
                    if(!visited[c - 'a']){
                        chk = false;
                        break;
                    }
                }
                if(chk) count++;
            }
            max = Math.max(max, count); 
        }

        for(int i=s; i<26; i++){
            if(visited[i] == false){
                visited[i] = true;
                bactracking(i, l+1);
                visited[i] = false;
            }
        }
    }
}
/*
    ## backtracking

 - 알파벳을 기준으로 DFS 알고리즘 사용하여 counting 값을 기준으로 MAX 값 보여주기

 */
