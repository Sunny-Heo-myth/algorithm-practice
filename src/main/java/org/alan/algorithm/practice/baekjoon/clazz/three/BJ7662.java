package org.alan.algorithm.practice.baekjoon.clazz.three;

import java.util.TreeMap;
import java.util.regex.Pattern;

public class BJ7662 {
    public String solve(String input) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        Pattern.compile("\n").splitAsStream(input).skip(1).map(String::valueOf).forEach(s -> {
            String[] ss = s.split(" ");
            int i = Integer.parseInt(ss[1]);
            switch (ss[0]) {
                case "I":
                    treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);
                    break;
                case "D":
                    if (treeMap.isEmpty()) break;
                    int key = i == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    Integer value = treeMap.put(key, treeMap.get(key) - 1);
                    if (value != null && value == 1) treeMap.remove(key);
                    break;
            }
        });

        if (treeMap.isEmpty()) return "EMPTY";
        else return treeMap.lastKey() + " " + treeMap.firstKey();
    }
}