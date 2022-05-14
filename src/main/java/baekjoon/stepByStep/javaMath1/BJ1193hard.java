package baekjoon.stepByStep.javaMath1;

import java.util.Scanner;

public class BJ1193hard {

    public static void main(String[] args) {
        int x = new Scanner(System.in).nextInt();
        int base = 1;
        int parent;
        int child;
        while (base * (base + 1) / 2 < x) base++;
        int remainder = x - (base - 1) * base / 2 + 1;
        if (base % 2 == 1) {
            parent = base + 1 - remainder;
            child = remainder;
        } else {
            child = base + 1 - remainder;
            parent = remainder;
        }
        System.out.print(child + "/" + parent);
    }
}
