package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stringstep.BJ27866;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class BaekJoonRun {

    public static void main(String[] args) throws IOException {
        String s = IOUtil.readFiniteLine(string -> 1);
        BJ27866 instance = new BJ27866();
        System.out.print(instance.solve(s));
    }
}
