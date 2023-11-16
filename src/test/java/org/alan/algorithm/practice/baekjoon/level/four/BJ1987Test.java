package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1987Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 4\n" +
                        "CAAB\n" +
                        "ADCB", "3"),
                Arguments.of("3 6\n" +
                        "HFDFFB\n" +
                        "AJHGDH\n" +
                        "DGAGEH", "6"),
                Arguments.of("5 5\n" +
                        "IEFCJ\n" +
                        "FHFKC\n" +
                        "FFALF\n" +
                        "HFGCF\n" +
                        "HMCHH", "10")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1987 instance = new BJ1987();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
