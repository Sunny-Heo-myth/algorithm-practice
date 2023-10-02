package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.two;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.two.BJ20920;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

public class BJ20920Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("7 4\n" +
                        "apple\n" +
                        "ant\n" +
                        "sand\n" +
                        "apple\n" +
                        "append\n" +
                        "sand\n" +
                        "sand", "sand\n" +
                        "apple\n" +
                        "append"),
                Arguments.of("12 5\n" +
                        "appearance\n" +
                        "append\n" +
                        "attendance\n" +
                        "swim\n" +
                        "swift\n" +
                        "swift\n" +
                        "swift\n" +
                        "mouse\n" +
                        "wallet\n" +
                        "mouse\n" +
                        "ice\n" +
                        "age", "swift\n" +
                        "mouse\n" +
                        "appearance\n" +
                        "attendance\n" +
                        "append\n" +
                        "wallet")
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) throws IOException {
        BJ20920 instance = new BJ20920();
        Assertions.assertEquals(expected, instance.solve());
    }
}
