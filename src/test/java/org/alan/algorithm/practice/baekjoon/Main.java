package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deepone.BJ25206;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ11005;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ2720;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ2745;
import org.alan.algorithm.practice.baekjoon.stepbystep.math1step.BJ2903;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ2903 instance = new BJ2903();
        String answer = IOUtil.answer(instance::solve);
        System.out.print(answer);
    }

}
