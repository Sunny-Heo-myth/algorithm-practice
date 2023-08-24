package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.*;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ5073 instance = new BJ5073();
        String input = IOUtil.readWithEndLineCondition(line -> line.equals("0 0 0"));
        System.out.print(instance.solve(input));
    }

}
