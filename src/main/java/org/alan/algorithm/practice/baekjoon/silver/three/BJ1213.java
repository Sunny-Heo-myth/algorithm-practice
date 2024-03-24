package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BJ1213 {

    // todo: wrong!
    public String solve(String input) {
        Map<String, Long> countMap = input.chars().mapToObj(i -> String.valueOf((char) i)).sorted()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        boolean isOddExist = false;
        String oddKey = "";
        for (Map.Entry<String, Long> entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                entry.setValue(entry.getValue() / 2);
                continue;
            }

            if (isOddExist) return "I'm Sorry Hansoo";

            isOddExist = true;
            entry.setValue(entry.getValue() / 2);
            oddKey = entry.getKey();
        }

        String half = countMap.entrySet().stream()
                .map(e -> e.getKey().repeat(Integer.parseInt(String.valueOf(e.getValue())))).collect(Collectors.joining());

        return half + oddKey + new StringBuilder(half).reverse();
    }

    public String solve2(String input) {
        int[] charCountArray = new int[26]; // naturally sorted by ASCII order

        for (char ch : input.toCharArray()) {
            charCountArray[ch - 'A']++;
        }

        StringBuilder half = new StringBuilder();
        boolean isOddExist = false;
        Character oddChar = null;
        for (int i = 0; i < charCountArray.length; i++) {
            if (charCountArray[i] % 2 == 0) {
                half.append(String.valueOf((char) (i + 'A')).repeat(charCountArray[i] / 2));
                continue;
            }

            if (isOddExist) return "I'm Sorry Hansoo";

            isOddExist = true;
            half.append(String.valueOf((char) (i + 'A')).repeat(charCountArray[i] / 2));
            oddChar = (char) (i + 'A');
        }

        String halfString = half.toString();
        return oddChar == null ? halfString + half.reverse() : halfString + oddChar + half.reverse();
    }
}
