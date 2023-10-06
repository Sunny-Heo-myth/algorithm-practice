package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.two.BJ10866;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ10866 instance = new BJ10866();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
