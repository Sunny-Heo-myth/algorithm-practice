package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.one.BJ2475;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ2475 instance = new BJ2475();
        IOUtil.answer(instance::solve);
    }


}
