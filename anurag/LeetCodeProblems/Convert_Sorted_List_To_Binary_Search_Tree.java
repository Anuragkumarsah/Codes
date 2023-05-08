package com.anurag.LeetCodeProblems;

import com.anurag.Binary_Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;


class ListNode {
    final int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
public class Convert_Sorted_List_To_Binary_Search_Tree {

    public List<Integer> linkedListToList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode iterator = head;
        while(iterator != null) {
            list.add(iterator.val);
            iterator = iterator.next;
        }
        return list;
    }

    public TreeNode listToTree(int start, int end, List<Integer> list) {
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = listToTree(start, mid - 1, list);
        root.right = listToTree(mid + 1, end, list);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = linkedListToList(head);
        return listToTree(0, list.size()-1, list);
    }

    public void printTree(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0, new ListNode(5, new ListNode(9)));
        Convert_Sorted_List_To_Binary_Search_Tree ob = new Convert_Sorted_List_To_Binary_Search_Tree();
        TreeNode root = ob.sortedListToBST(head);
        ob.printTree(root);
    }
}
