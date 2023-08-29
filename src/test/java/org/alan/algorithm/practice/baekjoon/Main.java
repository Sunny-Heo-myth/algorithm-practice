package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.bruteforcestep.BJ7785;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ7785 instance = new BJ7785();
        String input = IOUtil.readFiniteLine(Integer::parseInt);
        System.out.print(instance.solve(input));
    }

}
