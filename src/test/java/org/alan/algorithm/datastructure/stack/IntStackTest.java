package org.alan.algorithm.datastructure.stack;

public class IntStackTest {
    public static void main(String[] args) {
        org.alan.algorithm.datastructure.stack.IntStack intStack = new org.alan.algorithm.datastructure.stack.IntStack(10);

        for (int i = 0; i < 20; i += 2) {
            intStack.push(100 + i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(intStack.indexOf(100 + 2 * i)).append(" ");
        }
        System.out.println(sb);
        System.out.println(intStack.isFull());
    }
}
