package BaekJoon.Etc;

import java.io.*;

public class KMP_16916 {
    static String sentence, word;
    static int[] pi;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sentence = br.readLine();
        word = br.readLine();
        pi = new int[word.length()];
        getPi();
        KMP();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void getPi(){
        int j = 0;
        for(int i=0; i<word.length(); i++){
            while(j>0 && word.charAt(i) != word.charAt(j)){//맞는 위치가 나올 때까지 j - 1칸의 공통 부분 위치로 이동
                j = pi[j-1];
            }
            if(word.charAt(i) == word.charAt(j)){
                pi[i] = ++j;//i길이 문자열의 공통 길이는 j의 위치 + 1
            }
        }
    }

    public static void KMP(){
        int j = 0;
        for(int i=0; i<sentence.length(); i++){
            while(j>0 && sentence.charAt(i) != word.charAt(j)){//맞는 위치가 나올 때 까지 j - 1칸의 공통부분 위치로 이동
                j = pi[j-1]; // <-------- 무한루프에 빠짐
            }
            if(sentence.charAt(i) == word.charAt(j)){//맞는경우
                if(j == word.length() - 1){
                    result = 1;
                    break;
                }
                else ++j;//맞았지만 패턴이 끝나지 않았다면 j를 하나 증가
            }
        }
    }
}
/*
        ## KMP 알고리즘 - 시간복잡도 O(NM) 선형자료구조조

 */
