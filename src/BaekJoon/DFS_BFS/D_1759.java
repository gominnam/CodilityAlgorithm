package BaekJoon.DFS_BFS;

import java.io.*;
import java.util.*;

public class D_1759 {
    static char[] token;
    static int L, N;

    public static void combi(int s, int len, String str){
        if(len == L) {
            int vow = 0;//모음: vowels
            int con = 0;//자음: consonant
            for(char c : str.toCharArray()){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vow++;
                else con++;
            }

            if(vow >= 1 && con >= 2) System.out.println(str);
        }
        else{
            for(int i=s; i<N; i++){
                combi(i+1, len+1, str+token[i]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        token = new char[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            token[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(token);
        combi(0, 0, "");
    }
}
/*
암호만들기

TIP - DFS와 조합

나머지 조건들도 확인하기(꼼꼼하게) 모음 1개 이상, 자음 2개 이상
 */