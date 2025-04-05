package org.alan.algorithm.practice.baekjoon.tagged.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BJ1450 {
    private final int total;
    private final int[] things;

    public BJ1450(String input) {
        String[] lines = input.split("\n");
        total = Integer.parseInt(lines[0].split(" ")[1]);
        things = Arrays.stream(lines[1].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public String solve() {
        ArrayList<Long> sum1 = new ArrayList<>(), sum2 = new ArrayList<>();
        collect(0, things.length / 2, 0, sum1);
        collect(things.length / 2, things.length, 0, sum2);
        Collections.sort(sum2);

        int count = 0;
        for (long sum : sum1) {
            long remains = total - sum;
            int low = 0, high = sum2.size();
            while (low < high) {
                int mid = (low + high) >> 1;
                if (remains >= sum2.get(mid)) low = mid + 1;
                else  high = mid;
            }
            count += low;
        }
        return String.valueOf(count);
    }

    private void collect(int startIn, int endEx, long sum, ArrayList<Long> to) {
        if (sum > total) return;
        if (startIn == endEx) {
            to.add(sum);
            return;
        }

        collect(startIn + 1, endEx, sum, to);
        collect(startIn + 1, endEx, sum + things[startIn], to);
    }

}
