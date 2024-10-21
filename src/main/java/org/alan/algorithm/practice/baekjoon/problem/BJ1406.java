package org.alan.algorithm.practice.baekjoon.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class BJ1406 {

    public String solve(String input) {
        List<Character> document = input.split("\n")[0].chars()
                .mapToObj(i -> (char) i).collect(Collectors.toCollection(LinkedList::new));
        ListIterator<Character> iterator = document.listIterator(document.size());

        input.lines().skip(2).forEach(line -> {
            switch (line) {
                case "L":
                    if (iterator.hasPrevious()) iterator.previous();
                    break;
                case "D":
                    if (iterator.hasNext()) iterator.next();
                    break;
                case "B":
                    if (!iterator.hasPrevious()) break;
                    iterator.previous();
                    iterator.remove();
                    break;
                default:
                    iterator.add(line.split(" ")[1].charAt(0));
            }
        });
        return document.stream().map(String::valueOf).collect(Collectors.joining());
    }

}
