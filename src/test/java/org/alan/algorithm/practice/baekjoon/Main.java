package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.four.BJ1167;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1167 instance = new BJ1167();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }


}
