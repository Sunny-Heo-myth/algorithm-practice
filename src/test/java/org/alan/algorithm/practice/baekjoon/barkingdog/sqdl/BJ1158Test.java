package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1158Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 3", "<3, 6, 2, 7, 5, 1, 4>")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1158().solve(input));
    }
}
