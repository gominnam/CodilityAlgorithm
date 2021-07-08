package Programmers.Level2;

import java.util.Scanner;
import java.util.Stack;

public class NextNumber {
    public String solution(String number, int k) {
        String answer = "";
        char[] n = number.toCharArray();
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n[0] - '0');


        for(int i=1; i<number.length(); i++){
            if(cnt == k) {
                stack.push(n[i] - '0');
                continue;
            }

            while(!stack.isEmpty() && stack.peek() < (n[i] - '0')) {
                stack.pop();
                cnt++;

                if(cnt == k) break;
            }

            stack.push(n[i] - '0');
        }
        while(stack.size() > number.length()-k){
            stack.pop();
        }

        for(Integer s : stack){
            answer += s;
        }

        return answer;
    }

    public static void main(String[] args){
        NextNumber T = new NextNumber();
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        int k = sc.nextInt();

        System.out.println(T.solution(number, k));
    }
}

/*
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

제한 사항
n은 1,000,000 이하의 자연수 입니다.

------------------------------------------------------------------------------------
다른 분 참고 소스
import java.util.Stack;
class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
 */