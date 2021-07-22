package Inflearn.RecursiveTreeGraph;

import java.util.*;

public class ShortEndNodeBFS {
    Node root;
    public int BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L=0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                if(cur.left == null && cur.right == null) return L;
                if(cur.left != null) Q.offer(cur.left);
                if(cur.right != null) Q.offer(cur.right);
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        ShortEndNodeBFS tree = new ShortEndNodeBFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
