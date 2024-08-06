package org.alan.algorithm.lab.datastructure.recursion;


import org.junit.jupiter.api.Test;

import static org.alan.algorithm.lab.recursion.Factorial.whileFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    @Test
    void whileFactorialTest() {
        assertEquals(whileFactorial(5), 120);
        assertEquals(whileFactorial(1), 1);
    }
}
