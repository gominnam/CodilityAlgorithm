package Inflearn.RecursiveTreeGraph;

public class ShortEndNode {
    Node root;
    public int DFS(int L, Node root){
        if(root.left == null && root.right == null) return L;
        else return Math.min(DFS(L+1, root.left), DFS(L+1, root.right));
    }

    public static void main(String[] args){
        ShortEndNode tree = new ShortEndNode();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.DFS(0, tree.root));
    }
}
/*
가장 짧은 말단 노드 구하기 // 짧은 거리는 BFS가 맞다 위는 DFS로도 구현해 본 것

 */
