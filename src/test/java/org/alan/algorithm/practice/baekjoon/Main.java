package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ2630;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ2630 instance = new BJ2630();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }


}
