package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.problem.BJ10830;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ10830 instance = new BJ10830();
        IOUtil.answer(s -> Integer.parseInt(s.split(" ")[0]), instance::solve);
    }


}
