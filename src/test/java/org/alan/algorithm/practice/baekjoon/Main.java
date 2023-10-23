package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.four.BJ15663;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ15663 instance = new BJ15663();
        IOUtil.answer(1, instance::solve);
    }


}
