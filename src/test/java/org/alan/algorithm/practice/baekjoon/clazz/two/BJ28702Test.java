package org.alan.algorithm.practice.baekjoon.clazz.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ28702Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        Fizz
                        Buzz
                        11""", "Fizz"),
                Arguments.of("""
                        980803
                        980804
                        FizzBuzz""", "980806")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ28702().solve(input));
    }
}
