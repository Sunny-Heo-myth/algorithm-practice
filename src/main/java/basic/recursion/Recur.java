package basic.recursion;

import java.util.LinkedList;
import java.util.Stack;

public class Recur {

    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    static void recurWhile(int n) {
        while (n > 0) {
            recurWhile(n - 1);
            System.out.println(n);
            n -= 2;
        }
    }

    static void recurStack(int n) {
        Stack<Integer> stack = new Stack<>();

        while (true) {
            if (n > 0) {
                stack.push(n);
                n -= 1;
                continue;
            }
            if (!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n -= 2;
                continue;
            }
            break;
        }
    }

    public void recurStack2(int n) {
        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (n > 0) {
                stack.push(n);
                n -= 1;
                continue;
            }
            if (!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n -= 2;
                continue;
            }
            break;
        }
    }

}
