package BaekJoon.Tree;

import java.io.*;

public class T_1991 {
    public static Node root;

    public static class Node{
        char data;
        Node left;
        Node right;
        public Node(char data){
            this.data = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            char data = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);
            if(i == 0){
                root = new Node(data);
                if(left != '.') root.left = new Node(left);
                if(right != '.') root.right = new Node(right);
            } else {
                insert(root, data, left, right);
            }
        }
        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }

    public static void insert(Node root, char data, char left, char right){
        if(root == null) return;
        if(root.data == data){
            if(left != '.') root.left = new Node(left);
            if(right != '.') root.right = new Node(right);
        } else {
            insert(root.left, data, left, right);
            insert(root.right, data, left, right);
        }
    }

    public static void preorder(Node root){
        if(root == null) return;
        System.out.print(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }

    public static void postorder(Node root){
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data);
    }
}

/*


TESTCASE:
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .

==>
전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)

 */