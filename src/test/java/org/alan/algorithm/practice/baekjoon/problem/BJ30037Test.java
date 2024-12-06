package org.alan.algorithm.practice.baekjoon.problem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ30037Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("I love gaji of Korean", "I love gaji of Korean"),
                Arguments.of("korea of Korea of Korea of Korea of Korea", "K-K-K-K-Korea"),
                Arguments.of("Korea of Korea of Korea. of Korea of Korea", "K-K-Korea. of K-Korea"),
                Arguments.of("Japan of Korea.", "K-Japan."),
                Arguments.of("Korea. of Korea.", "Korea. of Korea."),
                Arguments.of("Korea of korea.", "K-Of korea."),
                Arguments.of("Korea of Korea.", "K-Korea."),
                Arguments.of("Korea of", "K-Of"),
                Arguments.of("Artichoke in Korea Army uses Aheui.", "Artichoke in K-Army uses Aheui."),
                Arguments.of("Aheui, the best language of Korea.", "Aheui, the best K-Language."),
                Arguments.of("Korea is our country.", "K-Is our country."),
                Arguments.of("of Korea? Korea Korea Aheui of Korea.", "of Korea? K-K-K-Aheui."),
                Arguments.of("Language of, Korea Korea.", "Language of, K-Korea."),
                Arguments.of("Aheui has shown the greatness of Korea of Korea.", "Aheui has shown the K-K-Greatness."),
                Arguments.of("korea Korea! koRea Of Korea of Korea oF kORea.", "korea Korea! koRea Of K-Korea oF kORea.")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        Assertions.assertEquals(expected, new BJ30037().solve(input));
    }
}
