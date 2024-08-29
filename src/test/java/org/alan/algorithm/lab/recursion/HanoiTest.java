package org.alan.algorithm.lab.recursion;

import org.junit.jupiter.api.Test;

import static org.alan.algorithm.lab.recursion.Hanoi.move;

public class HanoiTest {

    @Test
    void hanoiTest() {
        move(6, 1, 3);
    }
}
