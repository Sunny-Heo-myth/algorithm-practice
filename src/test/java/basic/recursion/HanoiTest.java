package basic.recursion;

import org.junit.jupiter.api.Test;

import static basic.recursion.Hanoi.move;

public class HanoiTest {

    @Test
    void hanoiTest() {
        move(6, 1, 3);
    }
}
