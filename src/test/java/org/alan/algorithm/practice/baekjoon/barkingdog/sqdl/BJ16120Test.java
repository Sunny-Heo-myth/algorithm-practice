package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ16120Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("P", "PPAP"),
                Arguments.of("PPAAPP", "NP"),
                Arguments.of("PPAPP", "NP"),
                Arguments.of("PPAP", "PPAP"),
                Arguments.of("PPPAPAP", "PPAP"),
                Arguments.of("PPAPAPP", "NP"),
                Arguments.of("PPAPPPAP", "NP"),
                Arguments.of("PPAPPAP", "PPAP"),
                Arguments.of("PPPPAPPAPPAPAPPAPAP", "PPAP")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ16120().solve(input));
    }
}
