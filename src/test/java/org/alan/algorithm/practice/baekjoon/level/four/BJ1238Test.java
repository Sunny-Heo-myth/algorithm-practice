package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1238Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4 8 2\n" +
                        "1 2 4\n" +
                        "1 3 2\n" +
                        "1 4 7\n" +
                        "2 1 1\n" +
                        "2 3 5\n" +
                        "3 1 2\n" +
                        "3 4 4\n" +
                        "4 2 3", "10")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1238 instance = new BJ1238();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
