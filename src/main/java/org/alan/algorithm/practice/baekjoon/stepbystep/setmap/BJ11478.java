package org.alan.algorithm.practice.baekjoon.stepbystep.setmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ11478 {
    private final Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BJ11478 instance = new BJ11478(bf.readLine());
        System.out.print(instance.answer());
    }

    public BJ11478(String input) {
        set = new HashSet<>();
        int length = input.length();
        for (int numberOfElementInSet = 1; numberOfElementInSet < length + 1; numberOfElementInSet++) {
            for (int i = 0; i < length + 1 - numberOfElementInSet; i++) {
                set.add(input.substring(i, i + numberOfElementInSet));
            }
        }
    }

    public int answer() {
        return set.size();
    }
}
