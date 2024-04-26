package org.alan.algorithm.practice.baekjoon.silver.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5014Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 1 10 2 1", "6"),
                Arguments.of("100 2 1 1 0", "use the stairs")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ5014().solve(input));
    }
}
