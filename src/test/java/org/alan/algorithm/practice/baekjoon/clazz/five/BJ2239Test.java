package org.alan.algorithm.practice.baekjoon.clazz.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2239Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        103000509
                        002109400
                        000704000
                        300502006
                        060000050
                        700803004
                        000401000
                        009205800
                        804000107""", """
                        143628579
                        572139468
                        986754231
                        391542786
                        468917352
                        725863914
                        237481695
                        619275843
                        854396127""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ2239().solve(input));
    }
}
