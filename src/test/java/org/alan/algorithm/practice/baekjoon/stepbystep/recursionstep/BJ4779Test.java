package org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4779Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("0", "-")
                , Arguments.of("1", "- -")
                , Arguments.of("3", "- -   - -         - -   - -")
                , Arguments.of("2", "- -   - -")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ4779 instance = new BJ4779();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
