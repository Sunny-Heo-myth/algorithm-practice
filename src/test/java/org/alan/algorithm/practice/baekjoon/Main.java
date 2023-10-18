package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep.BJ2559;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ2559 instance = new BJ2559();
        IOUtil.answer(1, instance::solve);
    }


}
