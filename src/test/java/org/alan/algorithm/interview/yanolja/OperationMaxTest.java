package org.alan.algorithm.interview.yanolja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class OperationMaxTest {

    static Stream<Arguments> test_cases() {
        return Stream.of(
                Arguments.of("1+1", "2"),
                Arguments.of("1-1", "0"),
                Arguments.of("1x1", "1"),
                Arguments.of("1-1x2", "0"),
                Arguments.of("1-1-2", "2"),
                Arguments.of("2-1x2x5", "10"),
                Arguments.of("2-1x2x5-3", "7"),
                Arguments.of("2-1x2+5+3", "10"),
                Arguments.of("2+1x2+5+3", "14"),
                Arguments.of("2+2x1+5+3", "20")
        );
    }

    @ParameterizedTest
    @MethodSource("test_cases")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new OperationMax().solution(input));
    }

}