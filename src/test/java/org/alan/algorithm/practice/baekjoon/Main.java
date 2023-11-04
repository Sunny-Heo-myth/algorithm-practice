package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.four.BJ1043;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1043 instance = new BJ1043();
        IOUtil.answer(s -> Integer.parseInt(s.split(" ")[1]) + 1, instance::solve);
    }


}
