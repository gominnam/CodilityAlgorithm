package LeetCode.BinaryTree.medium;

import java.util.*;

public class UniqueBinarySearchTrees2 {

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

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // i는 현재 루트
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees2 ubst = new UniqueBinarySearchTrees2();
        List<TreeNode> result = ubst.generateTrees(3);
        for (TreeNode tree : result) {
            System.out.println(treeToString(tree));
        }
    }

    private static String treeToString(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + treeToString(root.left) + "," + treeToString(root.right);
    }
}

/*

Thinking:
1) Recursive, Dynamic Programming

2) BST (Binary Search Tree)
- 왼쪽 서브트리의 모든 노드는 현재 노드보다 작은 값
- 오른쪽 서브트리의 모든 노드는 현재 노드보다 큰 값


Answer:
[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]

-ref: https://leetcode.com/problems/unique-binary-search-trees-ii/description/

 */