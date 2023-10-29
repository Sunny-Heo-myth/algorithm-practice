package org.alan.algorithm.practice.baekjoon.level.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1918Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("A*B", "AB*"),
                Arguments.of("A*B/C*D", "AB*C/D*"),
                Arguments.of("A/B/C*D", "AB/C/D*"),
                Arguments.of("A+B", "AB+"),
                Arguments.of("A+B+C", "AB+C+"),
                Arguments.of("A+B+C-D", "AB+C+D-"),
                Arguments.of("A+B*C", "ABC*+"),
                Arguments.of("A*B+C/D", "AB*CD/+"),
                Arguments.of("A+B*C-D/E", "ABC*+DE/-"),
                Arguments.of("A+B*C-D/E+F*G", "ABC*+DE/-FG*+"),
                Arguments.of("A*(B+C)", "ABC+*")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1918 instance = new BJ1918();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
