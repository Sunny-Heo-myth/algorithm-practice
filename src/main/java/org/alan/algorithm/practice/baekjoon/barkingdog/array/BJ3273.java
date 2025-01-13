package org.alan.algorithm.practice.baekjoon.barkingdog.array;

import java.util.regex.Pattern;

public class BJ3273 {

    public String solve(String input) {
        String[] line = input.split("\n");
        int[] numbers = Pattern.compile(" ").splitAsStream(line[1]).mapToInt(Integer::parseInt).sorted().toArray();
        int sum = Integer.parseInt(line[2]);

        int i = 0;
        int j = numbers.length - 1;
        int count = 0;
        while (i < j) {
            int temp = numbers[i] + numbers[j];
            if (temp < sum) {
                i++;
            } else if (temp > sum) {
                j--;
            } else {
                count++;
                i++;
            }
        }
        return String.valueOf(count);
    }

    public String solve2(String input) {
        String[] lines = input.split("\n");
        int[] arr = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).sorted().toArray();
        int x = Integer.parseInt(lines[2]);

        int count = 0, left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum > x) right--;
            else if (sum < x) left++;
            else {
                right--;
                left++;
                count++;
            }
        }
        return String.valueOf(count);
    }

}
