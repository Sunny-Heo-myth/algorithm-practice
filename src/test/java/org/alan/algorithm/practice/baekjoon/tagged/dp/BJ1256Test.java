package org.alan.algorithm.practice.baekjoon.tagged.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1256Test {
    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("1 1 1", "az"),
                Arguments.of("1 1 2", "za"),
                Arguments.of("1 1 3", "-1"),
                Arguments.of("2 2 2", "azaz"),
                Arguments.of("2 2 6", "zzaa"),
                Arguments.of("10 10 1000000000", "-1"),
                Arguments.of("7 4 47", "aaazazaazaz")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1256().solve(input));
    }
}
