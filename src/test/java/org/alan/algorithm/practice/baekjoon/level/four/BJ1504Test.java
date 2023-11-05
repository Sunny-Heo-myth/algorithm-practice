package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1504Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 6\n" +
                        "1 2 3\n" +
                        "2 3 3\n" +
                        "3 4 1\n" +
                        "1 3 5\n" +
                        "2 4 5\n" +
                        "1 4 4\n" +
                        "2 3", "7")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1504 instance = new BJ1504();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
