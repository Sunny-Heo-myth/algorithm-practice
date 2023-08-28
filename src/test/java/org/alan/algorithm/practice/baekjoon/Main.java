package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.*;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ14215 instance = new BJ14215();
        String input = IOUtil.readFiniteLine(1);
        System.out.print(instance.solve(input));
    }

}
