package org.alan.algorithm.practice.baekjoon.level.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1850Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 4", "1")
                , Arguments.of("3 6", "111")
                , Arguments.of("500000000000000000 500000000000000002", "11")
                , Arguments.of("4 12", "1111")
                , Arguments.of("8 12", "1111")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1850 instance = new BJ1850();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
