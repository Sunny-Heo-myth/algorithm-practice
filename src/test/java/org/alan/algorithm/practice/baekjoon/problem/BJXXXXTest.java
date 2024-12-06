package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJXXXXTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        """, ""),
                Arguments.of("""
                        """, ""),
                Arguments.of("""
                        """, ""),
                Arguments.of("""
                        """, ""),
                Arguments.of("""
                        """, "")
        );
    }

//    static Stream<Arguments> parameters() {
//        return Stream.of(
//                Arguments.of("", ""),
//                Arguments.of("", ""),
//                Arguments.of("", ""),
//                Arguments.of("", ""),
//                Arguments.of("", "")
//        );
//    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
//        Assertions.assertEquals(expected, new BJXXXXTest().solve(input));
    }
}
