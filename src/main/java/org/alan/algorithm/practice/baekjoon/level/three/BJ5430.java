package org.alan.algorithm.practice.baekjoon.level.three;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ5430 {
    public String solve(String input) {
        String[] s = input.split("\n");
        char[] operations = s[0].toCharArray();

        if (Objects.equals(s[1], "0")) {
            for (char ch :operations) if (ch == 'D') return "error";    // O(size of operations)
            return "[]";
        }

        List<Integer> ints = Pattern.compile(",").splitAsStream(s[2].substring(1, s[2].length() - 1))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());

        int from = 0;
        int to = ints.size();
        boolean reversed = false;
        for (char operation : operations) switch (operation) {  // O(size of operations)
            case 'R': reversed = !reversed; break;
            case 'D':
                if (to - from == 0) return "error";
                if (reversed) to--;
                else from++;
                break;
        }

        List<Integer> cut = ints.subList(from, to);
        if (reversed) Collections.reverse(cut);  // O(size of cut)
        return "[" + cut.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";  // O(size of cut)
    }
}
