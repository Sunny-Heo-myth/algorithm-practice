package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2.BJ17103;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ17103 instance = new BJ17103();
        IOUtil.answerMultipleQuestions(instance::solve);
    }

}
