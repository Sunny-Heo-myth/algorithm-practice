package org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep;

import java.util.Arrays;

public class BJ24060 {
    private int order;
    private int currentOrder = 0;
    private int answer = -1;

    public String solve(String input) {
        String[] s = input.split("\n");
        String[] ss = s[0].split(" ");
        order = Integer.parseInt(ss[1]);
        int[] array = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).toArray();

        mergeSort(array);

        return String.valueOf(answer);
    }

    private void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int middle = array.length / 2;
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, middle, right, 0, right.length);    // total repeat: N per level, lgN

        mergeSort(left);
        mergeSort(right);
        merge(array, left, right);
    }

    private void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {   // total repeat: N per level, level lgN
            if (left[i] < right[j]) {
                array[k] = left[i++];
                orderCheck(array[k]);
            }
            else {
                array[k] = right[j++];
                orderCheck(array[k]);
            }
            k++;
        }

        while (i < left.length) {
            array[k] = left[i++];
            orderCheck(array[k++]);
        }
        while (j < right.length) {
            array[k] = right[j++];
            orderCheck(array[k++]);
        }
    }

    private void orderCheck(int n) {
        if (order == ++currentOrder) {
            answer = n;
//            System.exit(0);
        }
    }

}
