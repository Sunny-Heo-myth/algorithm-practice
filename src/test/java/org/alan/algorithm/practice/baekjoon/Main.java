package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ1931;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1931 instance = new BJ1931();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
