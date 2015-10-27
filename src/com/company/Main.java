package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Insert 1");
        System.out.println("Result should be 1");

        MaxHeap heap = new MaxHeap();

        heap.push(1);

        System.out.println(heap.max() == 1);

        heap.push(10);

        System.out.println("Max should be 10");
        System.out.println(heap.max() == 10);

        heap.push(8);
        System.out.println("Max should be 10");
        System.out.println(heap.max() == 10);

        heap.push(16);
        System.out.println("Max should be 16");
        System.out.println(heap.max() == 16);

        heap.push(15);

        heap.delete();
        System.out.println("Max should be 15");
        System.out.println(heap.max() == 15);

        int val = heap.pop();
        System.out.println("Val should be 15 and Max should be 10");
        System.out.println(heap.max() == 10 && val == 15);

        heap.delete();
        System.out.println("Max should be 8");
        System.out.println(heap.max() == 8);

        System.out.println(heap);

        int[] array = new int[]{
                1,5,6,2,3,8,10
        };

        heap = MaxHeap.heapify(array);

        System.out.println("Max should be 8");
        System.out.println(heap.max() == 8);

        System.out.println(heap);
    }
}

