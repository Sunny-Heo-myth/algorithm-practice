package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.tagged.greedy.BJ11047;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11047 instance = new BJ11047();
        IOUtil.answer(s -> Integer.parseInt(s.split(" ")[0]), instance::solve);
    }


}
