package org.alan.algorithm.datastructure.queue;

public class Queue {
    private int max;
    private int front;
    private int rear;
    private int numberOfContent;
    private int[] queue;

    public Queue(int capacity) {
        this.max = capacity;
        this.front = 0;
        this.rear = 0;
        this.numberOfContent = 0;
        try {
            this.queue = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enQueue(int x) throws OverflowIntQueueException {
        if (numberOfContent >= max) {
            throw new OverflowIntQueueException();
        }

        queue[rear++] = x;
        numberOfContent++;

        if (rear == max) {
            rear = 0;
        }
        return x;
    }

    public int dequeue() throws EmptyIntQueueException {
        if (numberOfContent <= 0) {
            throw new EmptyIntQueueException();
        }

        int x = queue[front++];
        numberOfContent--;

        if (front == max) {
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (numberOfContent <= 0) {
            throw new EmptyIntQueueException();
        }
        return queue[front];
    }

    public int indexOf(int x) {
        for (int i = 0; i < numberOfContent; i++) {
            int index = (i + front) % max;
            if (queue[index] == x) {
                return index;
            }
        }
        return -1;
    }

    public int search(int x) {
        for (int i = 0; i < numberOfContent; i++) {
            int index = (i + front) % max;
            if (queue[index] == x) {
                return i + 1;
            }
        }
        return 0;
    }

    public void clear() {
        numberOfContent = 0;
        front = 0;
        rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return numberOfContent;
    }

    public boolean isEmpty() {
        return numberOfContent <= 0;
    }

    public boolean isFull() {
        return numberOfContent >= max;
    }

    public void dump() {
        if (numberOfContent <= 0) {
            System.out.println("Queue is empty.");
        }
        else {
            for (int i = 0; i < numberOfContent; i++) {
                System.out.print(queue[(i + front) % max] + " ");
            }
            System.out.println();
        }
    }

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() {
        }
    }
}
