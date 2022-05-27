package basicDataStructure.recursion;

import org.junit.jupiter.api.Test;

import static basicDataStructure.recursion.Hanoi.move;

public class HanoiTest {

    @Test
    void hanoiTest() {
        move(6, 1, 3);
    }
}
