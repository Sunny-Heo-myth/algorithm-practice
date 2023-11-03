package org.alan.algorithm.practice.baekjoon.level.two;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BJ18110 {
    public String solve(String input) {
        if (input.equals("0")) return "0";

        List<Integer> list = new ArrayList<>();
        String[] ss = input.split("\n");
        for (int i = 1; i < ss.length; i++) list.add(Integer.parseInt(ss[i]));
        list = list.stream().sorted().collect(Collectors.toList());

        int sum = 0;
        int cut = (int) Math.round(list.size() * 0.15);
        for (int i = cut; i < list.size() - cut; i++) sum += list.get(i);
        return String.valueOf(Math.round(sum / (float) list.size() - cut * 2));
    }
}
