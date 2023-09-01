package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprime2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ4134 {
    List<Integer> primes = new ArrayList<>();
    public String solve(String input) {
        // parse into int array
        String[] s = input.split("\n");
        int n = Integer.parseInt(s[0]);
        int[] ints = new int[s.length - 1];
        for (int i = 1; i < n + 1; i++) {
            ints[i - 1] = Integer.parseInt(s[i]);
        }

        // get max
        Arrays.sort(ints); // O(nlogn)
        int max = ints[ints.length - 1];

        // while get max's answer prime, save smaller prime


        //
        return null;
    }

    private long getBiggerPrime(long n) {
        long i = 1;
        while (i != 4000000000L) {


            i++;
        }
        return 0;
    }


}
