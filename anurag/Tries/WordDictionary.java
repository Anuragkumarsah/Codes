package com.anurag.Tries;

public class WordDictionary {
    private final Node root;
    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for(char key : word.toCharArray()) {
            if(!temp.containsKey(key)){
                temp.putChar(key);
            }
            temp = temp.get(key);
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        return search(word.toCharArray(), root, 0);
    }

    public boolean search(char[] word, Node root, int ind) {
        if(root == null) return false;
        if(ind == word.length) return root.isEnd();

        char start = word[ind] == '.' ? 'a' : word[ind];
        char end = word[ind] == '.' ? 'z' : word[ind];

        for(char key = start; key <= end; key++) {
            if(search(word, root.get(key), ind + 1)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        WordDictionary ob = new WordDictionary();
        ob.addWord("bad");
        ob.addWord("dad");
        ob.addWord("mad");
        System.out.println(ob.search("pad"));
        System.out.println(ob.search("bad"));
        System.out.println(ob.search(".ad"));
        System.out.println(ob.search("b.."));
    }
}
