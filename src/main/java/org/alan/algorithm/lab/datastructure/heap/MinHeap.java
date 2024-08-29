package org.alan.algorithm.lab.datastructure.heap;

public class MinHeap {
    private final int[] arr;
    private final int capacity;
    private int size = 0;

    public MinHeap(int capacity) {
        this.arr = new int[capacity + 1];
        this.capacity = capacity;
        arr[0] = Integer.MIN_VALUE;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int left(int i) {
        return 2 * i;
    }

    private int right(int i) {
        return 2 * i + 1;
    }

    private boolean isLeaf(int i) {
        return i > size / 2  && i <= size;
    }

    private void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int peek() {
        return arr[1];
    }

    private void minHeapify(int i) {
        if (isLeaf(i)) return;

        int l = left(i);
        int r = right(i);

        int smaller = i;
        if (l <= size && arr[l] < arr[smaller]) smaller = l;
        if (r <= size && arr[r] < arr[smaller]) smaller = r;
        if (smaller == i) return;

        swap(i, smaller);
        minHeapify(smaller);
    }

    public void insert(int v) {
        if (size >= capacity) throw new RuntimeException("MinHeap is full");

        arr[++size] = v;

        int i = size;
        while (arr[i] < arr[parent(i)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    public int poll() {
        int polled = arr[1];
        arr[1] = arr[size--];
        minHeapify(1);
        return polled;
    }


}
