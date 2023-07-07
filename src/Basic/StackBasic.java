package Basic;

import java.util.Stack;

public class StackBasic {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(10);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
