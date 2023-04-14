package org.alan.algorithm.practice.programmers.basestation;

import java.util.Arrays;

public class BaseStation {
    private boolean[] apartments;

    public int solution(int n, int[] stations, int w) {
        apartments = new boolean[n + 2];
        apartments[0] = true;
        apartments[apartments.length - 1] = true;
        buildInitialStation(stations, w);
        return fillRest(w);
    }

    private void buildInitialStation(int[] stations, int w) {
        for (int station : stations) {
            Arrays.fill(apartments, Math.max(1, station - w), Math.min(apartments.length, station + w + 1), true);
        }
    }

    private int fillRest(int w) {
        int result = 0;
        int fromIdx = 0;
        int toIdx;
        for (int i = 1; i < apartments.length; i++) {
            if (!apartments[i] && apartments[i - 1]) {
                fromIdx = i;
            }
            if (apartments[i] && !apartments[i - 1]) {
                toIdx = i;
                int distance = toIdx - fromIdx;
                int coverage = 2 * w + 1;
                int quotient = distance / coverage;
                result += distance % coverage == 0 ? quotient : quotient + 1;
            }
        }
        return result;
    }
}
