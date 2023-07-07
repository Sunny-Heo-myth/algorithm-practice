package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ25206;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ11005;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ2745;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(s->0);
        BJ11005 instance = new BJ11005();
        var answer = instance.solve(input);
        System.out.print(answer);
    }

}
