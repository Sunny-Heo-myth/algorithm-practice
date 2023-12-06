package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.Arrays;

public class BJ1931 {

    public String solve(String input) {
        String[] s = input.split("\n");
        // D&I meeting array
        int[][] meetings = new int[s.length - 1][2];
        for (int i = 1; i < s.length; i++) {
            String[] ss = s[i].split(" ");
            meetings[i - 1][0] = Integer.parseInt(ss[0]);
            meetings[i - 1][1] = Integer.parseInt(ss[1]);
        }

        Arrays.sort(meetings, (meet1, meet2) -> {
            if (meet1[1] > meet2[1]) return 1;
            else if (meet1[1] == meet2[1]) return Integer.compare(meet1[0], meet2[0]);
            else return -1;
        });

        int count = 0;
        int previousEnd = 0;
        for (int[] meet : meetings) {
            if (meet[0] >= previousEnd) {
                count++;
                previousEnd = meet[1];
            }
        }
        return String.valueOf(count);
    }
}
