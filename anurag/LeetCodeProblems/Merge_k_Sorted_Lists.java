package com.anurag.LeetCodeProblems;

public class Merge_k_Sorted_Lists {
    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null, tail = null;
        while(true) {
            boolean all_null = true;
            for(ListNode node : lists) {
                if(node != null) {
                    all_null = false;
                    break;
                }
            }
            if(all_null) break;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] == null) {
                    continue;
                }
                if(head == null) {
                    tail = lists[i];
                    lists[i] = tail.next;
                    tail.next = null;
                    head = tail;
                } else if(tail.val <= lists[i].val){
                    tail.next = lists[i];
                    lists[i] = tail.next;
                    tail = tail.next;
                }
            }
        }
        return head;
    }
    public static void main(String[] args) {
        ListNode one = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode two = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode three = new ListNode(2, new ListNode(6));
        ListNode[] lists = {one, two, three};
        ListNode temp = mergeKLists(lists);
        while(temp != null) {
            System.out.println(temp.val + "->");
            temp = temp.next;
        }
    }
}
