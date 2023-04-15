package org.alan.algorithm.practice.programmers.collectsticker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CollectStickerTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(36, new int[]{14,6,5,11,3,9,2,10}),
                Arguments.of(8,  new int[]{1,3,2,5,4}),
                Arguments.of(4,  new int[]{1,1,1,1,1,1,1,1,1}),
                Arguments.of(8,  new int[]{1,2,1,2,1,2,1,2,1})
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, int[] sticker) {
        CollectSticker instance = new CollectSticker();
        Assertions.assertEquals(expected, instance.solution(sticker));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int expected, int[] sticker) {
        CollectSticker2 instance = new CollectSticker2();
        Assertions.assertEquals(expected, instance.solution(sticker));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(int expected, int[] sticker) {
        CollectSticker3 instance = new CollectSticker3();
        Assertions.assertEquals(expected, instance.solution(sticker));
    }

}
