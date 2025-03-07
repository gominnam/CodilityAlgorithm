package LeetCode.stack.medium;

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

    public static void main(String[] args) {
        SimplifyPath o = new SimplifyPath();
        System.out.println(o.simplifyPath("/home/"));//"/home"
        System.out.println(o.simplifyPath("/../"));//"/"
        System.out.println(o.simplifyPath("/home//foo/"));//"/home/foo"
        System.out.println(o.simplifyPath("/a/./b/../../c/"));//"/c"
    }
}

/*

Thinking:
- Stack 자료구조를 이용하여 뒤에서부터 경로 탐색, 추가
- 보다 나은 자료구조 Deque를 사용하면 더 좋을 듯

-ref: https://leetcode.com/problems/simplify-path

 */
