package com.anurag.OnlineJavaClass;

public class Sorting {
    static void bubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } 
            }
        }
        System.out.println("Array sorted : ");
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }
    static void revBubbleSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted in reverse Order : ");
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        bubbleSort(arr);
        revBubbleSort(arr);
    }

}
