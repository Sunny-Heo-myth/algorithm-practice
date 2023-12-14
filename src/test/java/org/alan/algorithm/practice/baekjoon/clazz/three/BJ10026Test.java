package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10026Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5\n" +
                        "RRRBB\n" +
                        "GGBBB\n" +
                        "BBBRR\n" +
                        "BBRRR\n" +
                        "RRRRR", "4 3")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ10026 instance = new BJ10026();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
