package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.bestalbum.BestAlbum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BestAlbumTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 3, 0}, new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int[] expected, String[] genres, int[] plays) {
        BestAlbum instance = new BestAlbum();
        Assertions.assertArrayEquals(expected, instance.solution(genres, plays));
    }
}
