package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.problem.BJ1850;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ1850 instance = new BJ1850();
        IOUtil.answer(instance::solve);
    }

}
