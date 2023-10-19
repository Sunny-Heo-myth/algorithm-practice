package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.cumulativesumstep.BJ10986;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ10986 instance = new BJ10986();
        IOUtil.answer(1, instance::solve);
    }


}
