package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.three.BJ9095;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ9095 instance = new BJ9095();
        IOUtil.answerQuestions(Integer::parseInt, instance::solve);
    }


}
