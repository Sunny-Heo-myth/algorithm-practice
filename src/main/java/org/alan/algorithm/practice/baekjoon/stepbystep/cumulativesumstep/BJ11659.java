package org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep;

import java.util.Arrays;
import java.util.Comparator;

public class BJ11659 {

    public String solve(String input) {
        String[] s = input.split("\n");
        int[] ints = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).toArray();

        // D&I rod: n * 3 array (with sort order)
        int[][] rods = new int[Integer.parseInt(s[0].split(" ")[1])][4];
        for (int i = 2; i < s.length; i++) {
            String[] rod = s[i].split(" ");
            rods[i - 2] = new int[]{i - 2, Integer.parseInt(rod[0]), Integer.parseInt(rod[1]), 0};
        }

        // sort rod first by starting point & then second point. O(NlgN)
        Arrays.sort(rods, (rod1, rod2) -> {
            if (rod1[1] < rod2[1]) return -1;
            else if (rod1[1] == rod2[1]) return Integer.compare(rod2[2], rod1[2]);
            else return 1;
        });

        // start counting.
        int[] previousRod = new int[4];
        for (int[] rod : rods) {
            int count = 0;
            // if previous rod does not start with same start point count all & save it.
            // else use saved number for this rod's counting.
            if (previousRod[0] != rod[0]) for (int i = rod[1] - 1; i < rod[2]; i++) count += ints[i];
            else for (int i = previousRod[2]; i < rod[2]; i++) count += ints[i];
            rod[3] = count;
            previousRod = rod;
        }

        // sort again with order. O(NlgN)
        Arrays.sort(rods, Comparator.comparingInt(rod -> rod[0]));

        StringBuilder sb = new StringBuilder();
        Arrays.stream(rods).forEach(rod -> sb.append(rod[3]).append("\n"));
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public String solve2(String input) {
        String[] s = input.split("\n");
        int[] ints = Arrays.stream(s[1].split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sums = new int[ints.length + 1];
        int sum = 0;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sum += ints[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < s.length; i++) {
            String[] rod = s[i].split(" ");
            sb.append(sums[Integer.parseInt(rod[1])] - sums[Integer.parseInt(rod[0]) - 1]).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
