package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4882Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("((F(TF))(TF))", "1. false"),
                Arguments.of("(TFT)", "2. false"),
                Arguments.of("((TFT)T)", "3. true"),
                Arguments.of("(TTTT)", "4. true"),
                Arguments.of("((TTT)(FT))", "5. true"),
                Arguments.of("((F(TFT)(TF))(TFF)T)", "6. false")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ4882().solve(input));
    }
}
