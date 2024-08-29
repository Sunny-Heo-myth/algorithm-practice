package org.alan.algorithm.lab.datastructure.heap;

public class MaxHeap {
    private final int[] arr;
    private final int capacity;
    private int size = 0;

    public MaxHeap(int maxSize) {
        this.arr = new int[maxSize + 1];
        this.capacity = maxSize;
        this.arr[0] = Integer.MAX_VALUE;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private boolean isLeaf(int i) {
        return i > (size / 2) && i <= size;
    }

    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void maxHeapify(int i) {
        if (isLeaf(i)) return;

        int l = leftChild(i);
        int r = rightChild(i);

        int bigger = i;
        if (l <= size && arr[l] > arr[bigger]) bigger = l;
        if (r <= size && arr[r] > arr[bigger]) bigger = r;
        if (bigger == i) return;

        swap(i, bigger);
        maxHeapify(bigger);
    }

    public int poll() {
        int polled = arr[1];
        arr[1] = arr[size--];
        maxHeapify(1);
        return polled;
    }

    public int peek() {
        return arr[1];
    }

    public void insert(int v) {
        if (size >= capacity) throw new RuntimeException("MaxHeap is full.");

        arr[++size] = v;

        int i = size;
        while (arr[i] > arr[parent(v)]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }
}
