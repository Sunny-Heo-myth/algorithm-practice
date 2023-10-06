package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.problem.BJ10845;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ10845 instance = new BJ10845();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
