package practice.baekjoon.stepbystep.recursionstep;

import org.junit.jupiter.api.Test;
import practice.baekjoon.stepbystep.recursionStep.BJ25501;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ25501Test {
    BJ25501 instance = new BJ25501();

    @Test
    void recursionTest() {
        assertEquals(1, instance.recursion("ABA"));
    }

    @Test
    void recursionTest2() {
        assertEquals(0, instance.recursion("PALINDROME"));
    }

    @Test
    void recursionTest3() {
        assertEquals(1, instance.recursion("ABABA"));
    }
}
