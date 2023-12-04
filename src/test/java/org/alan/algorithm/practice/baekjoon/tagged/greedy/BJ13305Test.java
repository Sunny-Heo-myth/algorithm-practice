package org.alan.algorithm.practice.baekjoon.tagged.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ13305Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("4\n" +
                        "2 3 1\n" +
                        "5 2 4 1", "18"),
                Arguments.of("4\n" +
                        "3 3 4\n" +
                        "1 1 1 1", "10"),
                Arguments.of("")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ13305 instance = new BJ13305();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
