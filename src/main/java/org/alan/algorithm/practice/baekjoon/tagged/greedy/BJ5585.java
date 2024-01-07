package org.alan.algorithm.practice.baekjoon.tagged.greedy;

public class BJ5585 {
    public String solve(String input) {
        int money = 1000 - Integer.parseInt(input);
        int count = 0;
        while (money > 0) {
            count++;
            if (money >= 500) money -= 500;
            else if (money >= 100) money -= 100;
            else if (money >= 50) money -= 50;
            else if (money >= 10) money -= 10;
            else if (money >= 5) money -= 5;
            else money -= 1;
        }
        return String.valueOf(count);
    }
}
