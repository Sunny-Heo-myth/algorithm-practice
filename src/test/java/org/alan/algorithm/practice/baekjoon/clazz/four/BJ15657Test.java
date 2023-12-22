package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ15657Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3 1\n" +
                        "4 5 2",
                        "2\n" +
                        "4\n" +
                        "5"),
                Arguments.of("4 2\n" +
                        "9 8 7 1",
                        "1 1\n" +
                                "1 7\n" +
                                "1 8\n" +
                                "1 9\n" +
                                "7 7\n" +
                                "7 8\n" +
                                "7 9\n" +
                                "8 8\n" +
                                "8 9\n" +
                                "9 9"),
                Arguments.of("4 4\n" +
                        "1231 1232 1233 1234",
                        "1231 1231 1231 1231\n" +
                                "1231 1231 1231 1232\n" +
                                "1231 1231 1231 1233\n" +
                                "1231 1231 1231 1234\n" +
                                "1231 1231 1232 1232\n" +
                                "1231 1231 1232 1233\n" +
                                "1231 1231 1232 1234\n" +
                                "1231 1231 1233 1233\n" +
                                "1231 1231 1233 1234\n" +
                                "1231 1231 1234 1234\n" +
                                "1231 1232 1232 1232\n" +
                                "1231 1232 1232 1233\n" +
                                "1231 1232 1232 1234\n" +
                                "1231 1232 1233 1233\n" +
                                "1231 1232 1233 1234\n" +
                                "1231 1232 1234 1234\n" +
                                "1231 1233 1233 1233\n" +
                                "1231 1233 1233 1234\n" +
                                "1231 1233 1234 1234\n" +
                                "1231 1234 1234 1234\n" +
                                "1232 1232 1232 1232\n" +
                                "1232 1232 1232 1233\n" +
                                "1232 1232 1232 1234\n" +
                                "1232 1232 1233 1233\n" +
                                "1232 1232 1233 1234\n" +
                                "1232 1232 1234 1234\n" +
                                "1232 1233 1233 1233\n" +
                                "1232 1233 1233 1234\n" +
                                "1232 1233 1234 1234\n" +
                                "1232 1234 1234 1234\n" +
                                "1233 1233 1233 1233\n" +
                                "1233 1233 1233 1234\n" +
                                "1233 1233 1234 1234\n" +
                                "1233 1234 1234 1234\n" +
                                "1234 1234 1234 1234")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ15657().solve(input));
    }
}
