package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2740Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 2\n" +
                        "1 2\n" +
                        "3 4\n" +
                        "5 6\n" +
                        "2 3\n" +
                        "-1 -2 0\n" +
                        "0 0 3",
                        "-1 -2 6\n" +
                        "-3 -6 12\n" +
                        "-5 -10 18")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2740 instance = new BJ2740();
//        Assertions.assertEquals(expected, instance.solve(input));
    }
}
