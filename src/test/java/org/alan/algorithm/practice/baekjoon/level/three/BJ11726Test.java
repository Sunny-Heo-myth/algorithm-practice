package org.alan.algorithm.practice.baekjoon.level.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11726Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2", "2"),
                Arguments.of("9", "55")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11726 instance = new BJ11726();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
