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
        if(root != null){
            dfs(root, "", result);
        }
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node != null) {
            path += Integer.toString(node.val);
            if (node.left == null && node.right == null) { // if leaf node
                result.add(path);
            } else {
                path += "->";
                dfs(node.left, path, result);
                dfs(node.right, path, result);
            }
        }
    }

    public void dfs2(TreeNode node, List<String> result, int index){ // before refactoring
        StringBuilder sb = new StringBuilder(result.get(index));
        int length = sb.length();
        if(node.left != null && node.right != null){
            sb.append("->").append(node.left.val);
            result.set(index, sb.toString());
            dfs2(node.left, result, index);
            sb.setLength(length);

            sb.append("->").append(node.right.val);
            result.add(sb.toString());
            dfs2(node.right, result, result.size()-1);
        }
        else if(node.left != null){
            sb.append("->").append(node.left.val);
            result.set(index, sb.toString());
            dfs2(node.left, result, index);
        }
        else if(node.right != null){
            sb.append("->").append(node.right.val);
            result.set(index, sb.toString());
            dfs2(node.right, result, index);
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

dfs2 메서드가 refactoring 전의 코드이다.
dfs 메서드가 더 간결하고 가독성이 좋았지만 실행시간은 dfs2가 더 효율적이었다.

String 클래스의 경우 문자열을 변경할 때마다 새로운 객체를 생성하기 때문에 이런 현상이 발생.
 */