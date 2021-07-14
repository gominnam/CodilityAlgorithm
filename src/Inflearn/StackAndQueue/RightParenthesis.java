package Inflearn.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class RightParenthesis {
    public String Solve(String s){
        String answer = "NO";
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()) stack.push(c);
            else if(stack.peek() == '(' && c == ')'){
                stack.pop();
            }
            else stack.push(c);
        }

        if(stack.size() != 0) return answer;
        else return "YES";
    }

    public static void main(String[] args){
        RightParenthesis T = new RightParenthesis();

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(T.Solve(s));
    }
}

/*
설명

괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력합니다.

(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.


입력
첫 번째 줄에 괄호 문자열이 입력됩니다. 문자열의 최대 길이는 30이다.


출력
첫 번째 줄에 YES, NO를 출력한다.

TEST CASE:
(()(()))(()

==> NO
 */