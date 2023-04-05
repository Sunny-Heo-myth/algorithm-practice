package org.alan.algorithm.datastructure.recursion;

import org.junit.jupiter.api.Test;

import static org.alan.algorithm.concept.recursion.Hanoi.move;

public class HanoiTest {

    @Test
    void hanoiTest() {
        move(6, 1, 3);
    }
}
