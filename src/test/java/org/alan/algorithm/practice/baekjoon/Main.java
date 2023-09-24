package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo.BJ25192;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ25192 instance = new BJ25192();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
