package basic.sorting;

import static basic.sorting.Utils.swap;

public class SelectionSort {


    static void selectionSort(int[] array) {    //o(n**2)
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
