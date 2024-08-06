package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ26069Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("12\n" +
                        "bnb2011 chansol\n" +
                        "chansol chogahui05\n" +
                        "chogahui05 jthis\n" +
                        "jthis ChongChong\n" +
                        "jthis jyheo98\n" +
                        "jyheo98 lms0806\n" +
                        "lms0806 pichulia\n" +
                        "pichulia pjshwa\n" +
                        "pjshwa r4pidstart\n" +
                        "r4pidstart swoon\n" +
                        "swoon tony9402\n" +
                        "tony9402 bnb2011", "10")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ26069 instance = new BJ26069();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
