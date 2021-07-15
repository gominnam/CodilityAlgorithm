package Inflearn.StackAndQueue;

import java.util.*;

public class PostfixCalculation {
    public int Solve(String str){
        Stack<Integer> stack = new Stack<>();

        for(char x : str.toCharArray()){
            if(x == '+') stack.push(stack.pop() + stack.pop());
            else if(x == '-') {
                int first = stack.pop();
                int last = stack.pop();
                stack.push(last - first);
            }
            else if(x == '*') stack.push(stack.pop() * stack.pop());
            else if(x == '/') {
                int first = stack.pop();
                int last = stack.pop();
                stack.push(last / first);
            }
            else stack.push(x - '0');
        }

        return stack.pop();
    }

    public static void main(String[] args){
        PostfixCalculation T = new PostfixCalculation();

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(T.Solve(s));
    }
}

/*
설명

후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.

만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.


입력
첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.

식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.


출력
연산한 결과를 출력합니다.

TEST CASE:
352+*9-

==> 12
 */