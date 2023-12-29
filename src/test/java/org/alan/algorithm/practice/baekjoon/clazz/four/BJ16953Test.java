package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16953Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 162", "5"),
                Arguments.of("4 42", "-1"),
                Arguments.of("100 40021", "5"),
                Arguments.of("600000000 1000000000", "1")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16953().solve(input));
    }
}
