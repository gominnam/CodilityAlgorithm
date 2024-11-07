package LeetCode.BinaryTree.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public class TreeNode {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        result.add(String.valueOf(root.val));
        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode node, List<String> result, int index){
        StringBuilder sb = new StringBuilder(result.get(index));
        int length = sb.length();
        if(node.left != null && node.right != null){
            sb.append("->").append(node.left.val);
            result.set(index, sb.toString());
            dfs(node.left, result, index);
            sb.setLength(length);

            sb.append("->").append(node.right.val);
            result.add(sb.toString());
            dfs(node.right, result, result.size()-1);
        }
        else if(node.left != null){
            sb.append("->").append(node.left.val);
            result.set(index, sb.toString());
            dfs(node.left, result, index);
        }
        else if(node.right != null){
            sb.append("->").append(node.right.val);
            result.set(index, sb.toString());
            dfs(node.right, result, index);
        }
    }

    public static void main(String[] args){
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = btp.new TreeNode(1);
        root.left = btp.new TreeNode(2);
        root.right = btp.new TreeNode(3);
        root.left.right = btp.new TreeNode(5);
        for(String str : btp.binaryTreePaths(root)){
            System.out.println(str);
        }
    }
}

/*

-ref: https://leetcode.com/problems/binary-tree-paths/description/

 */