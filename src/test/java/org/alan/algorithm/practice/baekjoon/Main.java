package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.stringstep.BJ9086;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ9086 instance = new BJ9086();
        String answer = IOUtil.answer(Integer::parseInt, instance::solve);
        System.out.print(answer);
    }

}
