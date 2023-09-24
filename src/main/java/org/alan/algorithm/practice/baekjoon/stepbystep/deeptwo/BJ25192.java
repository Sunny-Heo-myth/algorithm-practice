package org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo;

import java.util.Arrays;

public class BJ25192 {
    public String solve(String input) {
        // parse total log
        String[] s = input.split("\nENTER");

        // D&I count
        int count = 0;

        // for each ENTER bundle
        for (int i = 1; i < s.length; i++) {
            // split unit log
            String[] ss = s[i].split("\n");
            // delete redundant log & add to count. O(nlgn)
            count += (Arrays.stream(ss).distinct().toArray().length - 1);
        }
        // return count
        return String.valueOf(count);
    }
}
