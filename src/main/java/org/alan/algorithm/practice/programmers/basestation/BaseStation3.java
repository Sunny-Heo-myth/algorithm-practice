package org.alan.algorithm.practice.programmers.basestation;

public class BaseStation3 {
    public int solution(int n, int[] stations, int w) {
        int result = 0;
        int from = 1;
        int to;
        int coverage = 2 * w + 1;
        for (int station : stations) {
            to = station - w;
            if (from < to) {
                int distance = to - from;
                result += distance % coverage == 0 ? distance / coverage : distance / coverage + 1;
            }
            from = station + w + 1;
        }

        int distance = n + 1 - from;
        if (distance > 0) {
            result += distance % coverage == 0 ? distance / coverage : distance / coverage + 1;
        }

        return result;
    }
}
