package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class BJ9375 {
    public String solve(String input) {
        Map<String, Integer> map = new HashMap<>();
        Pattern.compile("\n").splitAsStream(input).skip(1).forEach(s -> {
            String ss = s.split(" ")[1];
            if (map.containsKey(ss)) map.put(ss, map.get(ss) + 1);
            else map.put(ss, 2);
        });
        return String.valueOf(map.values().stream().reduce(1, (a, b) -> a * b) - 1);
    }
}
