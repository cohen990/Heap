package com.company;

import java.util.Arrays;

public class MaxHeap {
    private Node[] _values;

    public MaxHeap() {
        _values = new Node[1];
    }

    public void push(int value) {
        if (_values[_values.length - 1] != null) {
            Node[] temp = new Node[((_values.length + 1) * 2) - 1];
            for (int i = 0; i < _values.length; i++) {
                temp[i] = _values[i];
            }

            _values = temp;
        }

        int i = _values.length;
        while (i > 0 && _values[i - 1] == null) {
            i--;
        }

        _values[i] = new Node(value);

        int oldIndex = 0;
        int newIndex = i;
        while (oldIndex != newIndex) {
            oldIndex = newIndex;
            newIndex = siftUp(oldIndex);
        }
    }

    public int nodeAt(int index) {
        return _values[0].value;
    }

    public int max() {
        return _values[0].value;
    }

    public void delete() {
        int i = _values.length - 1;
        while (_values[i] == null) {
            i--;
        }

        _values[0] = _values[i];
        _values[i] = null;

        int oldIndex = i;
        int newIndex = 0;
        while (oldIndex != newIndex) {
            oldIndex = newIndex;
            newIndex = siftDown(oldIndex);
        }
    }

    private int siftDown(int index) {
        if (index == _values.length) {
            return index;
        }

        Node curr = _values[index];

        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;

        if (leftChildIndex >= _values.length) {
            return index;
        }
        if (rightChildIndex >= _values.length) {
            return index;
        }

        int leftChildValue = 0;
        int rightChildValue = 0;

        Node leftChild = _values[leftChildIndex];
        Node rightChild = _values[rightChildIndex];

        if (leftChild != null) {
            leftChildValue = leftChild.value;
        }
        if (rightChild != null) {
            rightChildValue = rightChild.value;
        }

        if (rightChildValue < curr.value && leftChildValue < curr.value) {
            return index;
        }

        if (rightChildValue > leftChildValue) {
            _values[index] = rightChild;
            _values[rightChildIndex] = curr;

            return rightChildIndex;
        }

        _values[index] = leftChild;
        _values[leftChildIndex] = curr;

        return leftChildIndex;
    }

    @Override
    public String toString() {
        return Arrays.toString(_values);
    }

    private int siftUp(int index) {
        if (index == 0) {
            return index;
        }

        Node current = _values[index];
        int indexOfParent = (index - 1) / 2;
        Node parent = _values[indexOfParent];

        if (current.value > parent.value) {
            _values[indexOfParent] = current;
            _values[index] = parent;
            return indexOfParent;
        }
        return index;
    }

    public int pop() {
        int val = this.max();
        this.delete();
        return val;
    }

    public static MaxHeap heapify(int[] array) {
        MaxHeap heap = new MaxHeap();

        for(int i = 0; i < array.length; i++){
            heap.push(array[i]);
        }

        return heap;
    }

    class Node {
        public Node(int in) {
            value = in;
        }

        public int value;

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

}
