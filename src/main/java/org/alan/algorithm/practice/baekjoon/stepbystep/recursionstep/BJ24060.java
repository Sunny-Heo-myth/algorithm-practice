package org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ24060 {
    int savedAt;
    int[] array;
    int count = 0;
    int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(new BJ24060(bf.readLine() + "\n" + bf.readLine()).answer());
    }

    public BJ24060(String input) {
        String[] lines = input.split("\n");
        savedAt = Integer.parseInt(lines[0].split(" ")[1]);
        array = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public int answer() {
        merge_sort(0, array.length - 1);
        return answer;
    }

    public void merge_sort(int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int flooredMiddle = Math.floorDiv((firstIndex + lastIndex), 2);
            merge_sort(firstIndex, flooredMiddle);
            merge_sort(flooredMiddle + 1, lastIndex);
            merge(firstIndex, flooredMiddle, lastIndex);
        }
    }
    
    private void merge(int first, int mid, int last) {
        int[] left = new int[mid - first + 1];
        int[] right = new int[last - mid];
        System.arraycopy(array, first, left, 0, left.length);
        System.arraycopy(array, mid + 1, right, 0, right.length);

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                array[first + k] = left[i++];
                counter(array[first + k]);
            } else {
                array[first + k] = right[j++];
                counter(array[first + k]);
            }
            k++;
        }

        while (i < left.length) {
            array[first + k] = left[i++];
            counter(array[first + k++]);
        }
        while (j < right.length) {
            array[first + k] = right[j++];
            counter(array[first + k++]);
        }
    }

    private void counter(int element) {
        count++;
        if (count == savedAt) {
            answer = element;
        }
    }
}
