package LeetCode.BinaryTree.hard;

public class SerializeAndDeserializeBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public void serializeHelper(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
        }
        else{
            sb.append(root.val).append(",");
            serializeHelper(root.left, sb);
            serializeHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(data.split(","), new int[]{0});
    }

    public TreeNode deserializeHelper(String[] data, int[] index){ // 참조형으로 해서 index 공유
        if(data[index[0]].equals("null")){
            index[0]++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index[0]++]));
        root.left = deserializeHelper(data, index);
        root.right = deserializeHelper(data, index);
        return root;
    }

    public static void main(String[] args){
        SerializeAndDeserializeBinaryTree serdes = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = null;
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(serdes.serialize(root));
        TreeNode ans = serdes.deserialize(serdes.serialize(root));
        System.out.println(ans.val);
    }
}

/*

Thinking:

1. Reference 타입

-ref: https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

 */
