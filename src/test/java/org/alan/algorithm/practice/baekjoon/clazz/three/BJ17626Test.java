package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17626Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("25", "1"),
                Arguments.of("26", "2"),
                Arguments.of("11339", "3"),
                Arguments.of("34567", "4")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ17626 instance = new BJ17626();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
