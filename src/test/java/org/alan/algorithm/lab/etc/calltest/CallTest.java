package org.alan.algorithm.lab.etc.calltest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallTest {

    @Test
    void localVariableTest() {
        // given
        int t = 0;

        // when
        f1(t);

        // then
        assertEquals(0, t);

    }

    void f1(int input) {
        input = 5;
    }
}
