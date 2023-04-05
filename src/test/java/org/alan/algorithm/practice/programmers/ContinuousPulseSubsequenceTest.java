package org.alan.algorithm.practice.programmers;

import org.alan.algorithm.practice.programmers.continuouspulsesubsequence.ContinuousPulseSubsequence;
import org.alan.algorithm.practice.programmers.continuouspulsesubsequence.ContinuousPulseSubsequence2;
import org.alan.algorithm.practice.programmers.continuouspulsesubsequence.ContinuousPulseSubsequence3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinuousPulseSubsequenceTest {

    @Test
    void test1() {
        ContinuousPulseSubsequence instance = new ContinuousPulseSubsequence();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        Assertions.assertEquals(10, instance.solution(sequence));
    }

    @Test
    void test2() {
        ContinuousPulseSubsequence2 instance = new ContinuousPulseSubsequence2();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        Assertions.assertEquals(10, instance.solution(sequence));
    }

    @Test
    void test3() {
        ContinuousPulseSubsequence3 instance = new ContinuousPulseSubsequence3();
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};
        Assertions.assertEquals(10, instance.solution(sequence));
    }
}
