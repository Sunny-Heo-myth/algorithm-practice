package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedeque.BJ4949;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ4949 instance = new BJ4949();
        IOUtil.answerWithEndLineCondition(s -> s.equals("."), instance::solve2);
    }

}
