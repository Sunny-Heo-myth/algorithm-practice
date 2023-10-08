package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ1927;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ1927 instance = new BJ1927();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
