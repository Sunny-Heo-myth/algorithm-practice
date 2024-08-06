package org.alan.algorithm.lab.sort;

import static org.alan.algorithm.lab.sort.Utils.swap;

public class BubbleSort {

    public static void firstBubbleSort(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = array.length - 1; j >= array.length - i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void secondBubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                }
            }
        }
    }

    public static void thirdBubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j + 1, j);
                }
            }
        }
    }

    public static void improvedBubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int exchangedCount = 0;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    exchangedCount++;
                }
            }
            if (exchangedCount == 0) {
                break;
            }
        }
    }

    public static void improved2BubbleSort(int[] array) {
        int i = 0;
        while (i < array.length - 1) {
            int lastIndex = array.length - 1;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j - 1] > array[j]) {
                    swap(array, j - 1, j);
                    lastIndex = j;
                }
            }
            i = lastIndex;
        }
    }


}
