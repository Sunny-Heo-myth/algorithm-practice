package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ21736Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 5\n" +
                        "OOOPO\n" +
                        "OIOOX\n" +
                        "OOOXP", "1"),
                Arguments.of("3 3\n" +
                        "IOX\n" +
                        "OXP\n" +
                        "XPP", "TT")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ21736().solve(input));
    }
}
