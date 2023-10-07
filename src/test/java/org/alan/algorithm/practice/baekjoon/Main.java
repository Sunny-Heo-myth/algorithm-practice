package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ1074;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ1074 instance = new BJ1074();
        IOUtil.answer(instance::solve);
    }

}
