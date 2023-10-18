package BaekJoon.LinkedList;

import java.io.*;
import java.util.Stack;

public class L_1406 {
    public class DoubleLinkedList<T>{
        Node<T> head;
        Node<T> tail;
        int size;
        public class Node<T>{
            T data;
            Node<T> prev;
            Node<T> next;
            public Node(T data){
                this.data = data;
                this.prev = null;
                this.next = null;
            }
        }
        public boolean isEmpty(){
            return size == 0;
        }
        public int size(){
            return size;
        }
        public void addFirst(T data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
        }
        public void addLast(T data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
            }
            tail = newNode;
            size++;
        }
        public void addAt(int index, T data){
            if(index < 0 || index > size){
                throw new IndexOutOfBoundsException("Index out of bounds");
            }

            if(index == 0){
                addFirst(data);
            } else if(index == size) {
                addLast(data);
            } else {
                Node newNode = new Node(data);
                Node current = head;
                for(int i=0; i<index; i++){
                    current = current.next;
                }
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
                size++;
            }
        }
        public T removeFirst(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            T data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            } else {
                head.prev = null;
            }
            size--;
            return data;
        }
        public T removeLast(){
            if(isEmpty()){
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            T data = tail.data;
            tail = tail.prev;
            if(tail == null){
                head = null;
            } else {
                tail.next = null;
            }
            size--;
            return data;
        }
        public T removeAt(int index){
            if(index < 0 || index >= size){
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            if(index == 0){
                return removeFirst();
            } else if(index == size-1){
                return removeLast();
            } else {
                Node current = head;
                for(int i=0; i<index; i++){
                    current = current.next;
                }
                T data = (T)current.data;
                current.prev.next = current.next;
                current.next.prev = current.prev;
                size--;
                return data;
            }
        }
    }
// time limit exceeded error
//    public static void main(String[] args) throws IOException{
//        StringBuilder sb = new StringBuilder();
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        DoubleLinkedList<Character> list = new L_1406().new DoubleLinkedList<>();
//        int cursor = 0;
//        String str = br.readLine();
//        int n = Integer.parseInt(br.readLine());
//        for(Character c : str.toCharArray()){
//            list.addLast(c);
//            cursor++;
//        }
//        for(int i=0; i<n; i++){
//            String[] command = br.readLine().split(" ");
//            if(command[0].equals("L")){
//                if(cursor != 0){
//                    cursor--;
//                }
//            } else if(command[0].equals("D")){
//                if(cursor != list.size()){
//                    cursor++;
//                }
//            } else if(command[0].equals("B")){
//                if(cursor != 0){
//                    list.removeAt(cursor-1);
//                    cursor--;
//                }
//            } else if(command[0].equals("P")){
//                list.addAt(cursor, command[1].charAt(0));
//                cursor++;
//            }
//        }
//        while(!list.isEmpty()){
//            sb.append(list.removeFirst());
//        }
//        bw.write(sb.toString());
//        bw.flush();
//    }

//    1번 개선 소스
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }

        while (n-- > 0) {
            String[] command = br.readLine().split(" ");
            char cmd = command[0].charAt(0);

            if (cmd == 'L' && !leftStack.isEmpty()) {
                rightStack.push(leftStack.pop());
            } else if (cmd == 'D' && !rightStack.isEmpty()) {
                leftStack.push(rightStack.pop());
            } else if (cmd == 'B' && !leftStack.isEmpty()) {
                leftStack.pop();
            } else if (cmd == 'P') {
                char character = command[1].charAt(0);
                leftStack.push(character);
            }
        }

        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            bw.write(rightStack.pop());
        }

        bw.flush();
        bw.close();
    }


// time limit exceeded error
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        String str = br.readLine();
//        LinkedList<Character> list = new LinkedList<>();
//        for(Character c : str.toCharArray()){
//            list.add(c);
//        }
//        int n = Integer.parseInt(br.readLine());
//        int cursor = list.size();
//        for(int i=0; i<n; i++){
//            String[] command = br.readLine().split(" ");
//            if(command[0].equals("L")){
//                if(cursor != 0){
//                    cursor--;
//                }
//            } else if(command[0].equals("D")){
//                if(cursor != list.size()){
//                    cursor++;
//                }
//            } else if(command[0].equals("B")){
//                if(cursor != 0){
//                    list.remove(cursor-1);
//                    cursor--;
//                }
//            } else if(command[0].equals("P")){
//                list.add(cursor, command[1].charAt(0));
//                cursor++;
//            }
//        }
//        for(Character c : list){
//            bw.write(c);
//        }
//        bw.flush();
//        bw.close();
//    }
}
/*
        ##, Double Linked List Implementation

구현한 소스로 제출하니 시간초과가 났음.
java.util에 있는 LinkedList를 사용하면 시간초과 해결이 될까 싶어 해봤지만 역시나 시간초과

개선방안
leftStack, rightStack을 사용하여 O(1) 시간 복잡도로 해결 가능


 */
