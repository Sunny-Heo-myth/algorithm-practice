package org.alan.algorithm.practice.baekjoon.stepbystep.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1010Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("2 2", "1")
                , Arguments.of( "1 5", "5")
                , Arguments.of("13 29", "67863915")
                , Arguments.of("3 6", "20")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ1010 instance = new BJ1010();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
