package org.alan.algorithm.ioa.datastructure.queue;

public class BookIntQueue {
    private int max;
    private int front;
    private int rear;
    private int num;
    private int[] queue;

    public BookIntQueue(int capacity) {
        num = front = rear = 0;
        this.max = capacity;
        try {
            queue = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enQueue(int x) throws OverflowIntQueueException{
        if (num >= max) {
            throw new OverflowIntQueueException();
        }
        queue[rear++] = x;
        num++;

        if (rear == max) {
            rear = 0;
        }
        return x;
    }

    public int deQueue() throws EmptyIntQueueException {
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }
        int x = queue[front++];
        num--;

        if (front == max) {
            front = 0;
        }
        return x;
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
