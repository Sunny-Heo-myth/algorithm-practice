package org.alan.algorithm.practice.baekjoon.problem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class BJ26086 {
    private final Deque<Integer> deque = new ArrayDeque<>();
    private boolean fromFirst = true;

    public String solve(String input) {
        String[] ops = Pattern.compile("\n").splitAsStream(input).skip(1).toArray(String[]::new);

        int lastSortOpIdx = IntStream.range(0, ops.length)
                .filter(i -> ops[i].equals("1"))
                .reduce((first, second) -> second)
                .orElse(-1);

        if (lastSortOpIdx == -1) {
            Arrays.stream(ops).forEach(this::offer);

        } else {
            boolean fromFirstUntil = Arrays.stream(ops)
                    .limit(lastSortOpIdx)
                    .filter(op -> op.equals("2"))
                    .count() / 2 == 0;

            Arrays.stream(ops)
                    .limit(lastSortOpIdx)
                    .filter(op -> op.length() != 1)
                    .mapToInt(op -> Integer.parseInt(op.split(" ")[1]))
                    .sorted()
                    .forEach(i -> {
                        if (fromFirstUntil) deque.offerLast(i);
                        else deque.offerFirst(i);
                    });

            fromFirst = fromFirstUntil;
            Arrays.stream(ops).skip(lastSortOpIdx + 1).forEach(this::offer);
        }

        int k = Integer.parseInt(input.split("\n")[0].split(" ")[2]) - 1;
        while (k-- > 0)
            if (fromFirst) deque.pollFirst();
            else deque.pollLast();
        return String.valueOf(fromFirst ? deque.pollFirst() : deque.pollLast());
    }

    private void offer(String op) {
        if (op.equals("2")) fromFirst = !fromFirst;
        else {
            int work = Integer.parseInt(op.split(" ")[1]);
            if (fromFirst) deque.offerFirst(work);
            else deque.offerLast(work);
        }
    }

}
