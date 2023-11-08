package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ17219;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ17219 instance = new BJ17219();
        IOUtil.answer(s -> {
            String[] ss = s.split(" ");
            return Integer.parseInt(ss[0]) + Integer.parseInt(ss[1]);
        }, instance::solve);
    }


}
