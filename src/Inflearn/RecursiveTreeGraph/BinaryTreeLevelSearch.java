package Inflearn.RecursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelSearch {
    Node root;
    public void BFS(Node root){
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;//LEVEL
        while(!Q.isEmpty()){
            int len = Q.size();
            System.out.print(L + " : ");
            for(int i=0; i<len; i++){
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if(cur.left != null) Q.offer(cur.left);
                if(cur.right != null) Q.offer(cur.right);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args){
        BinaryTreeLevelSearch tree = new BinaryTreeLevelSearch();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.BFS(tree.root);
    }
}
/* 최단거리 탐색 // Queue
       BFS

        1            1 LEVEL
       / \
      2   3          2 LEVEL
     / \ / \
    4  5 6  7        3 LEVEL
       ...            ...
 */
