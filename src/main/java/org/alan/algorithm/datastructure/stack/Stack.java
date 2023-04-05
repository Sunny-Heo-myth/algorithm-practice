package org.alan.algorithm.datastructure.stack;

public class Stack {

    private int max;
    private int pointer;
    private int[] stack;

    public Stack(int capacity) {
        this.max = capacity;
        this.pointer = 0;
        try {
            stack = new int[max];
        }
        catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (pointer >= max) {
            throw new OverflowIntStackException();
        }
        return stack[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0) {
            throw new EmptyIntStackException();
        }
        return stack[pointer - 1];
    }

    public int indexOf(int x) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public void clear() {
        pointer = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= max;
    }

    public void dump() {
        if (pointer <= 0) {
            System.out.println("Stack is empty.");
        }
        else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }

    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

}
