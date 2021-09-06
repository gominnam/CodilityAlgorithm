package Inflearn.String;

import java.util.*;

public class PalindromeSentence {
    public boolean solution(String str){
        str = str.toLowerCase();
        String str2 = new StringBuilder(str).reverse().toString();

        if(str.equals(str2)) return true;
        else return false;
    }

    public static void main(String[] args){
        PalindromeSentence T = new PalindromeSentence();

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        if(T.solution(str)) System.out.println("YES");
        else System.out.println("NO");
    }
}
/*
설명

앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.

문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.

단 회문을 검사할 때 대소문자를 구분하지 않습니다.


입력
첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.


출력
첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.

TEST CASE:
gooG

==> YES
 */
