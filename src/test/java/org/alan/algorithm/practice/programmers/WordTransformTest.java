package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.wordtransform.WordTransform;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordTransformTest {

    @Test
    public void test1() {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int expected = 4;
        WordTransform instance = new WordTransform();
        Assertions.assertEquals(expected, instance.solution(begin, target, words));
    }
}
