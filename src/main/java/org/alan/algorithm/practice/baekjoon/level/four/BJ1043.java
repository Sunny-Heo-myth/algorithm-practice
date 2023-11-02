package org.alan.algorithm.practice.baekjoon.level.four;

import java.util.Arrays;

public class BJ1043 {
    private int[] know;
    private boolean[][] hp;

    public String solve(String input) {
        String[] s = input.split("\n");
        String[] ss = s[0].split(" ");
        int numberOfPeople = Integer.parseInt(ss[0]);
        int numberOfParty = Integer.parseInt(ss[1]);
        hp = new boolean[numberOfPeople][numberOfParty];
        know = s[1].length() < 2 ? null : Arrays.stream(s[1].substring(2).split(" "))
                .mapToInt(Integer::parseInt).toArray();

        if (know == null) return String.valueOf(numberOfParty);

        for (int i = 2; i < s.length; i++) {
            int person = i - 2;
            Arrays.stream(s[i].substring(2).split(" "))
                    .mapToInt(Integer::parseInt).forEach(party -> hp[person][party] = true);
        }

        go();

        int count = 0;
        for (int j = 0; j < numberOfParty; j++) for (boolean[] booleans : hp)
            if (booleans[j]) {
                count++;
                break;
            }
        return String.valueOf(numberOfParty - count);
    }

    private void go() {



    }
}
