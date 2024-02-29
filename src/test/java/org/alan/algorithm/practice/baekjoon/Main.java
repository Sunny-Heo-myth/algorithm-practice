package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.clazz.five.BJ9466;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        IOUtil.answerQuestions(Integer::parseInt, s -> 1, new BJ9466()::solve2);
    }


}
