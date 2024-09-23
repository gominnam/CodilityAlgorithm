package LeetCode.BinaryTree.easy;

import java.util.*;

public class MaximumDepthOfBinaryTree {
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

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode tn = queue.poll();
                if(tn.left != null) queue.add(tn.left);
                if(tn.right != null) queue.add(tn.right);
            }
        }
        return depth;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args){
        MaximumDepthOfBinaryTree mdobt = new MaximumDepthOfBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        System.out.println(mdobt.maxDepth(root));
    }
}

/*

Thinking:
1) Recursive

- 재귀 함수를 통해 간결하고 효율적으로 소스코드 수정 (maxDepth -> maxDepth2)

 */