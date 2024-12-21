package LeetCode.String.medium;

import java.util.Stack;

public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        String currentString = "";
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0'); // 숫자가 연속으로 나오는 경우
            } else if (ch == '[') {
                countStack.push(k);
                stringStack.push(currentString);
                k = 0;
                currentString = "";
            } else if (ch == ']') {
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                int currentK = countStack.pop();
                for (int i = 0; i < currentK; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString.toString();
            } else {
                currentString += ch;
            }
        }
        return currentString;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
//        System.out.println(ds.decodeString("3[a]2[bc]")); // "aaabcbc"
        System.out.println(ds.decodeString("3[a2[c]]")); // "accaccacc"
    }
}

/*

Thinking:
- digit: 0 ~ 9 까지의 숫자를 의미한다. (십의자리수를 고려하지 않아도 된다.)
- '('와 ')' 괄호 문제와 유사 stack으로 해결

-ref: https://leetcode.com/problems/decode-string/description/

 */