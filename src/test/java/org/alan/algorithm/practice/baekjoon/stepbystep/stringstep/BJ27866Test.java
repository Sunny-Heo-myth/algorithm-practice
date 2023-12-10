package org.alan.algorithm.practice.baekjoon.stepbystep.stringstep;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BJ27866Test {

    @Test
    void test1() throws IOException {
        // given
        BJ27866 instance = new BJ27866();
        String input = "Sprout\n" +
                "3";
        char expected = 'r';

        // when
        char answer = instance.solve(input);

        // then
        assertEquals(expected, answer);
    }

    @Test
    void test2() throws IOException {
        // given
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
    }
}
