package LeetCode.stack.medium;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {
        Stack<String> stack = new Stack<>();
        int leftParenthesisCount = 0;
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '('){
                stack.push(sb.toString());
                sb.setLength(0);
                stack.push("(");
                leftParenthesisCount++;
            }
            else if(c == ')' && leftParenthesisCount > 0){
                StringBuilder cur = new StringBuilder(sb.toString()).append(")");
                sb.setLength(0);
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    cur.insert(0, stack.pop());
                }
                cur.insert(0, stack.pop());
                leftParenthesisCount--;
                stack.push(cur.toString());
            }
            else {
                if(c == ')') continue;
                sb.append(c);
            }
        }

        while(!stack.isEmpty()){
            if(stack.peek().equals("(") || stack.peek().equals(")")) {
                stack.pop();
                continue;
            }
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }

    public String minRemoveToMakeValid2(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;

        // 첫 번째 패스: 오른쪽 괄호가 왼쪽 괄호보다 많아지면 무시
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open == 0) continue;
                open--;
            }
            sb.append(c);
        }

        // 두 번째 패스: 왼쪽 괄호가 오른쪽 괄호보다 많아지면 무시
        StringBuilder result = new StringBuilder();
        open = 0;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (c == '(') {
                if (open == 0) continue;
                open--;
            } else if (c == ')') {
                open++;
            }
            result.append(c);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        MinimumRemoveToMakeValidParentheses mrtmvp = new MinimumRemoveToMakeValidParentheses();
        String s = "lee(t(c)o)de)";
        System.out.println(mrtmvp.minRemoveToMakeValid2(s));
    }
}

/*

Thinking:

- Stack 을 사용하여 괄호의 짝을 맞추는 문제로 해결
    - minRemoveToMakeValid
- 개선된 방법으로는 두 번의 패스를 통해 문자열을 처리하여 유효한 괄호만 남기는 방식입니다.
    - minRemoveToMakeValid2
    - 2번의 for 문으로 필터링
        - 1번째 for문 : 왼쪽 괄호가 오른쪽 괄호보다 많아지면 무시
        - 2번째 for문 : 오른쪽 괄호가 왼쪽 괄호보다 많아지면 무시

-ref: https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses

 */