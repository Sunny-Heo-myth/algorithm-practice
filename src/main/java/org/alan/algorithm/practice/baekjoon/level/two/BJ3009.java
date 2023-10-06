package org.alan.algorithm.practice.baekjoon.level.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ3009 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[][] intss = new int[3][2];
        for (int[] ints : intss) {
            String[] strings = bf.readLine().split(" ");
            ints[0] = Integer.parseInt(strings[0]);
            ints[1] = Integer.parseInt(strings[1]);
        }

        int axis1st = 0, axis2nd = 0;
        if (intss[0][0] == intss[1][0]) axis1st = intss[2][0];
        else axis1st = intss[0][0] == intss[2][0] ? intss[1][0] : intss[0][0];

        if (intss[0][1] == intss[1][1]) axis2nd = intss[2][1];
        else axis2nd = intss[0][1] == intss[2][1] ? intss[1][1] : intss[0][1];

        System.out.print(axis1st + " " + axis2nd);


    }
}
