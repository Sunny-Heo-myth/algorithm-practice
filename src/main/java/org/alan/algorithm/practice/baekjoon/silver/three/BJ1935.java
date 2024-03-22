package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1935 {
    private final Map<String, Double> map = new HashMap<>();
    private List<String> stringList;

    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";

    public String solve(String input) {
        stringList = input.split("\n")[1].chars().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.toList());

        Iterator<Double> doubleIterator = Pattern.compile("\n").splitAsStream(input).skip(2).mapToDouble(Double::parseDouble).iterator();
        stringList.stream().filter(s -> !isOperator(s)).distinct().forEach(s -> map.put(s, doubleIterator.next()));

        stringList = stringList.stream().map(s -> map.containsKey(s) ? String.valueOf(map.get(s)) : s).collect(Collectors.toList());

        while (stringList.size() > 1) {
            int firstOpIdx = IntStream.range(0, stringList.size()).filter(i -> isOperator(stringList.get(i))).findFirst().orElse(-1);
            double midResult = operate(firstOpIdx);
            stringList.remove(firstOpIdx - 2);
            stringList.remove(firstOpIdx - 2);
            stringList.remove(firstOpIdx - 2);
            stringList.add(firstOpIdx - 2, String.valueOf(midResult));
        }

        return String.format("%.2f", Double.parseDouble(stringList.get(0)));
    }

    private double operate(int idx) {
        final double n1 = Double.parseDouble(stringList.get(idx - 2));
        final double n2 = Double.parseDouble(stringList.get(idx - 1));
        return switch (stringList.get(idx)) {
            case PLUS -> n1 + n2;
            case MINUS -> n1 - n2;
            case MULTIPLY -> n1 * n2;
            case DIVIDE -> n1 / n2;
            default -> throw new RuntimeException();
        };
    }

    private boolean isOperator(String s) {
        return Objects.equals(s, PLUS) || Objects.equals(s, MINUS) || Objects.equals(s, MULTIPLY) || Objects.equals(s, DIVIDE);
    }

}
