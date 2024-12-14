package LeetCode.BinaryTree.easy;

public class DiameterOfBinaryTree {

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

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        diameter = Math.max(diameter, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(dbt.diameterOfBinaryTree(root));
    }
}

/*

-Thinking
:public int diameterOfBinaryTree(TreeNode root) {
        if(root.left == null && root.right == null) return 1;
        else if(root.left == null) {
            return diameterOfBinaryTree(root.right);
        }
        else if(root.right == null) {
            return diameterOfBinaryTree(root.left);
        }
        return diameterOfBinaryTree(root.left) + diameterOfBinaryTree(root.right);
    }

위의 코드를 제출하여 실패
1) root가 둘다 null 인경우
2) 모든 경우의 left + right 길이를 합하여서 return 하므로 더 길게 return 될 거라 생각
3) children 지름이 더 큰 경우도 있음

-ref: https://leetcode.com/problems/diameter-of-binary-tree/

 */
