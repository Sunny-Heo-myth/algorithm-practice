package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BJ2501 {
    public String solve(String input) {
        String[] s = input.split(" ");
        int dividend = Integer.parseInt(s[0]);
        int order = Integer.parseInt(s[1]);

        List<Integer> factors = new LinkedList<>();
        double sqrt = Math.sqrt(dividend);

        int divisor = 1;
        while (divisor <= sqrt) {
            int quotient = dividend / divisor;
            int remainder = dividend % divisor;

            if (remainder == 0) {
                if (quotient != sqrt) {
                    factors.add(quotient);
                }
                factors.add(divisor);
            }
            divisor++;
        }

        if (order > factors.size()) {
            return String.valueOf(0);
        } else {
            return String.valueOf(factors.stream().sorted().collect(Collectors.toList()).get(order - 1));
        }
    }
}
