package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.BJ5086;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ5086 instance = new BJ5086();
        String answer = IOUtil.answerWithEndLineCondition(s -> {
            String[] strings = s.split(" ");
            return Integer.parseInt(strings[0]) == 0 && Integer.parseInt(strings[1]) == 0;
        }, instance::solve);
        System.out.print(answer);
    }

}
