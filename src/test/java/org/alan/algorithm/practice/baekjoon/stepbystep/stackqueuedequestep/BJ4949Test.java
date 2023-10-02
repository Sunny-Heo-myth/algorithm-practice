package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ4949Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("So when I die (the [first] I will see in (heaven) is a score list).", "yes"),
                Arguments.of("[ first in ] ( first out ).", "yes"),
                Arguments.of("Half Moon tonight (At least it is better than no Moon at all].", "no"),
                Arguments.of("A rope may form )( a trail in a maze.", "no"),
                Arguments.of("Help( I[m being held prisoner in a fortune cookie factory)].", "no"),
                Arguments.of("([ (([( [ ] ) ( ) (( ))] )) ]).", "yes"),
                Arguments.of(" .", "yes")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ4949 instance = new BJ4949();
        Assertions.assertEquals(expected, instance.solve2(input));
    }
}
