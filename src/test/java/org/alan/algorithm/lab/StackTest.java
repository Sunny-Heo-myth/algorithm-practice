package org.alan.algorithm.lab;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

public class StackTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.of("1234", "0")
        );
    }

    @ParameterizedTest
    @MethodSource("parameters")
    public void test1() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int idx = 1;
        for (int i : stack) {
            Assertions.assertEquals(idx++, i);
        }

        idx = 5;
        for (int i = 0; i < stack.size(); i++) {
            Assertions.assertEquals(idx--, stack.pop());
        }
    }
}
