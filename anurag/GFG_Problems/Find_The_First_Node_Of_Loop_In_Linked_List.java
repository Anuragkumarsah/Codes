package com.anurag.GFG_Problems;

//class Node{
//    int data;
//    Node next;
//    public Node(int data, Node next){
//        this.data = data;
//        this.next = next;
//    }
//}

public class Find_The_First_Node_Of_Loop_In_Linked_List {
    public static int findFirstNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast.next == null || fast.next.next == null) return -1;
        slow = head;
        while(slow != fast){
            fast = fast.next;
            slow = slow.next;
        }
        return slow.data;
    }
    public static void main(String[] args) {

    }
}
