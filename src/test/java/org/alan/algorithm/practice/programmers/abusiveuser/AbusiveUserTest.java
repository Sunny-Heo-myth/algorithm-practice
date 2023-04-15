package org.alan.algorithm.practice.programmers.abusiveuser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AbusiveUserTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of(2, new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"}),
                Arguments.of(2, new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"*rodo", "*rodo", "******"}),
                Arguments.of(3, new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "*rodo", "******", "******"})
        );
    }
    
    @ParameterizedTest
    @MethodSource("parameters")
    public void test1(int expected, String[] userId, String[] bannedId) {
        AbusiveUser instance = new AbusiveUser();
        Assertions.assertEquals(expected, instance.solution(userId, bannedId));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test2(int expected, String[] userId, String[] bannedId) {
        AbusiveUser2 instance = new AbusiveUser2();
        Assertions.assertEquals(expected, instance.solution(userId, bannedId));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test3(int expected, String[] userId, String[] bannedId) {
        AbusiveUser3 instance = new AbusiveUser3();
        Assertions.assertEquals(expected, instance.solution(userId, bannedId));
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test4(int expected, String[] userId, String[] bannedId) {
        AbusiveUser4 instance = new AbusiveUser4();
        Assertions.assertEquals(expected, instance.solution(userId, bannedId));
    }
}
