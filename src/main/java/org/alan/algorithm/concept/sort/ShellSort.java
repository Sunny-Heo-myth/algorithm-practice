package org.alan.algorithm.concept.sort;

public class ShellSort {

    public void firstShellSort(int[] array) {
        for (int h = array.length / 2; h > 0; h /= 2) {
            shell(array, h);
        }
    }

    public void secondShellSort(int[] array) {
        int h;
        for (h = 1; h < array.length / 51; h = h * 3 + 1) {
        }
        for (;h > 0; h /= 3) {
            shell(array, h);
        }
    }

    private void shell(int[] array, int hop) {
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
