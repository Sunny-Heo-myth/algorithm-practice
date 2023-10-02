package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.stepbystep.dynamicprogrammingstep.BJ24416;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BJ24416 instance = new BJ24416();
        IOUtil.answer(instance::solve);
    }

}
