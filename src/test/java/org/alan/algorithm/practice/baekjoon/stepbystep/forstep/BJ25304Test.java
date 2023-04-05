package org.alan.algorithm.practice.baekjoon.stepbystep.forstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ25304Test {
    BJ25304 bj25304 = new BJ25304();

    @Test
    public void solveTest1() {
        Assertions.assertEquals("Yes", bj25304.solve(
                "260000\n" +
                "4\n" +
                "20000 5\n" +
                "30000 2\n" +
                "10000 6\n" +
                "5000 8"
        ));
    }

    @Test
    public void solveTest2() {
        Assertions.assertEquals("No", bj25304.solve(
                "250000\n" +
                        "4\n" +
                        "20000 5\n" +
                        "30000 2\n" +
                        "10000 6\n" +
                        "5000 8"
        ));
    }
}
