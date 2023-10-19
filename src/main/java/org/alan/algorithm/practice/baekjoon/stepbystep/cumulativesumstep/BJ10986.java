package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BJ10986 {

    public String solve(String input) {
        String[] s = input.split("\n");
        int divisor = Integer.parseInt(s[0].split(" ")[1]);
        long[] array = Arrays.stream(s[1].split(" ")).mapToLong(Long::parseLong).toArray();

        for (int i = 1; i < array.length; i++) array[i] += array[i - 1];    // O(n)
        for (int i = 0; i < array.length; i++) array[i] %= divisor;

        Map<Long, Integer> map = new HashMap<>();
        for (long remainder : array)
            if (map.containsKey(remainder)) map.put(remainder, map.get(remainder) + 1);
            else map.put(remainder, 1);

        long count = 0; // should be long
        if (map.containsKey(0L)) count += map.get(0L);
        for (long value : map.values()) if (value > 1) count += value * (value - 1) / 2;
        return String.valueOf(count);
    }
}
