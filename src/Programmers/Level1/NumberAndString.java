package Programmers.Level1;

import java.util.*;

public class NumberAndString {
    static String[] numbering = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    public int solution(String s) {
        int answer = 0;
        for(int i=0; i<10; i++){
            if(s.contains(numbering[i])){
                s = s.replace(numbering[i], String.valueOf(i));
            }
        }
        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args){
        NumberAndString T = new NumberAndString();
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(T.solution(s));
    }
}

/* 숫자 문자열과 영단어 - 2021 채용연계 카카오 인턴쉽

TEST CASE:
"one4seveneight"    ==>	    1478
"23four5six7"       ==> 	234567
"2three45sixseven"	==>     234567
"123"	            ==>     123

 */