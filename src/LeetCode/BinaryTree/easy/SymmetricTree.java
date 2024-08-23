package LeetCode.BinaryTree.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SymmetricTree {

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

    public boolean isSymmetric(TreeNode root) {
        List<Integer> leftResult = new ArrayList<>();
        List<Integer> rightResult = new ArrayList<>();
        leftTree(root.left, leftResult);
        rightTree(root.right, rightResult);
        return isSame(leftResult, rightResult);
    }


    public void leftTree(TreeNode tree, List<Integer> result){
        if(tree == null){
            result.add(null);
            return;
        }
        result.add(tree.val);
        leftTree(tree.left, result);
        leftTree(tree.right, result);
    }

    public void rightTree(TreeNode tree, List<Integer> result){
        if(tree == null){
            result.add(null);
            return;
        }
        result.add(tree.val);
        rightTree(tree.right, result);
        rightTree(tree.left, result);
    }

    public boolean isSame(List<Integer> left, List<Integer> right){
        if(left.size() != right.size()) return false;
        for(int i=0; i<left.size(); i++){
            if(!Objects.equals(left.get(i), right.get(i))) return false;
        }
        return true;
    }

    public static void main(String[] args){
        SymmetricTree st = new SymmetricTree();
        TreeNode root = st.new TreeNode(1);
        root.left = st.new TreeNode(2);
        root.right = st.new TreeNode(2);
        root.left.left = st.new TreeNode(3);
        root.left.right = st.new TreeNode(4);
        root.right.left = st.new TreeNode(4);
        root.right.right = st.new TreeNode(3);
        System.out.println(st.isSymmetric(root));
    }
}

/*

1)
Thinking:
1)
- Symmetric Tree 란 Root-Tree 기준으로 left-Tree 와 right-Tree 가 대칭인 Tree
- 그러므로 왼쪽 트리는 left 부터 오른쪽 트리는 right 부터 탐색하면서 값을 비교하여 해결

2) 우아한 해답지 소스코드
    ex) 1
        / \
       2   2
      / \ / \
     3  4 4  3

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    // Recursive
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

3) Objects.equals() 메소드

- Objects.equals 메서드는 두 객체를 비교하여 동등성을 검사하는 유틸리티 메서드
  이 메서드는 null 안전성을 제공하며
  두 객체가 모두 null인 경우 true를 반환
  하나만 null인 경우 false를 반환합니다.

-ref: https://leetcode.com/problems/symmetric-tree/

 */