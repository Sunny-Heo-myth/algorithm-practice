package org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BJ26069 {
    public String solve(String input) {
        // parse
        String[] s = input.split("\n");

        // DNI meeting array
        String[][] meeting = new String[Integer.parseInt(s[0])][2];
        for (int i = 1; i < meeting.length + 1; i++) {
            String[] ss = s[i].split(" ");
            meeting[i - 1][0] = ss[0];
            meeting[i - 1][1] = ss[1];
        }

        // DNI map
        Set<String> set = new HashSet<>();

        // DNI flag as false
        boolean flag = false;

        // DNI count as 0
        int count = 0;

        // for each meeting
        for (String[] ss : meeting) {
            // if there is chong chong
            if (Objects.equals(ss[0], "ChongChong") || Objects.equals(ss[1], "ChongChong")) {
                set.add(ss[0]);
                set.add(ss[1]);
                flag = true;
                continue;
            }

            // if flag is true
            if (flag) {
                if (set.contains(ss[0]) || set.contains(ss[1])) {
                    set.add(ss[0]);
                    set.add(ss[1]);
                }
            }
        }

        return String.valueOf(set.size());
    }
}
