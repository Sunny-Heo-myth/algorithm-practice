package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1865Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2\n" +
                        "3 3 1\n" +
                        "1 2 2\n" +
                        "1 3 4\n" +
                        "2 3 1\n" +
                        "3 1 3\n" +
                        "3 2 1\n" +
                        "1 2 3\n" +
                        "2 3 4\n" +
                        "3 1 8", "NO\n" +
                        "YES")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1865 instance = new BJ1865();
    }
}
