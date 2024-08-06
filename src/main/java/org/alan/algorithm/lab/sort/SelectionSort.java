package org.alan.algorithm.lab.sort;

import static org.alan.algorithm.lab.sort.Utils.swap;

public class SelectionSort {

    public void firstSelectionSort(int[] array) {    //o(n**2)
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }

    }
}
