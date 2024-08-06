package org.alan.algorithm.lab.datastructure.recursion;

import org.junit.jupiter.api.Test;

import static org.alan.algorithm.lab.recursion.GCD.euclidGcd;
import static org.alan.algorithm.lab.recursion.GCD.gcd;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GCDTest {

    @Test
    void ArrayInputGCDTEST() {
        int[] input = {1190,102,34,680};
        assertEquals(euclidGcd(input), 34);
    }

    @Test
    void gcdTest() {
        assertEquals(gcd(10, 4), 2);
        assertEquals(gcd(1190, 102), 34);
    }
}
