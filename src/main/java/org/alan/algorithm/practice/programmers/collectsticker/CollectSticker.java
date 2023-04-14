package org.alan.algorithm.practice.programmers.collectsticker;

import java.util.Arrays;

public class CollectSticker {
    private int[] array;
    private Integer[] sumArray;

    public int solution(int[] sticker) {
        array = sticker;
        sumArray = new Integer[sticker.length];
        dfs(0);

        return Arrays.stream(sumArray).reduce(Math::max).get();
    }

    private void dfs(int idx) {
        if (idx >= sumArray.length - 2) {
            sumArray[idx] = array[idx];
            return;
        }

        for (int i = idx; i < sumArray.length; i++) {
            if (sumArray[i] == null) {

                int max = Integer.MIN_VALUE;
                for (int j = i + 2; j < sumArray.length; j++){
                    dfs(j);
                    max = Math.max(max, sumArray[j]);
                }

                sumArray[i] = array[i] + max;
            } else {
                return;
            }

        }
    }
}
