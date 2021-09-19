package BaekJoon.Stack;

import java.io.*;
import java.util.*;

public class S_9012 {

    public static String solution(String s){
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c == '(') stack.push('(');
            else{
                if(stack.size() == 0) return "NO";
                char t = stack.peek();
                if(t != '(') return "NO";
                stack.pop();
            }
        }
        if(stack.size() != 0) return "NO";
        return "YES";
    }

    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(br.readLine());

//        int n;
//        Scanner sc = new Scanner(System.in);
//        n = sc.nextInt();
        for(int i=0; i<cases; i++){
            String str = br.readLine();
            System.out.println(solution(str));
        }
    }
}
