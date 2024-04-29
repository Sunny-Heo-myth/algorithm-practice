package org.alan.algorithm.practice.baekjoon.silver.one;

import java.util.*;
import java.util.stream.Collectors;

public class BJ12852 {
    public String solve(String input) {
        int n = Integer.parseInt(input);
        int[] memo = new int[n + 1];
        int[] trace = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        memo[n] = 1;
        q.offer(n);

        while (!q.isEmpty()) {
            int poll = q.poll();

            if (poll == 1) {
                List<Integer> list = new ArrayList<>();
                while (trace[poll] != 0) {
                    list.add(poll);
                    poll = trace[poll];
                }
                list.add(n);
                return memo[1] - 1 + "\n" + list.stream().sorted(Comparator.reverseOrder())
                        .map(String::valueOf).collect(Collectors.joining(" "));
            }

            int div3 = poll / 3;
            if (poll % 3 == 0 && div3 > 0 && memo[div3] == 0) {
                memo[div3] = memo[poll] + 1;
                trace[div3] = poll;
                q.offer(div3);
            }

            int div2 = poll / 2;
            if (poll % 2 == 0 && div2 > 0 && memo[div2] == 0) {
                memo[div2] = memo[poll] + 1;
                trace[div2] = poll;
                q.offer(div2);
            }

            int m1 = poll - 1;
            if (m1 > 0 && memo[m1] == 0) {
                memo[m1] = memo[poll] + 1;
                trace[m1] = poll;
                q.offer(m1);
            }
        }

        return "-1";
    }
}
