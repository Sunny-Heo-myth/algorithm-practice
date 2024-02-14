package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.clazz.five.BJ2623;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IOUtil.answer(s -> Integer.parseInt(s.split(" ")[1]), new BJ2623()::solve);
    }


}
