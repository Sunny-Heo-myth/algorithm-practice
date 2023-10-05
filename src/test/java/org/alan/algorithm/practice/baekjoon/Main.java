package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.problem.BJ2609;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ2609 instance = new BJ2609();
        IOUtil.answer(instance::solve);
    }

}
