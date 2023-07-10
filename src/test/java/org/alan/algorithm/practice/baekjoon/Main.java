package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime.BJ2501;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ2501 instance = new BJ2501();
        String answer = IOUtil.answer(instance::solve);
        System.out.print(answer);
    }

}
