package com.anurag.GFG_Problems;

public class Reverse_both_parts {
    public static Node reverse(Node head, int k) {
        if(head.next == null) return head;

        Node cur = head, prev = null, next = head.next;

        while(k > 0 && next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
            k--;
        }

        if(next == null) return prev;
        Node sec_cur = null, sec_prev = null, sec_next = cur;
        while(sec_next != null) {
            sec_cur = sec_next;
            sec_next = sec_next.next;
            sec_cur.next = sec_prev;
            sec_prev = sec_cur;
        }

        head.next = sec_prev;
        return prev;
    }
    public static void main(String[] args) {

    }
}
