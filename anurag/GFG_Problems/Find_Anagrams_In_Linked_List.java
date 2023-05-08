package com.anurag.GFG_Problems;

import java.util.ArrayList;
class Node{
    char data;
    Node next;
    public Node(char data, Node next){
        this.data = data;
        this.next = next;
    }
}

public class Find_Anagrams_In_Linked_List {
    public static boolean checkAnagram(int[] s_letter_count, int[] current_word_letter_count) {
        for(int i=0;i<26;i++) {
            if(s_letter_count[i] != current_word_letter_count[i]) return false;
        }
        return true;
    }
    public static ArrayList<Node> findAnagrams(Node head, String s) {
        // code here
        int[] s_letter_count = new int[26];
        for(char ch : s.toCharArray()) {
            s_letter_count[ch-'a']++;
        }
//        Solution ob = new Solution();
        int length = s.length();
        Node current = head;
        ArrayList<Node> ans = new ArrayList<>();
        while(current != null) {
            int[] current_word_letter_count = new int[26];
            int cur_length = 0;
            Node cur_head = current, temp = current;
            while(current != null && cur_length != length) {
                int character = current.data - 'a';
                cur_length++;
                temp = current;
                current = current.next;
                current_word_letter_count[character]++;
            }
//            if(cur_length != length) continue;
            if(checkAnagram(s_letter_count, current_word_letter_count)) {
                temp.next = null;
                ans.add(cur_head);
            } else {
                current = cur_head.next;
            }


        }
        return ans;
    }

    public static void print(Node head) {
        Node temp = head;
        while(temp!=null) {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        String s ="u a w v l k w s g f v k w l f u a g g w f g l w h w s k u v s l w u a v w g f k a g w k i s l u w v w w g t f a k v l s l w u g v w f k a g";
        s = s.replaceAll("\\s", "");
        Node head = new Node(s.charAt(0), null), tail = head;
        for (int i = 1; i < s.length(); i++) {
            tail = tail.next = new Node(s.charAt(i), null);
        }
        String c = "gsvfwluwka";
//        print(head);
        ArrayList<Node> ans = findAnagrams(head, c);
        for(Node node : ans) {
            print(node);
            System.out.println();
        }
    }
}
