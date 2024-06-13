package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class BJ30804 {
    public String solve(String input) {
        int[] candy = input.lines().skip(1).flatMapToInt(s -> Pattern.compile(" ")
                .splitAsStream(s).mapToInt(Integer::parseInt)).toArray();
        int[] fruits = new int[10]; Set<Integer> fruitSet = new HashSet<>();

        int max = 0; int i = 0; int j = 0;
        while (j < candy.length) {
            fruitSet.add(candy[j]);
            fruits[candy[j]]++;
            if (fruitSet.size() > 2) {
                if (--fruits[candy[i]] == 0) fruitSet.remove(candy[i]);
                i++;
            } else max = Math.max(max, j - i + 1);
            j++;
        }
        return String.valueOf(max);
    }
}
