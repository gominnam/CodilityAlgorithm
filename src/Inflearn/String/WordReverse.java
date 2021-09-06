package Inflearn.String;

import java.util.*;

public class WordReverse {
    public void solution(String[] str){
        for(String s : str){
            String tmp = new StringBuilder(s).reverse().toString();
            System.out.println(tmp);
        }
    }

    public static void main(String[] args){
        WordReverse T = new WordReverse();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i=0; i<n; i++){
            str[i] = sc.next();
        }

        T.solution(str);
    }
}
/*
설명

N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.


입력
첫 줄에 자연수 N(3<=N<=20)이 주어집니다.

두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.


출력
N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.

TEST CASE:
3
good
Time
Big

==>
doog
emiT
giB
 */
