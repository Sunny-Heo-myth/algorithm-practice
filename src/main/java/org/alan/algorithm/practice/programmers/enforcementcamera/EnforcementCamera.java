package org.alan.algorithm.practice.programmers.enforcementcamera;

import java.util.Arrays;
import java.util.Comparator;

public class EnforcementCamera {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

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
