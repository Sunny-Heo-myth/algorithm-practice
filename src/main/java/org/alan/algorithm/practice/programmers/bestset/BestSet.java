package org.alan.algorithm.practice.programmers.bestset;

import java.util.Arrays;

public class BestSet {
    public int[] solution(int cardinality, int sum) {
        if (cardinality > sum) {
            return new int[]{-1};
        }

        return divide(cardinality, sum);
    }

    private int[] divide(int cardinality, int sum) {
        int[] answer = new int[cardinality];
        int quotient = sum / cardinality;
        int remainder = sum % cardinality;

        if (remainder == 0) {
            Arrays.fill(answer, quotient);
            return answer;
        }

        Arrays.fill(answer, 0, cardinality - remainder, quotient);
        Arrays.fill(answer, cardinality - remainder, cardinality, quotient + 1);
        return answer;
    }
}
