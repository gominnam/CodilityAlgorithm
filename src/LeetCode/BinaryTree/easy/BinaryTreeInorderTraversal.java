package LeetCode.BinaryTree.easy;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    public static void main(String[] args){
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(btit.inorderTraversal(root));
    }
}

/*

Thinking:
1) Binary Tree Inorder Traversal
- Tree 문제는 보통 recursive하게 풀 수 있다.
- Inorder Traversal은 왼쪽 자식 -> 루트 -> 오른쪽 자식 순서로 탐색한다.

-ref: https://leetcode.com/problems/binary-tree-inorder-traversal/
 */