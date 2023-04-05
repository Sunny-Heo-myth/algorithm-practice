package org.alan.algorithm.practice.baekjoon.stepbystep.sortstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(bf.readLine());
        }

        ints = mergeSort(ints);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(ints[i]).append("\n");
        }
        System.out.print(sb);
    }

    static int[] mergeSort(int[] intArray) {
        int length = intArray.length;
        if (length == 1) return intArray;
        else {
            int half = length / 2;
            int[] left = new int[half];
            int[] right = new int[length - half];
            System.arraycopy(intArray, 0, left, 0, half);
            System.arraycopy(intArray, half, right, 0, length - half);

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }
    }
    
    static int[] merge(int[] left, int[] right) {
        int lLength = left.length;
        int rLength = right.length;
        int[] result = new int[lLength + rLength];

        int i = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < lLength && rightIndex < rLength) {
            if (left[leftIndex] < right[rightIndex]) {
                result[i] = left[leftIndex];
                leftIndex++;
            }
            else {
                result[i] = right[rightIndex];
                rightIndex++;
            }
            i++;
        }

        while (leftIndex < lLength) {
            result[i] = left[leftIndex];
            i++;
            leftIndex++;
        }
        while (rightIndex < rLength) {
            result[i] = right[rightIndex];
            i++;
            rightIndex++;
        }
        return result;
    }
}
