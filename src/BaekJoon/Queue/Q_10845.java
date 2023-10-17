package BaekJoon.Queue;

import java.io.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Q_10845 {
    public static class Queue<T>{
        Node<T> front;
        Node<T> back;
        int size;
        public class Node<T>{
            T data;
            Node<T> next;
            public Node(T data){
                this.data = data;
            }
        }
        public boolean isEmpty(){
            return front == null;
        }
        public void push(T data){
            Node<T> newNode = new Node<>(data);
            if(isEmpty()){
                front = newNode;
            } else {
                back.next = newNode;
            }
            back = newNode;
            size++;
        }
        public T pop(){
            if(front == null){
                throw new NoSuchElementException("Queue is Empty");
            }
            T data = front.data;
            front = front.next;
            if(front == null){
                back = null;
            }
            size--;
            return data;
        }
        public T front(){
            if(front == null){
                throw new NoSuchElementException("Queue is Empty");
            }
            return front.data;
        }
        public T back(){
            if(back == null){
                throw new NoSuchElementException("Queue is Empty");
            }
            return back.data;
        }
        public int size(){
            return size;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Q_10845.Queue<Integer> queue = new Q_10845.Queue<>();
        for(int i=0; i<n; i++){
            try{
                st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                if(str.equals("push")){
                    queue.push(Integer.valueOf(st.nextToken()));
                } else if(str.equals("pop")){
                    sb.append(queue.pop()).append("\n");
                } else if(str.equals("front")){
                    sb.append(queue.front()).append("\n");
                } else if(str.equals("back")){
                    sb.append(queue.back()).append("\n");
                } else if(str.equals("size")){
                    sb.append(queue.size()).append("\n");
                } else if(str.equals("empty")){
                    if(queue.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                }
            } catch(NoSuchElementException e) {
                sb.append("-1").append("\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
/*
    ##, Basic Queue Implementation
todo: repeating Queue class Implementation

 */