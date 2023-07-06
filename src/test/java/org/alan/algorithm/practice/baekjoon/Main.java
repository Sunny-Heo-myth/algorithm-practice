package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ25206;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(s->19);
        BJ25206 instance = new BJ25206();
        double answer = instance.solve(input);
        System.out.print(answer);
    }

}
