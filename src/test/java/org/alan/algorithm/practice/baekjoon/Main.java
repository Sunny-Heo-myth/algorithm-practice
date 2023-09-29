package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo.BJ26069;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ26069 instance = new BJ26069();
        IOUtil.answer(Integer::parseInt, instance::solve);
    }

}
