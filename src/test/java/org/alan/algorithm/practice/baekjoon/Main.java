package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.priorityqueue.BJ11279;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11279 instance = new BJ11279();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }


}
