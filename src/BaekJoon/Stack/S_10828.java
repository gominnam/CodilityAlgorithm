package BaekJoon.Stack;

import java.io.*;
import java.util.EmptyStackException;
import java.util.StringTokenizer;

public class S_10828 {
    public static class Stack<T> {
        private Node<T> top;
        private int size;
        private class Node<T>{
            private T data;
            private Node<T> next;
            public Node(T data){
                this.data = data;
            }
        }
        public boolean isEmpty(){
            return top == null;
        }
        public void push(T data){
            Node<T> newNode = new Node<>(data);
            if (top != null) {
                newNode.next = top;
            }
            top = newNode;
            size++;
        }
        public T pop(){
           if(isEmpty()) {
               throw new EmptyStackException();
           }
           T data = top.data;
           top = top.next;
           size--;
           return data;
        }
        public T peek(){
            if(isEmpty()){
                throw new EmptyStackException();
            }
            return top.data;
        }
        public int size(){
            return size;
        }
    }
    public static void main(String[] args) throws IOException {
        S_10828.Stack<Integer> stack = new S_10828.Stack<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            try{
                st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                if(str.equals("push")){
                    stack.push(Integer.valueOf(st.nextToken()));
                } else if(str.equals("pop")){
                    sb.append(stack.pop()).append('\n');
                } else if(str.equals("size")){
                    sb.append(stack.size()).append('\n');
                } else if(str.equals("empty")){
                    if(stack.isEmpty()){
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                } else if(str.equals("top")){
                    sb.append(stack.peek()).append('\n');
                }
            } catch (EmptyStackException e){
                sb.append(-1).append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}

/*
    ##, Basic Stack Implementation
todo: repeating Stack class Implementation


 */