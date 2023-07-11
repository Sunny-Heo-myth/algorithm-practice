package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.BJ9506;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ9506 instance = new BJ9506();
        String answer = IOUtil.answerWithEndLineCondition(s -> Integer.parseInt(s) == -1, instance::solve);
        System.out.print(answer);
    }

}
