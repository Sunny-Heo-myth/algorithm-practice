package basic.sorting;

import static basic.sorting.Utils.swap;

public class InsertionSort {
    static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j;
            int temp = array[i];
            for (j = i; j > 0 && array[j - 1] > temp; j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }

    static void insertionSort2(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
        }
    }

}
