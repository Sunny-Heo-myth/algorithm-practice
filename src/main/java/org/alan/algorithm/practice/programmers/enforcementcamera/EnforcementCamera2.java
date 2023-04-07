package org.alan.algorithm.practice.programmers.enforcementcamera;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera2 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(ints -> ints[1]));
        int answer = 0;
        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }

        return answer;
    }
}
