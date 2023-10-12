package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ11724;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ11724 instance = new BJ11724();
        IOUtil.answer(s -> Integer.parseInt(s.split(" ")[1]), instance::solve);
    }


}
