package BaekJoon.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = 0;
        int left = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '(' && str.charAt(i+1) == ')'){
                i++;
                answer += left;
            }
            else if(str.charAt(i) == '('){
                left++;
                answer++;
            }
            else if(str.charAt(i) == ')'){
                left--;
            }
        }
        System.out.println(answer);
    }
}
