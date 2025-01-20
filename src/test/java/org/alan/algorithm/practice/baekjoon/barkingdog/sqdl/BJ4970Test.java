package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4970Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1", "0"),
                Arguments.of("2", "27"),
                Arguments.of("(P*Q)", "3"),
                Arguments.of("(--R+(P*Q))", "11"),
                Arguments.of("(P*-P)", "0"),
//                Arguments.of("(---P*--P*--P*----P)", "0"),
                Arguments.of("(P*-(P+-P))", "0"),
                Arguments.of("(P+-(P+-P))", "9"),
                Arguments.of("(-1+(((---P+Q)*(--Q+---R))*(-R+-P)))", "7"),
                Arguments.of("((1+((--2+-2)*-(((R*-1)+-(0*-2))+(-2*-2))))+(-((-P*R)+--2)+-(P+--R)))", "3"),
                Arguments.of("-(P*Q)", "15"),
                Arguments.of("(-((--2+(2*((-0+-0)+-R)))*-(-Q+0))*((-2+-P)*-((P+-Q)*(-0*2))))", "0"),
                Arguments.of("((-R*(R*1))+-(-Q*(((0*-(-0+-R))+(-(2*(Q*R))+(-0*(-1+-P))))*((R+-R)*-P))))", "15")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ4970().solve(input));
    }
}
