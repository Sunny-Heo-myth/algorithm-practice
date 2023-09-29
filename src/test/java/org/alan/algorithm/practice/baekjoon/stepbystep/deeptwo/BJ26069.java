package org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
        Map<String, Boolean> map = new HashMap<>();

        // DNI flag as false
        boolean flag = false;

        // DNI count as 0
        int count = 0;

        // for each meeting
        for (String[] ss : meeting) {
            // if there is chong chong
            if (Objects.equals(ss[0], "ChongChong") || Objects.equals(ss[1], "ChongChong")) {
                map.put(ss[0], true);
                map.put(ss[1], true);
                flag = true;
                continue;
            }

            // if flag is true
            if (flag) {
                if (map.containsKey(ss[0]) || map.containsKey(ss[1])) {
                    map.put(ss[0], true);
                    map.put(ss[1], true);
                }
            }
        }

        return String.valueOf(map.keySet().size());
    }
}
