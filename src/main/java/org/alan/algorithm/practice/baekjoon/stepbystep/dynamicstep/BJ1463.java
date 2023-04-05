package org.alan.algorithm.practice.baekjoon.stepbystep.dynamicstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

    static int number;
    static Integer[] numberArr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        number = Integer.parseInt(bf.readLine());
        numberArr = new Integer[number + 1];
        numberArr[0] = 0;
        numberArr[1] = 0;

        System.out.print(toOne(number));
    }

    static int toOne(int number) {

        if (numberArr[number] == null) {

            if (number % 6 == 0) {
                numberArr[number] = Math.min(toOne(number - 1),
                        Math.min(toOne(number / 3), toOne(number / 2))) + 1;
            } else if (number % 3 == 0) {
                numberArr[number] = Math.min(toOne(number / 3), toOne(number - 1)) + 1;
            } else if (number % 2 == 0) {
                numberArr[number] = Math.min(toOne(number / 2), toOne(number - 1)) + 1;
            } else {
                numberArr[number] = toOne(number - 1) + 1;
            }
        }
        return numberArr[number];
    }
}
