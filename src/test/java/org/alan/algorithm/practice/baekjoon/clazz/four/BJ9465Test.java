package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ9465Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1\n" +
                                "50\n" +
                                "30\n",
                        "50"),
                Arguments.of("2\n" +
                                "50 10\n" +
                                "30 50\n",
                        "100"),
                Arguments.of("3\n" +
                                "10 30 10\n" +
                                "20 40 30",
                        "80"),
                Arguments.of("5\n" +
                                "50 10 100 20 40\n" +
                                "30 50 70 10 60\n",
                        "260"),
                Arguments.of("7\n" +
                                "10 30 10 50 100 20 40\n" +
                                "20 40 30 50 60 20 80",
                        "290")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ9465 instance = new BJ9465();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
