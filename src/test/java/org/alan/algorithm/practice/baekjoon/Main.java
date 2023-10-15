package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.tagged.greedy.BJ1541;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1541 instance = new BJ1541();
        IOUtil.answer(instance::solve);
    }


}
