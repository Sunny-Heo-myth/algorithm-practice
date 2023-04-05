package org.alan.algorithm.concept.sort;

import static org.alan.algorithm.concept.sort.Utils.swap;

public class InsertionSort {

    public void firstInsertion(int[] array) {
        for (int left = 0; left < array.length; left++) {
            for (int right = left + 1; right < array.length; right++) {
                if (array[left] > array[right]) {
                    swap(array, left, right);
                }
            }
        }
    }

    public void secondInsertion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

}
