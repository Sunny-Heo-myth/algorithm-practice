package org.alan.algorithm.practice.baekjoon.tagged.dp;

import java.util.StringTokenizer;

public class BJ1256 {
    public String solve(String input) {
        StringTokenizer st = new StringTokenizer(input);
        int a = Integer.parseInt(st.nextToken()), z = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken()), INF = (long) 1e18;
        long[][] memo = new long[a + 1][z + 1];

        for (int i = 0; i <= a; i++) for (int j = 0; j <= z; j++)
            memo[i][j] = (i == 0 || j == 0) ? 1 : Math.min(memo[i - 1][j] + memo[i][j - 1], INF);

        if (memo[a][z] < k) return "-1";

        StringBuilder sb = new StringBuilder();
        while (a > 0 || z > 0) {
            if (a == 0 || z == 0) {
                sb.append(a == 0 ? "z".repeat(z) : "a".repeat(a));
                break;
            }

            long count = memo[a - 1][z];
            if (k <= count) {
                sb.append("a");
                a--;
            } else {
                sb.append("z");
                k -= count;
                z--;
            }
        }
        return sb.toString();
    }
}
