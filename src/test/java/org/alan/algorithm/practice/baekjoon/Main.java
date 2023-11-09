package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.topic.greedy.BJ5585;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ5585 instance = new BJ5585();
        IOUtil.answer(instance::solve);
    }


}
