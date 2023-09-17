package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque.BJ11866;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ11866 instance = new BJ11866();
        IOUtil.answer(instance::solve);
    }

}
