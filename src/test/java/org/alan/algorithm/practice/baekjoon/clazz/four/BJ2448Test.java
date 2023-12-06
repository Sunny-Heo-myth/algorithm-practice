package org.alan.algorithm.practice.baekjoon.clazz.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class BJ2448Test {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("3",
                                "  *  \n" +
                                " * * \n" +
                                "*****"),
                Arguments.of("12",
                                "           *           \n" +
                                "          * *          \n" +
                                "         *****         \n" +
                                "        *     *        \n" +
                                "       * *   * *       \n" +
                                "      ***** *****      \n" +
                                "     *           *     \n" +
                                "    * *         * *    \n" +
                                "   *****       *****   \n" +
                                "  *     *     *     *  \n" +
                                " * *   * *   * *   * * \n" +
                                "***** ***** ***** *****"),
                Arguments.of("24",
                                "                       *                       \n" +
                                "                      * *                      \n" +
                                "                     *****                     \n" +
                                "                    *     *                    \n" +
                                "                   * *   * *                   \n" +
                                "                  ***** *****                  \n" +
                                "                 *           *                 \n" +
                                "                * *         * *                \n" +
                                "               *****       *****               \n" +
                                "              *     *     *     *              \n" +
                                "             * *   * *   * *   * *             \n" +
                                "            ***** ***** ***** *****            \n" +
                                "           *                       *           \n" +
                                "          * *                     * *          \n" +
                                "         *****                   *****         \n" +
                                "        *     *                 *     *        \n" +
                                "       * *   * *               * *   * *       \n" +
                                "      ***** *****             ***** *****      \n" +
                                "     *           *           *           *     \n" +
                                "    * *         * *         * *         * *    \n" +
                                "   *****       *****       *****       *****   \n" +
                                "  *     *     *     *     *     *     *     *  \n" +
                                " * *   * *   * *   * *   * *   * *   * *   * * \n" +
                                "***** ***** ***** ***** ***** ***** ***** *****")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(String input, String expected) {
        BJ2448 instance = new BJ2448();
        Assertions.assertEquals(expected, instance.solve(input));
    }

    @Test
    public void logTest() {
        Assertions.assertEquals((int) (Math.log(3072) / Math.log(2)), 11);
    }
}
