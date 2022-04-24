package basic.Queue;

public class IntQueue {
    final int max;
    final int[] queue;
    int num;
    int start;
    int end;

    public IntQueue(int max) {
        this.max = max;
        this.queue = new int[max];
        this.num = 0;
        this.start = 0;
        this.end = 0;
    }

    public int enQueue(int value) throws FullIntQueueException{
        if (num >= max) {
            throw new FullIntQueueException();
        }

        if (end >= max) {
            end = 0;
        }
        else {
            end++;
        }

        queue[end] = value;

        num++;
        return num;
    }

    public int deQueue() throws EmptyIntQueueException{
        if (num <= 0) {
            throw new EmptyIntQueueException();
        }

        int value = queue[start];

        if (start >= max) {
            start = 0;
        }
        else {
            start++;
        }

        num--;
        return value;
    }

    private class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    private class FullIntQueueException extends RuntimeException {
        public FullIntQueueException() {
        }
    }
}
