package Inflearn.String;

import java.util.*;

public class ShortestWordDistance {//todo: repeat
    public void solution(String str, char c){
        int[] arr = new int[str.length()];
        int p = 10000000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                p=0;
                arr[i] = p++;
            }
            else{
                arr[i] = p++;
            }
        }

        p = 10000000;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c) {
                p = 0;
                p++;
            }
            else{
                arr[i] = Math.min(arr[i], p++);
            }
        }

        for(int i=0; i<str.length();i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        ShortestWordDistance T = new ShortestWordDistance();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c =sc.next().charAt(0);

        T.solution(str, c);
    }
}
/*
feedback - 왼쪽에서 n번 오른쪽에서 n번 for문 돌려서 거리 min 값으로 설정한다.
설명

한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.


입력
첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.

문자열의 길이는 100을 넘지 않는다.


출력
첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.

TEST CASE:
teachermode e

==> 1 0 1 2 1 0 1 2 2 1 0
 */