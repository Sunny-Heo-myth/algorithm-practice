package org.alan.algorithm.ioa.recursion;

public class Hanoi {

    public static void move(int disk, int from, int to) {
        if (disk > 1) {
            move(disk - 1, from, 6 - from - to);
        }
        System.out.println("Move disk " + disk + " from " + from + " to " + to +".");

        if (disk > 1) {
            move(disk - 1, 6 - from - to, to);
        }
    }

























}
