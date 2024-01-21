package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BJ1509 {

    public String solve(String input) {
        int length = input.length();
        boolean[][] palindrome = new boolean[length + 1][length + 1];
        IntStream.range(0, palindrome.length).forEach(i -> Arrays.fill(palindrome[i], true));
        int[] memo = new int[length + 1];
        IntStream.rangeClosed(1, length).forEach(i -> memo[i] = Integer.MAX_VALUE);

        IntStream.range(0, length).forEach(start -> IntStream.range(start, length).forEach(
                end -> IntStream.range(0, end - start)
                        .takeWhile(i -> start + i <= end - i)
                        .filter(i -> input.charAt(start + i) != input.charAt(end - i))
                        .findFirst().ifPresent(i -> palindrome[start + 1][end + 1] = false)));

        IntStream.rangeClosed(1, length).forEach(i -> IntStream.rangeClosed(1, i)
                .filter(j -> palindrome[j][i])
                .forEach(j -> memo[i] = Math.min(memo[i], memo[j - 1] + 1)));

        return String.valueOf(memo[length]);
    }

    public String solve2(String input) {
        int length = input.length();

        boolean[][] isPalindrome = new boolean[length + 1][length + 1];
        for (int wordFrom = 1; wordFrom <= length; wordFrom++) for (int wordTo = wordFrom; wordTo <= length; wordTo++) { // O(n^2)
            boolean flag = true;

            int sIdx = wordFrom - 1;
            int eIdx = wordTo - 1;
            while (sIdx <= eIdx) if (input.charAt(sIdx++) != input.charAt(eIdx--)) {
                flag = false;
                break;
            }

            if (flag) isPalindrome[wordFrom][wordTo] = true;
        }

        int[] memo = new int[length + 1];
        IntStream.rangeClosed(1, length).forEach(wordTo -> memo[wordTo] = Integer.MAX_VALUE);

        IntStream.rangeClosed(1, length).forEach(wordTo -> IntStream.rangeClosed(1, wordTo)
                .filter(wordFrom -> isPalindrome[wordFrom][wordTo])
                .forEach(wordFrom -> memo[wordTo] = Math.min(memo[wordTo], memo[wordFrom - 1] + 1)));

        return String.valueOf(memo[length]);
    }

    public String solve3(String input) {
        int length = input.length();

        boolean[][] palindromeArray = new boolean[length + 1][length + 1];
        for (int wordFrom = 1; wordFrom <= length; wordFrom++) for (int wordTo = wordFrom; wordTo <= length; wordTo++) {
            int startIdx = wordFrom - 1;
            int endIdx = wordTo - 1;

            boolean isPalindrome = true;
            while (startIdx <= endIdx) if (input.charAt(startIdx++) != input.charAt(endIdx--)) {
                isPalindrome = false;
                break;
            }
            if (isPalindrome) palindromeArray[wordFrom][wordTo] = true;
        }

        int[] memo = new int[length + 1];
        IntStream.rangeClosed(1, length).forEach(i -> memo[i] = Integer.MAX_VALUE);
        IntStream.rangeClosed(1, length).forEach(wordTo -> IntStream.rangeClosed(1, wordTo)
                .filter(wordFrom -> palindromeArray[wordFrom][wordTo])
                .forEach(wordFrom -> memo[wordTo] = Integer.min(memo[wordTo], memo[wordFrom - 1] + 1)));

        return String.valueOf(memo[length]);
    }
}
