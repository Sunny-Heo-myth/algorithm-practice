package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2609Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("24 18", "6\n" +
                        "72")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2609 instance = new BJ2609();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
