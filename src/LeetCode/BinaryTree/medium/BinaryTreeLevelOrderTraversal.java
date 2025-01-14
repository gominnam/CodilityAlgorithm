package LeetCode.BinaryTree.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<size; i++){
                TreeNode curNode = queue.poll();
                if(curNode == null) continue;
                subList.add(curNode.val);
                queue.offer(curNode.left);
                queue.offer(curNode.right);
            }
            if(!subList.isEmpty()) {
                result.add(subList);
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder_recursive(TreeNode root)
    {
        List<List<Integer>>al=new ArrayList<>();
        pre(root,0,al);
        return al;
    }

    public static void pre(TreeNode root,int l,List<List<Integer>>al) // l: depth
    {
        if(root==null)
            return;
        if(al.size()==l)
        {
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            al.add(li);
        }
        else
            al.get(l).add(root.val);
        pre(root.left,l+1,al);
        pre(root.right,l+1,al);
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        System.out.println(b.levelOrder(root));
        System.out.println(b.levelOrder_recursive(root));
    }
}

/*

Thikning:
- Queue를 통해서 depth 별로 순회하면서 값을 저장하는 방법으로 해결
- Recursive 방법으로도 해결 가능

-ref: https://leetcode.com/problems/binary-tree-level-order-traversal/

 */