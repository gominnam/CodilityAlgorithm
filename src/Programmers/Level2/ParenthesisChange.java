package Programmers.Level2;

import java.util.*;

public class ParenthesisChange {
    public static String solution(String p){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(char c : p.toCharArray()){
            if(c == '(') stack.push('(');
            else if(stack.peek() == '('){
                stack.pop();
                answer += "()";
            }

        }

        return answer;
    }

    public static void main(String[] args){
        String question = "()))((()";
        String answer = solution(question);
        System.out.println(answer);
    }
}

/*
TEST CASE:
()))((()  =>	()(())()


LEVEL 2
코딩테스트 연습
2020 KAKAO BLIND RECRUITMENT
괄호 변환
 */


