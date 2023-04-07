package org.alan.algorithm.practice.programmers.bestset;

public class BestSet2 {
    public int[] solution(int cardinality, int sum) {
        if (cardinality > sum) {
            return new int[]{-1};
        }

        if (cardinality == 1) {
            return new int[]{sum};
        }

        int quotient = sum / cardinality;
        int remainder = sum % cardinality;

        int[] answer = new int[cardinality];
        for (int i = 0; i < cardinality - remainder; i++) {
            answer[i] = quotient;
        }
        for (int i = cardinality - remainder; i < cardinality; i++) {
            answer[i] = quotient + 1;
        }

        return answer;
    }
}
