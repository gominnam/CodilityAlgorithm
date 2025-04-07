package LeetCode.BinaryTree.medium;

public class SumRootToLeafNumbers {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
        TreeNode(int x, TreeNode left, TreeNode right) { val = x; this.left = left; this.right = right; }
    }

    public int sumNumbers(TreeNode root) {
        return calculator(root, 0);
    }

    public int calculator(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum*10 + node.val;

        if(node.left == null && node.right == null) {
            return sum;
        }

        return calculator(node.left, sum) + calculator(node.right, sum);
    }

    public static void main(String[] args) {
        // Example usage
        SumRootToLeafNumbers stln = new SumRootToLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = stln.sumNumbers(root);
        System.out.println("Sum of all root-to-leaf numbers: " + result); // Output: 262
    }
}
