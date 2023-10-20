package BaekJoon.Tree;

import java.io.*;

public class T_5639 {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
    }

    public static class BinaryTree{
        Node root;
        public void insert(int data){
            root = insertRec(root, data);
        }
        public Node insertRec(Node root, int data){
            if(root == null){
                root = new Node(data);
                return root;
            }
            if(data < root.data) {
                root.left = insertRec(root.left, data);
            } else if(data > root.data) {
                root.right = insertRec(root.right, data);
            }
            return root;
        }
    }

    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.println(root.data);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinaryTree binaryTree = new BinaryTree();
        String input;
        while(true){
            input = br.readLine();
            if(input == null || input.equals("")) break;
            int data = Integer.parseInt(input);
            if(binaryTree.root == null){
                binaryTree.root = new Node(data);
            } else {
                binaryTree.insert(data);
            }
        }
        postorder(binaryTree.root);
    }
}
