package org.alan.algorithm.lab.sort;

public class Utils {

    // swap second parameter with third parameter
    static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
