package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.four.BJ1991;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1991 instance = new BJ1991();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }


}
