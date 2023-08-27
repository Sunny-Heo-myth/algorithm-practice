package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.timecomplexity.BJ24313;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ24313 instance = new BJ24313();
        String input = IOUtil.readFiniteLine(3);
        System.out.print(instance.solve(input));
    }

}
