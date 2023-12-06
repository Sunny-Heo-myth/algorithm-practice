package org.alan.algorithm.practice.baekjoon.clazz.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ17219Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("16 4\n" +
                        "noj.am IU\n" +
                        "acmicpc.net UAENA\n" +
                        "startlink.io THEKINGOD\n" +
                        "google.com ZEZE\n" +
                        "nate.com VOICEMAIL\n" +
                        "naver.com REDQUEEN\n" +
                        "daum.net MODERNTIMES\n" +
                        "utube.com BLACKOUT\n" +
                        "zum.com LASTFANTASY\n" +
                        "dreamwiz.com RAINDROP\n" +
                        "hanyang.ac.kr SOMEDAY\n" +
                        "dhlottery.co.kr BOO\n" +
                        "duksoo.hs.kr HAVANA\n" +
                        "hanyang-u.ms.kr OBLIVIATE\n" +
                        "yd.es.kr LOVEATTACK\n" +
                        "mcc.hanyang.ac.kr ADREAMER\n" +
                        "startlink.io\n" +
                        "acmicpc.net\n" +
                        "noj.am\n" +
                        "mcc.hanyang.ac.kr", "THEKINGOD\n" +
                        "UAENA\n" +
                        "IU\n" +
                        "ADREAMER")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ17219 instance = new BJ17219();
        Assertions.assertEquals(expected, instance.solve(input));
    }
}
