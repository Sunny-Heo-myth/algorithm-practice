package org.alan.algorithm.interview.yanolja;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class OperationMax {

    public String solution(String input) {
        long[] terms = IntStream.iterate(0, i -> i < input.length(), i -> i + 2)
                .mapToLong(i -> Long.parseLong(String.valueOf(input.charAt(i)))).toArray();
        int[] op = IntStream.iterate(1, i -> i < input.length(), i -> i + 2)
                .map(input::charAt).toArray();

        long max  = Long.MIN_VALUE;
        for (int l = 0; l < terms.length; l++) for (int r = l + 1; r < terms.length; r++) {
            long[] adjustedTerms = LongStream.concat(LongStream.concat(
                    Arrays.stream(terms, 0, l),
                    LongStream.of(evaluate(l, r, terms, op))),
                    Arrays.stream(terms, r + 1, terms.length)
            ).toArray();
            int[] adjustedOp = IntStream.concat(
                    Arrays.stream(op, 0, l),
                    Arrays.stream(op, r, op.length)
            ).toArray();
            max = Math.max(max, evaluate(0, adjustedTerms.length - 1, adjustedTerms, adjustedOp));
        }
        return String.valueOf(max);
    }

    // Evaluate a block startInclusive l & endInclusive r without the sign of l.
    private long evaluate(int l, int r, long[] terms, int[] op) {
        if (l == r) return terms[l];
        long sum = 0, temp = terms[l];
        for (int i = l; i < r; i++) {
            if (op[i] == 'x') temp *= terms[i + 1];
            else {
                sum += temp;
                temp = op[i] == '+' ? terms[i + 1] : -terms[i + 1];
            }
        }
        return sum + temp;
    }

}
