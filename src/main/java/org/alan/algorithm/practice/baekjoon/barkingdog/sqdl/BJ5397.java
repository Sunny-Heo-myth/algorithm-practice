package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class BJ5397 {
    public String solve(String input) {
        List<Character> result = new LinkedList<>();
        ListIterator<Character> iterator = result.listIterator();
        for (char c : input.toCharArray()) {
            switch (c) {
                case '<': if (iterator.hasPrevious()) iterator.previous(); break;
                case '>': if (iterator.hasNext()) iterator.next(); break;
                case '-': if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                } break;
                default: iterator.add(c);
            }
        }
        return result.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
