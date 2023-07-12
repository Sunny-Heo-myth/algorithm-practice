package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.rectangletriangle.BJ27323;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ27323 instance = new BJ27323();
        String answer = IOUtil.answer(1, instance::solve);
        System.out.print(answer);
    }

}
