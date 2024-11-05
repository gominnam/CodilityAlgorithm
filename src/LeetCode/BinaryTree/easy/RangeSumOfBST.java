package LeetCode.BinaryTree.easy;

public class RangeSumOfBST {

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

    public int rangeSumBST(TreeNode root, int low, int high) {
       if(root == null) {
           return 0;
       }
       return (isInRange(root.val, low, high) ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public boolean isInRange(int val, int low, int high) {
       return val >= low && val <= high;
    }

    public static void main(String[] args){
        RangeSumOfBST rsob = new RangeSumOfBST();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.print(rsob.rangeSumBST(root, 7, 15));
    }
}

/*

- ref: https://leetcode.com/problems/range-sum-of-bst/submissions/1443850291/

 */