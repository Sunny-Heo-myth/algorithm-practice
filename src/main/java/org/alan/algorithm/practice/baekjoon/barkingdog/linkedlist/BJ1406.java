package org.alan.algorithm.practice.baekjoon.barkingdog.linkedlist;

import java.util.*;
import java.util.stream.Collectors;

public class BJ1406 {

    public String solve(String input) {
        String[] lines = input.split("\n");
        List<Character> document = lines[0].chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toCollection(LinkedList::new));
        ListIterator<Character> iterator = document.listIterator(document.size());

        Arrays.stream(lines).skip(2).forEach(s -> {
            switch (s) {
                case "L": if (iterator.hasPrevious()) iterator.previous(); break;
                case "D": if (iterator.hasNext()) iterator.next(); break;
                case "B": if (iterator.hasPrevious()) {
                    iterator.previous();
                    iterator.remove();
                }  break;
                default: iterator.add(s.split(" ")[1].charAt(0));
            }
        });
        return document.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
