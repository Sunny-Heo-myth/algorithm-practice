package org.alan.algorithm.practice.baekjoon.silver.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ1431Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        5
                        ABCD
                        145C
                        A
                        A910
                        Z321""", """
                        A
                        ABCD
                        Z321
                        145C
                        A910"""),
                Arguments.of("""
                        2
                        Z19
                        Z20""", """
                        Z20
                        Z19"""),
                Arguments.of("""
                        4
                        34H2BJS6N
                        PIM12MD7RCOLWW09
                        PYF1J14TF
                        FIPJOTEA5""", """
                        FIPJOTEA5
                        PYF1J14TF
                        34H2BJS6N
                        PIM12MD7RCOLWW09"""),
                Arguments.of("""
                        5
                        ABCDE
                        BCDEF
                        ABCDA
                        BAAAA
                        ACAAA""", """
                        ABCDA
                        ABCDE
                        ACAAA
                        BAAAA
                        BCDEF"""),
                Arguments.of("""
                        5
                        ABCDE1
                        BCDEF2
                        ABCDA3
                        BAAAA0
                        ACAAA0""", """
                        ACAAA0
                        BAAAA0
                        ABCDE1
                        BCDEF2
                        ABCDA3"""),
                Arguments.of("""
                        2
                        A123
                        123A""", """
                        123A
                        A123""")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ1431().solve(input));
    }
}
