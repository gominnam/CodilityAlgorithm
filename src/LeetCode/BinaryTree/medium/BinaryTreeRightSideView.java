package LeetCode.BinaryTree.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {

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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result,  0);
        return result;
    } //queue 이용 ?

    public void dfs(TreeNode node, List<Integer> result, int depth){
        if(node == null) return;

        if(depth == result.size()){
            result.add(node.val);
        }
        else {
            result.set(depth, node.val);
        }

        if(node.left != null) {
            dfs(node.left, result, depth+1);
        }
        if(node.right != null) {
            dfs(node.right, result, depth+1);
        }
    }

    public static void main(String[] args){
        BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightRight = new TreeNode(6);

        root.left = left;
        root.right = right;
        left.right = leftRight;
        left.left = leftLeft;
        right.right = rightRight;

        System.out.println(bt.rightSideView(root));
    }
}

/*

-ref: https://leetcode.com/problems/binary-tree-right-side-view/description/

 */
