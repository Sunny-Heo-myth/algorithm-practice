package org.alan.algorithm.practice.baekjoon.stepbystep.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ24060 {
    int length;
    int sortCount;
    private int[] array;

    public BJ24060(int length, int sortCount, int[] inputArray) {
        this.length = length;
        this.sortCount = sortCount;
        this.array = inputArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] line = bf.readLine().split(" ");
        int length = Integer.parseInt(line[0]);
        int sortCount = Integer.parseInt(line[1]);

        int[] array = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        BJ24060 instance = new BJ24060(length, sortCount, array);

        instance.mergeSort(array);

    }
    public int[] mergeSort(int[] array) {
        int length = array.length;
        int half = length / 2;
        int[] left = new int[half];
        int[] right = new int[length - half];

        if (left.length > 1) {
            System.arraycopy(array, 0, left, 0, left.length);
            mergeSort(left);
        }

        if (right.length > 1) {
            System.arraycopy(array, half, right, 0, right.length);
            mergeSort(right);
        }

        int[] sortedArray = new int[array.length];

        return null;
    }

    /**
     *
     * @param array : target array
     * @param firstIndex : first index (usually start with 0)
     * @param lastIndex : the last index number
     */
    public void mergeSort(int[] array, int firstIndex, int lastIndex) {
        if (firstIndex < lastIndex) {
            int endOfFirstHalfIndex = (firstIndex + lastIndex) / 2;
            mergeSort(array, firstIndex, endOfFirstHalfIndex);
            mergeSort(array, endOfFirstHalfIndex + 1, lastIndex);
            merge(array, firstIndex, endOfFirstHalfIndex, lastIndex);
        }
    }

    private void merge(int[] array, int firstIndex, int half, int end) {
        int i = firstIndex;
        int j = half + 1;
        int k = 0;
        int[] sortedArray = new int[array.length];

        while (i < half && j < end) {
            if (array[i] <= array[j]) {
                sortedArray[k] = array[i];
                i++;
            } else {
                sortedArray[k] = array[j];
                j++;
            }
            k++;
        }
    }

//    merge_sort(A[p..r]) { # A[p..r]을 오름차순 정렬한다.
//        if (p < r) then {
//            q <- ⌊(p + r) / 2⌋;       # q는 p, r의 중간 지점
//            merge_sort(A, p, q);      # 전반부 정렬
//            merge_sort(A, q + 1, r);  # 후반부 정렬
//            merge(A, p, q, r);        # 병합
//        }
//    }
//
//# A[p..q]와 A[q+1..r]을 병합하여 A[p..r]을 오름차순 정렬된 상태로 만든다.
//# A[p..q]와 A[q+1..r]은 이미 오름차순으로 정렬되어 있다.
//            merge(A[], p, q, r) {
//        i <- p; j <- q + 1; t <- 1;
//        while (i ≤ q and j ≤ r) {
//            if (A[i] ≤ A[j])
//            then tmp[t++] <- A[i++]; # tmp[t] <- A[i]; t++; i++;
//        else tmp[t++] <- A[j++]; # tmp[t] <- A[j]; t++; j++;
//        }
//        while (i ≤ q)  # 왼쪽 배열 부분이 남은 경우
//        tmp[t++] <- A[i++];
//        while (j ≤ r)  # 오른쪽 배열 부분이 남은 경우
//        tmp[t++] <- A[j++];
//        i <- p; t <- 1;
//        while (i ≤ r)  # 결과를 A[p..r]에 저장
//        A[i++] <- tmp[t++];
//    }
}
