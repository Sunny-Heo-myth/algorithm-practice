package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ10988;
import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ2444;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(s->0);
        BJ10988 instance = new BJ10988();
        int answer = instance.solve(input);
        System.out.print(answer);
    }

}
