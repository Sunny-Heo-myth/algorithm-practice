package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1072Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("10 8", "1"),
                Arguments.of("100 80", "6"),
                Arguments.of("47 47", "-1"),
                Arguments.of("99000 0", "1000"),
                Arguments.of("1000000000 470000000", "19230770")

        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1072().solve(input));
    }


}
