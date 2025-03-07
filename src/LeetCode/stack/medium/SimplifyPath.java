package LeetCode.stack.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(String current : paths){
            stack.push(current);
        }

        StringBuilder sb = new StringBuilder();
        int up = 0;
        while(!stack.isEmpty()){
            String curPath = stack.pop();
            if(curPath.equals("") || curPath.equals(".")) continue;
            else if(curPath.equals("..")) {
                up++;
                continue;
            }
            else if(up > 0) {
                up--;
                continue;
            }
            sb.insert(0, "/").insert(1, curPath);
        }
        if(sb.isEmpty()) return "/";
        return sb.toString();
    }

    public String simplifyPath_Deque(String path){
        Deque<String> stack = new ArrayDeque<>();
        String[] paths = path.split("/");

        for (String current : paths) {
            if (current.isEmpty() || current.equals(".")) {
                continue;
            }
            if (current.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(current);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, '/').insert(1, stack.pop());
        }

        return !sb.isEmpty() ? sb.toString() : "/";
    }

    public static void main(String[] args) {
        SimplifyPath o = new SimplifyPath();
        System.out.println(o.simplifyPath("/home/"));//"/home"
        System.out.println(o.simplifyPath("/../"));//"/"
        System.out.println(o.simplifyPath("/home//foo/"));//"/home/foo"
        System.out.println(o.simplifyPath("/a/./b/../../c/"));//"/c"
        System.out.println(o.simplifyPath_Deque("/a/../../b/../c//.//"));//"/c"
    }
}

/*

Thinking:
- Stack 자료구조를 이용하여 뒤에서부터 경로 탐색, 추가하는 방식으로 해결
- simplifyPath_Deque 메서드에서 자료구조 Deque 를 사용하면 더 간결하게 구현 가능

-ref: https://leetcode.com/problems/simplify-path

 */
