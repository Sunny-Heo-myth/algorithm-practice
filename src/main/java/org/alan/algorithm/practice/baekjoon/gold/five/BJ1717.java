package org.alan.algorithm.practice.baekjoon.gold.five;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ1717 {
    private int[] parentOf;

    public String solve(String input) {
        parentOf = IntStream.rangeClosed(0, Integer.parseInt(input.split("\n")[0].split(" ")[0])).toArray();
        int[][] ops = input.lines().skip(1).map(s -> Pattern.compile(" ").splitAsStream(s)
                        .mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);
        List<String> answer = new ArrayList<>();
        for (int[] op : ops)
            if (op[0] == 0) merge(op[1], op[2]);
            else if (find(op[1]) == find(op[2])) answer.add("YES");
            else answer.add("NO");
        return String.join("\n", answer);
    }

    private int find(int child) {
        int p = parentOf[child];
        if (p == child) return p;
        return parentOf[child] = find(p);
    }

    private void merge(int a, int b) {
        int p1 = find(a); int p2 = find(b);
        if (p1 != p2) parentOf[p1] = p2;
    }

}
