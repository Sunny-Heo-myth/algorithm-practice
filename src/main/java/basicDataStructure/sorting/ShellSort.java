package basicDataStructure.sorting;

public class ShellSort {

    static void shellSort(int[] array) {
        for (int h = array.length / 2; h > 0; h /= 2) {
            shell(array, h);
        }
    }

    static void shellSort2(int[] array) {
        int h;
        for (h = 1; h < array.length / 51; h = h * 3 + 1) {
        }
        for (;h > 0; h /= 3) {
            shell(array, h);
        }
    }

    static void shell(int[] array, int hop) {
        for (int i = hop; i < array.length; i++) {
            int j;
            int temp = array[i];
            for (j = i - hop; j >= 0 && array[j] > temp; j -= hop) {
                array[j + hop] = array[j];
            }
            array[j + hop] = temp;
        }
    }

}
