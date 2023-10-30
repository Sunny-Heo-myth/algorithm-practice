package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.level.four.BJ1967;
import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BJ1967 instance = new BJ1967();
        System.out.print(instance.solve(IOUtil.readWithNoEndLineCondition()));
    }


}
