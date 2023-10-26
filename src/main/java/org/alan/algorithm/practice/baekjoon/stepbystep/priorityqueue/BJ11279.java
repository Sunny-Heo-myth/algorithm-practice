package org.alan.algorithm.practice.baekjoon.stepbystep.priorityqueue;

import java.util.Arrays;

public class BJ11279 {
    public String solve(String input) {
        String[] s = input.split("\n");
        StringBuilder sb = new StringBuilder();

        MaxHeap heap = new MaxHeap(10);
        for (int i = 0; i < Integer.parseInt(s[0]); i++) {
            int n = Integer.parseInt(s[i + 1]);
            if (n == 0) sb.append(heap.poll()).append("\n");
            else heap.add(n);
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}

class MaxHeap {
    private int[] heap; // index 0 will not be used.
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity + 1;
        this.size = 0;
        heap = new int[this.capacity];
    }


    public int peek() {
        if (size == 0) return 0;
        return heap[1];
    }

    public int poll() {
        if (size == 0) return 0;
        int item = heap[1];
        heap[1] = heap[size];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        heap[size + 1] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size;
        while (index > 1) {
            int parent = getParent(index);
            if (heap[index] <= heap[parent]) break;
            swap(index, parent);
            index = parent;
        }
    }

    private void heapifyDown() {
        int index = 1;  // from the top
        while (true) {
            int leftChild = getLeftChild(index);
            if (leftChild > size) break;

            int largerChild = leftChild;

            int rightChild = getRightChild(index);
            if (rightChild <= size && heap[rightChild] > heap[leftChild]) largerChild = rightChild;

            if (heap[index] > heap[largerChild]) break;
            else swap(index, largerChild);

            index = largerChild;
        }
    }

    private void ensureExtraCapacity() {
        if (size + 1 == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    private int getParent(int i) {
        return i / 2;
    }

    private int getLeftChild(int i) {
        return 2 * i;
    }

    private int getRightChild(int i) {
        return 2 * i + 1;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}