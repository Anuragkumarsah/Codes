package com.anurag.Binary_Tree;


import java.util.*;

class Tuple {
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
public class Vertical_Order_Traversal {
        public static List <List< Integer >> findVertical(TreeNode root) {
            TreeMap < Integer, TreeMap < Integer, PriorityQueue< Integer >>> map = new TreeMap< >();
            Queue< Tuple > q = new LinkedList<>();
            q.offer(new Tuple(root, 0, 0));
            while (!q.isEmpty()) {
                Tuple tuple = q.poll();
                TreeNode node = tuple.node;
                int x = tuple.row;
                int y = tuple.col;


                if (!map.containsKey(x)) {
                    map.put(x, new TreeMap < > ());
                }
                if (!map.get(x).containsKey(y)) {
                    map.get(x).put(y, new PriorityQueue < > ());
                }
                map.get(x).get(y).offer(node.val);

                if (node.left != null) {
                    q.offer(new Tuple(node.left, x - 1, y + 1));
                }
                if (node.right != null) {
                    q.offer(new Tuple(node.right, x + 1, y + 1));
                }
            }
            List < List < Integer >> list = new ArrayList < > ();
            for (TreeMap < Integer, PriorityQueue < Integer >> ys: map.values()) {
                list.add(new ArrayList < > ());
                for (PriorityQueue < Integer > nodes: ys.values()) {
                    while (!nodes.isEmpty()) {
                        list.get(list.size() - 1).add(nodes.poll());
                    }
                }
            }
            return list;
        }

        public static void main(String[] args) {

            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(10);
            root.left.left.right = new TreeNode(5);
            root.left.left.right.right = new TreeNode(6);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(9);
            root.right.right = new TreeNode(10);

            List < List < Integer >> list;
            list = findVertical(root);

            System.out.println("The Vertical Traversal is : ");
            for (List < Integer > it: list) {
                for (int nodeVal: it) {
                    System.out.print(nodeVal + " ");
                }
                System.out.println();
            }
            // The Time Complexity will be O(Nlog(N)) solution, where N is the number of nodes
            // The Space Complexity will be O(N) + O(N)
        }
}

