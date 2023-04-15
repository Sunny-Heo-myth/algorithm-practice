package org.alan.algorithm.practice.programmers.gemshopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class GemShoppingTest {
    
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{3,7}, new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}),
                Arguments.of(new int[]{1,3}, new String[]{"AA", "AB", "AC", "AA", "AC"}),
                Arguments.of(new int[]{1,1}, new String[]{"XYZ", "XYZ", "XYZ"}),
                Arguments.of(new int[]{1,5}, new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"})
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int[] expected, String[] input) {
        GemShopping instance = new GemShopping();
        Assertions.assertArrayEquals(expected, instance.solution(input));
    }
}
