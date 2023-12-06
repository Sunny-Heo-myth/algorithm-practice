package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1753Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 6\n" +
                        "1\n" +
                        "5 1 1\n" +
                        "1 2 2\n" +
                        "1 3 3\n" +
                        "2 3 4\n" +
                        "2 4 5\n" +
                        "3 4 6", "0\n" +
                        "2\n" +
                        "3\n" +
                        "7\n" +
                        "INF")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1753 instance = new BJ1753();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
