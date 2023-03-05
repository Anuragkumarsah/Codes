package com.anurag.GFG_Problems;

public class Maximum_Weight_Node {
    public static int maxWeightCell(int N, int[] Edge){
        int[] map = new int[N];
        for(int i=0;i<N;i++){
            if(Edge[i] == -1) continue;
            int index = Edge[i];
            map[index] += i;
        }
        int max = -1, index = 0;
        for(int i=0;i<N;i++){
            if(max <= map[i]){
                index = i;
                max = map[i];
            }
        }
        return index;
    }
    public static void main(String[] args) {
        int[] Edge = new int[]{2, 0, -1, 2};
        int N = Edge.length;
        System.out.println(maxWeightCell(N, Edge));
    }
}
