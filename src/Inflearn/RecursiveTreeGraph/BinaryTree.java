package Inflearn.RecursiveTreeGraph;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data = data;
        right = left =null;
    }
}

public class BinaryTree {
    Node root;
    public void DFS(Node root){
        if(root==null) return;
        else{
            //System.out.print(root.data + " "); 전위
            DFS(root.left);
            //System.out.print(root.data + " "); 중위
            DFS(root.right);
            System.out.print(root.data + " "); // 후위
        }
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.DFS(tree.root);
    }
}

/* 부모가 기준
        1
       / \
      2   3
     / \ / \
    4  5 6  7

전위순회 출력 : 1 2 4 5 3 6 7
중위순회 출력 : 4 2 5 1 6 3 7
후위순회 출력 : 4 5 2 6 7 3 1  <- 병합정렬

 */