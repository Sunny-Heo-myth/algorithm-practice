package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2798 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bf.readLine().split(" ");
        String[] integers = bf.readLine().split(" ");

        int[] ints = new int[Integer.parseInt(strings[0])];
        for (int i = 0; i < Integer.parseInt(strings[0]); i++) {
            ints[i] = Integer.parseInt(integers[i]);
        }
        int target = Integer.parseInt(strings[1]);

        System.out.print(threeSum(ints, target));
    }

    static int threeSum(int[] ints, int targetInt) {
        int length = ints.length;
        int shortest = Integer.MAX_VALUE;
        int answer = 0;
        int candidate = 0;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {

                    candidate = ints[i] + ints[j] + ints[k];
                    int distance = targetInt - candidate;
                    if (candidate == targetInt) return targetInt;
                    else if (distance > 0 && distance <= shortest) {
                        shortest = distance;
                        answer = candidate;
                    }
                }
            }
        }
        return answer;
    }
}
