package org.alan.algorithm.practice.baekjoon.stepbystep.combinatoric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ11050Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("5 2", "10")
                , Arguments.of("10 3", "120")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ11050 instance = new BJ11050();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
