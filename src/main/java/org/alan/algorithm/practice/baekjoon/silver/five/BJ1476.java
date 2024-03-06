package org.alan.algorithm.practice.baekjoon.silver.five;

import java.util.StringTokenizer;

public class BJ1476 {

    public String solve(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int E = 1;
        int S = 1;
        int M = 1;

        int year = 1;
        while (!(e == E && s == S && m == M)) {
            E++; S++; M++;
            if (E == 16) E = 1;
            if (S == 29) S = 1;
            if (M == 20) M = 1;
            year++;
        }
        return String.valueOf(year);
    }
}
