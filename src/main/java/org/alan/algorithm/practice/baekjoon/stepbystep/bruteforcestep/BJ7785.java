package org.alan.algorithm.practice.baekjoon.stepbystep.bruteforcestep;

import java.util.*;

public class BJ7785 {
    public String solve(String input) {
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);

        Map<String, Boolean> nameBooleanMap = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {   // O(n)
            String[] line = s[i].split(" ");
            String key = line[0];
            boolean bool = Objects.equals("enter", line[1]);
            if (nameBooleanMap.containsKey(key)) {
                nameBooleanMap.put(key, bool);
            } else {
                nameBooleanMap.putIfAbsent(key, bool);
            }
        }

        List<String> list = new ArrayList<>();
        nameBooleanMap.keySet().stream().filter(nameBooleanMap::get).forEach(list::add);

        StringBuilder sb = new StringBuilder();
        list.stream().sorted(Comparator.reverseOrder()).forEach(ss -> sb.append(ss).append("\n"));  // O(nlogn)

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
