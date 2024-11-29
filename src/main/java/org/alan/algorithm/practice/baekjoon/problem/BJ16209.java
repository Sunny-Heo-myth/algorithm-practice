package org.alan.algorithm.practice.baekjoon.problem;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ16209 {
    public String solve(String input) {

        long[] nSorted = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToLong(Long::parseLong)
                .filter(l -> l < 0).sorted().toArray();
        Stack<Long> nLeft = new Stack<>(), nRight = new Stack<>();

        for (long nl : nSorted) {
            if (nLeft.isEmpty()) {
                nLeft.push(nl);
                continue;
            }
            if (nRight.isEmpty()) {
                nRight.push(nl);
                continue;
            }

            if (nLeft.peek() * nl > nRight.peek() * nl) nLeft.push(nl);
            else nRight.push(nl);
        }

        long[] pSorted = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).mapToLong(Long::parseLong)
                .filter(l -> l >= 0).map(l -> -l).sorted().map(l -> -l).toArray();
        Stack<Long> pLeft = new Stack<>(), pRight = new Stack<>();

        for (long pl : pSorted) {
            if (pRight.isEmpty()) {
                pRight.push(pl);
                continue;
            }
            if (pLeft.isEmpty()) {
                pLeft.push(pl);
                continue;
            }

            if (pLeft.peek() * pl >= pRight.peek() * pl) pLeft.push(pl);
            else pRight.push(pl);
        }

        List<Long> nReversed = new ArrayList<>(nLeft);
        Collections.reverse(nReversed);

        List<Long> pReversed = new ArrayList<>(pLeft);
        Collections.reverse(pReversed);

        return nReversed.stream().map(String::valueOf).collect(Collectors.joining(" "))
                + (nReversed.isEmpty() ? "" : " ") + nRight.stream().map(String::valueOf).collect(Collectors.joining(" "))
                + (nRight.isEmpty() ? "" : " ") + pReversed.stream().map(String::valueOf).collect(Collectors.joining(" "))
                + (pReversed.isEmpty() ? "" : " ") + pRight.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    public String solve2(String input) {
        List<Long> nSorted = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).map(Long::parseLong)
                .filter(l -> l < 0).sorted().collect(Collectors.toList());
        List<Long> pSorted = Pattern.compile(" ").splitAsStream(input.split("\n")[1]).map(Long::parseLong)
                .filter(l -> l >= 0).map(l -> -l).sorted().map(l -> -l).collect(Collectors.toList());
        Deque<Long> pDeque = new ArrayDeque<>(), nDeque = new ArrayDeque<>();

        fillDeque(pSorted, pDeque);
        fillDeque(nSorted, nDeque);

        Deque<Long> deque = new ArrayDeque<>();
        while (!pDeque.isEmpty()) deque.addLast(pDeque.pollFirst());

        boolean pFront = pSorted.size() % 2 == 0;
        boolean nFront = nSorted.size() % 2 == 0;
        while (!nDeque.isEmpty()) {
            long v = nFront ? nDeque.pollFirst() : nDeque.pollLast();
            if (pFront) deque.addFirst(v);
            else deque.addLast(v);
        }

        return deque.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    private void fillDeque(List<Long> list, Deque<Long> deque) {
        if (list.isEmpty()) return;

        deque.addFirst(list.get(0));
        for (int i = 1; i < list.size(); i += 2) {
            deque.addFirst(list.get(i));
            if (i + 1 < list.size()) deque.addLast(list.get(i + 1));
        }
    }

}
