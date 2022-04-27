package basic.stack;

public class IntPipeStack {
    int max;
    int front;
    int rear;
    int[] stack;

    public IntPipeStack(int max) {
        this.max = max;
        this.front = 0;
        this.rear = max;
        this.stack = new int[max];
    }

    public int pushFront(int x) throws OverflowIntStackException{
        if (front >= rear) {
            throw new OverflowIntStackException();
        }
        return stack[front++] = x;
    }

    public int pushRear(int x) throws OverflowIntStackException{
        if (front >= rear) {
            throw new OverflowIntStackException();
        }
        return stack[--rear] = x;
    }

    public int popFront() throws lowEdgeEmptyIntStackException{
        if (front <= 0) {
            throw new lowEdgeEmptyIntStackException();
        }
        return stack[--front];
    }

    public int popRear() throws highEdgeEmptyIntStackException{
        if (rear >= max) {
            throw new highEdgeEmptyIntStackException();
        }
        return stack[rear++];
    }

    public int peekFront() {
        if (front <= 0) {
            throw new lowEdgeEmptyIntStackException();
        }
        return stack[front];
    }

    public int peekRear() {
        if (rear <= 0) {
            throw new highEdgeEmptyIntStackException();
        }
        return stack[rear];
    }

    public int indexOfFront(int value) {
        for (int i = front - 1; i >= 0; i--) {
            if (stack[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int indexOfRear(int value) {
        for (int i = rear; i < max; i++) {
            if (stack[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private class lowEdgeEmptyIntStackException extends RuntimeException {
        public lowEdgeEmptyIntStackException() {
        }
    }
    private class highEdgeEmptyIntStackException extends RuntimeException {
        public highEdgeEmptyIntStackException() {
        }
    }
    private class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }
}
