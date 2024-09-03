package LeetCode.BinaryTree.easy;

import java.util.*;

public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> a = getInorderArrayFromTree(p);
        List<Integer> b = getInorderArrayFromTree(q);

        if(a.size() != b. size()) return false;
        for(int i=0; i<a.size(); i++){
            if(!Objects.equals(a.get(i), b.get(i))) return false;
        }
        return true;
    }

//    public boolean isSameTreeAnotherSovling(TreeNode p, TreeNode q) {
//        if (p == null && q == null) {
//            return true;
//        }
//        if (p == null || q == null) {
//            return false;
//        }
//        if (p.val != q.val) {
//            return false;
//        }
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }

    public List<Integer> getInorderArrayFromTree(TreeNode p){
        List<Integer> result = new ArrayList<>();
        helpInorderArray(p, result);
        return result;
    }

    public void helpInorderArray(TreeNode p, List<Integer> result){
        if(p == null){
            return;
        }
        result.add(p.val);
        helpInorderArray(p.left, result);
        if(p.left == null && p.right != null){
            result.add(null);
        }
        helpInorderArray(p.right, result);
    }

    public static void main(String[] args){
        SameTree st = new SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        System.out.println(st.isSameTree(p, q));
    }

}

/*

Thinking:
1) Recursive를 더 깔끔하게
주석처리한 메서드 isSameTreeAnotherSovling 를 보면 더 깔끔하게 풀 수 있다.



-ref: https://leetcode.com/problems/same-tree/description/

 */
