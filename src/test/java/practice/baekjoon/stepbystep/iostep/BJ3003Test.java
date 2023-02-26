package practice.baekjoon.stepbystep.iostep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ3003Test {
    BJ3003 bj3003 = new BJ3003();

    @Test
    public void solveTest1() {
        Assertions.assertEquals("1 0 0 0 0 1", bj3003.solve("0 1 2 2 2 7"));
    }

    @Test
    public void solveTest2() {
        Assertions.assertEquals("-1 0 0 1 0 7", bj3003.solve("2 1 2 1 2 1"));
    }
}
