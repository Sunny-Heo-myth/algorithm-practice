package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ3425Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        DUP
                        MUL
                        NUM 2
                        ADD
                        END
                        3
                        1
                        10
                        50""", """
                        3
                        102
                        2502
                        """),
                Arguments.of("""
                        NUM 1
                        NUM 1
                        ADD
                        END
                        2
                        42
                        43""", """
                        ERROR
                        ERROR
                        """),
                Arguments.of("""
                        NUM 600000000
                        ADD
                        END
                        3
                        0
                        600000000
                        1""", """
                        600000000
                        ERROR
                        600000001
                        """),
                Arguments.of("""
                        POP
                        NUM 1
                        END
                        1
                        0""", """
                        1
                        """),
                Arguments.of("""
                        NUM 4
                        MOD
                        END
                        2
                        13
                        -13""", """
                        1
                        -1
                        """),
                Arguments.of("""
                        NUM -4
                        DIV
                        END
                        2
                        13
                        -13""", """
                        -3
                        3
                        """)
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ3425().solve(input));
    }
}
