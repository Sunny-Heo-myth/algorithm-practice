package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.two.BJ18110;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ18110 instance = new BJ18110();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }


}
