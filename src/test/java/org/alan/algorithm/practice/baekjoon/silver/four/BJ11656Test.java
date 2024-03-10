package org.alan.algorithm.practice.baekjoon.silver.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11656Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("baekjoon", """
                        aekjoon
                        baekjoon
                        ekjoon
                        joon
                        kjoon
                        n
                        on
                        oon""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ11656().solve(input));
    }
}
