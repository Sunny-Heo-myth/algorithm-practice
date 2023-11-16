package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5639Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("50\n" +
                        "30\n" +
                        "24\n" +
                        "5\n" +
                        "28\n" +
                        "45\n" +
                        "98\n" +
                        "52\n" +
                        "60", "5\n" +
                        "28\n" +
                        "24\n" +
                        "45\n" +
                        "30\n" +
                        "60\n" +
                        "52\n" +
                        "98\n" +
                        "50\n")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ5639 instance = new BJ5639();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
