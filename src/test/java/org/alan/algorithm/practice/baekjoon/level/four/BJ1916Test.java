package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1916Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "8\n" +
                        "1 2 2\n" +
                        "1 3 3\n" +
                        "1 4 1\n" +
                        "1 5 10\n" +
                        "2 4 2\n" +
                        "3 4 1\n" +
                        "3 5 1\n" +
                        "4 5 3\n" +
                        "1 5", "4")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1916 instance = new BJ1916();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
