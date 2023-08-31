package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2.BJ2485;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ2485 instance = new BJ2485();
        String input = IOUtil.readFiniteLine(Integer::parseInt);
        System.out.print(instance.solve(input));
    }

}
