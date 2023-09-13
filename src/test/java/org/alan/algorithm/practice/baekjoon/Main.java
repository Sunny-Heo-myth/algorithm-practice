package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep.BJ12789;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ12789 instance = new BJ12789();
        IOUtil.answer(1, instance::solve);
    }

}
