package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.BJ15894;
import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.BJ27323;
import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.BJ9063;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ9063 instance = new BJ9063();
        String input = IOUtil.readFiniteLine(Integer::parseInt);
        System.out.print(instance.solve(input));
    }

}
