package org.alan.algorithm.practice.programmers.crosssteppingstone;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

public class CrossSteppingStone {
    public int solution(int[] stones, int k) {
        int length = stones.length;
        LinkedHashSet<Integer> set = Arrays.stream(stones)
                .boxed()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int result = 0;
        for (Integer stone : set) {
            for (int i = 0; i < length; i++) {
                stones[i] -= (stone - result);
            }

            int count = 0;
            for (int j : stones) {
                if (j <= 0) {
                    count++;
                } else {
                    count = 0;
                }

                if (count > k) {
                    return result;
                }
            }

            result = stone;
        }

        return result;
    }
}
