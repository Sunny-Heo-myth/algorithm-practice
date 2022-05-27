package basicDataStructure.queue;

public class Deque {

    int max;
    int front;
    int rear;
    int numberOfContent;
    int[] deque;

    public Deque(int max) {
        this.max = max;
        this.front = 0;
        this.rear = 0;
        this.numberOfContent = 0;
        try {
            this.deque = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int enDequeFront(int x) throws OverflowDequeException {
        if (max <= numberOfContent) {
            throw new OverflowDequeException();
        }

        deque[front++] = x;
        numberOfContent++;

        if (front == max) {
            front = 0;
        }
        return x;
    }

    public int enDequeueRear(int x) throws OverflowDequeException {
        if (max <= numberOfContent) {
            throw new OverflowDequeException();
        }
        deque[rear++] = x;
        numberOfContent++;

        if (rear == max) {
            rear =0;
        }
        return x;
    }

    public class EmptyDequeException extends RuntimeException {
        public EmptyDequeException() {
        }
    }

    public class OverflowDequeException extends RuntimeException {
        public OverflowDequeException() {
        }
    }
}
