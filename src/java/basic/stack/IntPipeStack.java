package basic.stack;

public class IntPipeStack {
    int max;
    int lowPointer;
    int highPointer;
    int[] stack;

    public IntPipeStack(int max) {
        this.max = max;
        this.lowPointer = 0;
        this.highPointer = max;
        this.stack = new int[max];
    }

    public int lowEdgePush(int x) throws OverflowIntStackException{
        if (lowPointer >= highPointer) {
            throw new OverflowIntStackException();
        }
        return stack[lowPointer++] = x;
    }

    public int highEdgePush(int x) throws OverflowIntStackException{
        if (lowPointer >= highPointer) {
            throw new OverflowIntStackException();
        }
        return stack[--highPointer] = x;
    }

    public int lowEdgePop() throws lowEdgeEmptyIntStackException{
        if (lowPointer <= 0) {
            throw new lowEdgeEmptyIntStackException();
        }
        return stack[--lowPointer];
    }

    public int highEdgePop() throws highEdgeEmptyIntStackException{
        if (highPointer >= max) {
            throw new highEdgeEmptyIntStackException();
        }
        return stack[highPointer];
    }

    public int lowPeek() {
        if (lowPointer <= 0) {
            throw new lowEdgeEmptyIntStackException();
        }
        return stack[lowPointer];
    }

    public int highPeek() {
        if (highPointer <= 0) {
            throw new highEdgeEmptyIntStackException();
        }
        return stack[highPointer];
    }

    public int lowIndexOf(int value) {
        for (int i = lowPointer - 1; i >= 0; i--) {
            if (stack[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public int highIndexOf(int value) {
        for (int i = highPointer; i < max; i++) {
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
