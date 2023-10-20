package BaekJoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class T_Template {

    public static class Node<T>{
        T data;
        Node<T> left;
        Node<T> right;
        public Node(T data){
            this.data = data;
        }
    }

    public static class BinaryTree<T extends Comparable<T>>{
        Node<T> root;
        public BinaryTree(){
            root = null;
        }
        private void insert(T data){
            root = insertRec(root, data);
        }
        public Node<T> insertRec(Node<T> root, T data){
            if(root == null){
                root = new Node(data);
                return root;
            }

            if(data.compareTo(root.data) < 0){
                root.left = insertRec(root.left, data);
            } else if(data.compareTo(root.data) > 0){
                root.right = insertRec(root.right, data);
            }

            return root;
        }
        public Node<T> search(T data){
            return searchRec(root, data);
        }
        public Node<T> searchRec(Node<T> root, T data){
            if(root == null || root.data.equals(data)){
                return root;
            }

            if(data.compareTo(root.data) < 0){
                return searchRec(root.left, data);
            }

            return searchRec(root.right, data);
        }
    }

    public static void main(String[] args){
        BinaryTree<Integer> intTree = new BinaryTree<>();
        intTree.insert(50);
        intTree.insert(30);
        intTree.insert(70);
        intTree.insert(20);
        intTree.insert(40);

        Node<Integer> foundNode = intTree.search(40);
        if (foundNode != null) {
            System.out.println("노드를 찾았습니다: " + foundNode.data);
        } else {
            System.out.println("노드를 찾지 못했습니다.");
        }

        BinaryTree<String> stringTree = new BinaryTree<>();
        stringTree.insert("apple");
        stringTree.insert("banana");
        stringTree.insert("cherry");

        Node<String> foundStringNode = stringTree.search("banana");
        if (foundStringNode != null) {
            System.out.println("노드를 찾았습니다: " + foundStringNode.data);
        } else {
            System.out.println("노드를 찾지 못했습니다.");
        }
    }
}

/*

java 문법

extends Comparable<T>
을 상속받으면 내장함수
a.compareTo(b)를 사용하여 a와 b의 대소구분을 할 수 있다.

a가 b보다 작으면 음수를 반환
a와 b가 같으면 0을 반환
a가 b보다 크면 양수를 반환

 */