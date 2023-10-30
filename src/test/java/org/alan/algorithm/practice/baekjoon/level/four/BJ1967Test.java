package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1967Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("12\n" +
                        "1 2 3\n" +
                        "1 3 2\n" +
                        "2 4 5\n" +
                        "3 5 11\n" +
                        "3 6 9\n" +
                        "4 7 1\n" +
                        "4 8 7\n" +
                        "5 9 15\n" +
                        "5 10 4\n" +
                        "6 11 6\n" +
                        "6 12 10", "45")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1967 instance = new BJ1967();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
