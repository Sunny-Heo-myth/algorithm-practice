package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2.BJ1735;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ1735 instance = new BJ1735();
        String input = IOUtil.readFiniteLine(2);
        System.out.print(instance.solve(input));
    }

}
