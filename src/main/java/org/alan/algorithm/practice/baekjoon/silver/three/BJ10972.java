package org.alan.algorithm.practice.baekjoon.silver.three;

import java.util.List;
import java.util.OptionalInt;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BJ10972 {
    public String solve(String input) {
        List<Integer> intList = Pattern.compile(" ").splitAsStream(input.split("\n")[1])
                .map(Integer::parseInt).collect(Collectors.toList());

        OptionalInt optionalInt = IntStream.iterate(intList.size() - 1, i -> i > 0, i -> i - 1)
                .filter(i -> intList.get(i) > intList.get(i - 1)).findFirst();

        if (optionalInt.isEmpty()) return "-1";
        int nonAscendingIdx = optionalInt.getAsInt() - 1;

        int firstBiggerIdx = IntStream.iterate(intList.size() - 1, i -> i >= 0, i -> i - 1)
                .filter(i -> intList.get(nonAscendingIdx) < intList.get(i)).findFirst().orElseThrow(RuntimeException::new);

        intList.add(nonAscendingIdx, intList.remove(firstBiggerIdx));

        return Stream.concat(
                intList.subList(0, nonAscendingIdx + 1).stream(),
                intList.subList(nonAscendingIdx + 1, intList.size()).stream().sorted()
        ).map(String::valueOf).collect(Collectors.joining(" "));
    }
}
