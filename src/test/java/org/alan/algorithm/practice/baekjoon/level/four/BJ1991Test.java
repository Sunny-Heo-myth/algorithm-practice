package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1991Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7\n" +
                        "A B C\n" +
                        "B D .\n" +
                        "C E F\n" +
                        "E . .\n" +
                        "F . G\n" +
                        "D . .\n" +
                        "G . .",
                        "ABDCEFG\n" +
                        "DBAECFG\n" +
                        "DBEGFCA")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1991 instance = new BJ1991();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
