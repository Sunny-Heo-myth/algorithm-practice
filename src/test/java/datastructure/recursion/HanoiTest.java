package datastructure.recursion;

import org.junit.jupiter.api.Test;

import static concept.recursion.Hanoi.move;

public class HanoiTest {

    @Test
    void hanoiTest() {
        move(6, 1, 3);
    }
}
