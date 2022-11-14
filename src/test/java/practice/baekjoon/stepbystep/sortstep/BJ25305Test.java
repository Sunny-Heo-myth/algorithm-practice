package practice.baekjoon.stepbystep.sortstep;

import practice.baekjoon.stepbystep.sortStep.BJ25305;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ25305Test {

    @Test
    public void insertionSortTest() {
        // given
        BJ25305 instance = new BJ25305();
        String givenString = "5 2\n" +
                "100 76 85 93 98";

        instance.solve(givenString);

        // when, then
        assertEquals(98, instance.solve(givenString));
    }
}
