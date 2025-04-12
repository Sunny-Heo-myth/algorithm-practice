package org.alan.algorithm.practice.baekjoon.tagged.bfsdfs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

public class BJ1525 {
    private final int init;
    private final int[] d = {1, -1, 3, -3};

    public BJ1525(String input) {
        init = Integer.parseInt("1" + input.lines().map(s ->
                        String.join("", s.split(" "))).collect(Collectors.joining()));
    }

    public String solve() {
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        map.put(init, 0);
        queue.offer(init);
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            if (poll == 1123456780) return String.valueOf(map.get(poll));

            String str = String.valueOf(poll).substring(1);
            int zero = str.indexOf('0');
            for (int i = 0; i < 4; i++) {
                int next0 = zero + d[i];
                if (next0 < 0 || next0 > 8) continue;

                char[] chars = str.toCharArray();
                char n = chars[next0];
                chars[next0] = '0';
                chars[zero] = n;
                int next = Integer.parseInt("1" + String.valueOf(chars));
                if (map.containsKey(next)) continue;

                map.put(next, map.get(poll) + 1);
                queue.offer(next);
            }
        }
        return "-1";
    }

}
