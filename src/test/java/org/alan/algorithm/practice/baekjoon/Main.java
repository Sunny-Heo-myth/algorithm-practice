package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.problem.BJ1259;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ1259 instance = new BJ1259();
        IOUtil.answerQuestionsWithEndLineCondition(s -> Objects.equals(s, "0"), instance::solve);
    }

}
