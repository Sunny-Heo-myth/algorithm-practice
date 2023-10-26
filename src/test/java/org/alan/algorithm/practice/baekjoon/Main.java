package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.topic.greedy.BJ1026;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1026 instance = new BJ1026();
        IOUtil.answer(2, instance::solve);
    }


}
