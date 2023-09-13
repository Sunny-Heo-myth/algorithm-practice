package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep.BJ18258;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ18258 instance = new BJ18258();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
