package Inflearn.String;

import java.util.Scanner;

public class LowerUpperReverse {
    public String solution(String message) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isUpperCase(c)) {
                answer.append(Character.toLowerCase(c));
            } else {
                answer.append(Character.toUpperCase(c));
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        LowerUpperReverse lwr = new LowerUpperReverse();

        Scanner sc = new Scanner(System.in);
        String message = sc.next();

        System.out.println(lwr.solution(message));
    }
}