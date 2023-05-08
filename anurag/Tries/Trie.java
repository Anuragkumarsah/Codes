package com.anurag.Tries;


class Node {
    Node[] links;
    boolean flag;
    Node() {
        this.links = new Node[26];
    }

    Node get (char key) {
        return links[key - 'a'];
    }

    boolean containsKey(char key) {
        return (links[key - 'a'] != null);
    }

    void putChar(char key) {
        links[key - 'a'] = new Node();
    }

    void setEnd() {
        this.flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

public class Trie {
    private final Node root;
    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for(char key : word.toCharArray()){
            if(!temp.containsKey(key))
                temp.putChar(key);
            temp = temp.get(key);
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        Node temp = root;
        for(int i=0;i<word.length();i++) {
            if(temp == null) return false;
            char key = word.charAt(i);
            Node val = temp.get(key);
            if(val == null &&  i != word.length()-1) return false;
            temp = val;
        }
        return temp != null && temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for(int i=0;i<prefix.length();i++) {
            if(temp == null) return false;
            char key = prefix.charAt(i);
            Node val = temp.get(key);
            if(val == null &&  i != prefix.length()-1) return false;
            temp = val;
        }
        return temp != null;
    }

    public static void main(String[] args) {
        Trie ob = new Trie();
        ob.insert("apple");
        ob.insert("app");
        System.out.println(ob.search("apple"));
        System.out.println(ob.startsWith("apple"));
    }
}
