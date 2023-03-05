package com.anurag.Binary_Tree;

import com.sun.source.tree.Tree;

import java.util.Objects;

public class Serialize_And_Deserialize_Binary_Tree {
    int count = 0;
    public String serialize(TreeNode root) {
        if(root == null) {
            return "NULL/";
        }
        StringBuilder str = new StringBuilder();
        str.append(root.val).append("/");
        String left = serialize(root.left);
        String right = serialize(root.right);
        str.append(left).append("/").append(right).append("/");
        return str.toString();
    }

    public TreeNode deserialize(String data) {
        String[] arrOfStr = data.split("/");
        return deserialization(arrOfStr);
    }
    public TreeNode deserialization(String[] arr){
        if(Objects.equals(arr[count], "NULL")){
            count++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(arr[count]));
        count++;
        root.left = deserialization(arr);
        count++;
        root.right = deserialization(arr);
        count++;
        return root;
    }

    public static void main(String[] args) {

    }
}
