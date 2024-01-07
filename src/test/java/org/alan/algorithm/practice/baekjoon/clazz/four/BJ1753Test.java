package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1753Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5 6
                        1
                        5 1 1
                        1 2 2
                        1 3 3
                        2 3 4
                        2 4 5
                        3 4 6""", """
                        0
                        2
                        3
                        7
                        INF""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1753 instance = new BJ1753();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
