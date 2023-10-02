package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.recursionstep.BJ4779;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ4779 instance = new BJ4779();
        IOUtil.answerQuestionsWithNoEndLineCondition(instance::solve);
    }

}
