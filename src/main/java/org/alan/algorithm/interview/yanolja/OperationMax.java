package org.alan.algorithm.interview.yanolja;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class OperationMax {

    public String solution(String input) {
        int[] op = IntStream.iterate(1, i -> i < input.length(), i -> i + 2)
                .map(input::charAt).toArray();
        long[] terms = IntStream.iterate(0, i -> i < input.length(), i -> i + 2)
                .mapToLong(i -> Long.parseLong(String.valueOf(input.charAt(i)))).toArray();
        long max = Long.MIN_VALUE;

        for (int i = 0; i < terms.length; i++) {
            for (int j = i + 1; j < terms.length; j++) {
                int[] op2 = IntStream.concat(
                        Arrays.stream(op).limit(i),
                        Arrays.stream(op).skip(j)
                ).toArray();
                long[] terms2 = LongStream.concat(LongStream.concat(
                        Arrays.stream(terms, 0, i),
                        LongStream.of(evaluate(i, j, terms, op))),
                        Arrays.stream(terms).skip(j + 1)
                ).toArray();
                max = Math.max(max, evaluate(0, terms2.length - 1, terms2, op2));
            }
        }
        return String.valueOf(max);
    }

    // evaluate () block without the sign of the block itself.
//    private long evaluate(int i, int j, int[] oper, long[] terms) {
//        if (i == j) return terms[i];
//        Stack<Long> addable = new Stack<>();
//
//        while (j >= i) {
//            long op = terms[j];
//            while (true) {
//                if (--j >= i && oper[j] == 'x') op *= terms[j];
//                else break;
//            }
//            addable.push((j >= i && oper[j] == '-') ? -op : op);
//        }
//        return addable.stream().reduce(0L, Long::sum);
//    }
    
    private long evaluate(int l, int r, long[] terms, int[] operand) {
        if (l == r) return terms[l];
        long sum = 0, term = terms[l];
        for (int i = l; i < r; i++) {
            if (operand[i] == 'x') term *= terms[i + 1];
            else {
                sum += term;
                term = operand[i] == '+' ? terms[i + 1] : -terms[i + 1];
            }
        }
        return sum + term;
    }



}
