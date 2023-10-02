package org.alan.algorithm.practice.baekjoon.stepbystep.factormultipleprimestep;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BJ9506 {
    public String solve(String input) {
        int dividend = Integer.parseInt(input);
        List<Integer> factors = getFactors(dividend);
        List<Integer> sortedFactors = factors.stream().sorted().collect(Collectors.toList());
        int sum = 0;
        for (int i = 0; i < sortedFactors.size() - 1; i++) {
            sum += sortedFactors.get(i);
        }

        if (sum != dividend) {
            return input + " is NOT perfect.";
        }


        StringBuilder sb = new StringBuilder();
        sb.append(sum).append(" = ");
        for (int i = 0; i < sortedFactors.size() - 1; i++) {
            sb.append(sortedFactors.get(i)).append(" + ");
        }
        return sb.substring(0, sb.length() - 3);
    }

    private List<Integer> getFactors(int n) {
        List<Integer> factors = new LinkedList<>();
        int divisor = 1;
        while (divisor <= Math.sqrt(n)) {
            int remainder = n % divisor;
            int quotient = n / divisor;
            if (remainder == 0) {
                if (divisor != quotient) {
                    factors.add(divisor);
                }
                factors.add(quotient);
            }
            divisor++;
        }
        return factors;
    }
}
