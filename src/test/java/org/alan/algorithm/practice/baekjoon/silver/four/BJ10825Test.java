package org.alan.algorithm.practice.baekjoon.silver.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ10825Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        12
                        Junkyu 50 60 100
                        Sangkeun 80 60 50
                        Sunyoung 80 70 100
                        Soong 50 60 90
                        Haebin 50 60 100
                        Kangsoo 60 80 100
                        Donghyuk 80 60 100
                        Sei 70 70 70
                        Wonseob 70 70 90
                        Sanghyun 70 70 80
                        nsj 80 80 80
                        Taewhan 50 60 90""", """
                        Donghyuk
                        Sangkeun
                        Sunyoung
                        nsj
                        Wonseob
                        Sanghyun
                        Sei
                        Kangsoo
                        Haebin
                        Junkyu
                        Soong
                        Taewhan""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ10825().solve(input));
    }
}
