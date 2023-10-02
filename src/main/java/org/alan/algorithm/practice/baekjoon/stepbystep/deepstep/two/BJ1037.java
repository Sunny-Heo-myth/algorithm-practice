package org.alan.algorithm.practice.baekjoon.stepbystep.deepstep.two;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BJ1037 {
    public String solve(String input) {
        // parse
        List<Long> ints = Arrays.stream(input.split("\n")[1].split(" "))
                .mapToLong(Long::parseLong)
                .sorted()   // O(nlgn)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        // filter multiples O(n**2)
//        int i = 0;
//        while (i < ints.size()) {
//            int j = i + 1;
//            boolean deleted = false;
//            while (j < ints.size()) {
//                if (ints.get(j) % ints.get(i) == 0) {
//                    ints.remove(i);
//                    deleted = true;
//                    break;
//                }
//                j++;
//            }
//            if (!deleted) {
//                i++;
//            }
//        }

        // get lcm with gcd by Euclidean O(n) ?
        long lcm = getLcm(ints);

        if (lcm == ints.get(ints.size() - 1)) {
            return String.valueOf(lcm * 2);
        }
        return String.valueOf(lcm);
    }

    private long getLcm(List<Long> ints) {
        long lcm = ints.get(0);
        for (int i = 1; i < ints.size(); i++) {
            lcm = getLcm(lcm, ints.get(i));
        }
        return lcm;
    }

    private long getLcm(long a, long b) {
        return a / getGcd(a, b) * b;
    }

    private long getGcd(long a, long b) {
        long small, big;
        if (a >= b) {
            big = a;
            small = b;
        }
        else {
            small = a;
            big = b;
        }

        while (small != 0) {
            long remainder = big % small;
            big = small;
            small = remainder;
        }
        return big;
    }

    // todo: read the question carefully
    public String solve2(String input) {
        int[] ints = Arrays.stream(input.split("\n")[1].split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()   // O(nlgn)
                .toArray();

        return String.valueOf(ints[0] * ints[ints.length - 1]);
    }
}
