package org.alan.algorithm.practice.baekjoon.stepbystep.ifif;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2884 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int hour = Integer.parseInt(input[0]);
        int minute = Integer.parseInt(input[1]);

        if (hour > 0 && minute >= 45) System.out.println(hour + " " + (minute - 45));
        else if (hour > 0) System.out.println((hour - 1) + " " + (minute + 15));
        else if (hour == 0 && minute >= 45) System.out.println(0 + " " + (minute - 45));
        else System.out.println(23 + " " + (minute + 15));
    }

}
