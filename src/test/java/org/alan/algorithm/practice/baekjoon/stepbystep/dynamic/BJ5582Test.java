package org.alan.algorithm.practice.baekjoon.stepbystep.dynamic;

import org.alan.algorithm.practice.baekjoon.stepbystep.string.BJ5582;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ5582Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("""
                        ABRACADABRA
                        ECADADABRBCRDARA""", "5"),
                Arguments.of("""
                        UPWJCIRUCAXIIRGL
                        SBQNYBSBZDFNEV""", "0")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ5582().solve(input));
    }
}
