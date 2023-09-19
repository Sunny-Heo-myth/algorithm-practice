package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import java.util.*;
import java.util.stream.Collectors;

public class BJ2346 {
    public String solve(String input) {
        // parse number of balloons
        String[] s = input.split("\n");
        Deque<Integer> chain = new ArrayDeque<>();
        Arrays.stream(s[1].split(" ")).map(Integer::parseInt).forEach(chain::add);

        // declare result
        StringBuilder result = new StringBuilder();

        int index = 1;
        result.append(index).append(" ");

        int hop;
        // pollFirst & save index to result & D&I as hop
//        if (!chain.isEmpty()) {
//            hop = chain.pollFirst();
//        }
//        else {
//            return "";
//        }
//
//        index += hop;

        // while chain is bigger than 1
        while (chain.size() > 1) {
            hop = chain.pollFirst();

            if (hop >= 0) {
                // pollFirst & pushLast as much as hop - 1,
                for (int i = 0; i < hop - 1; i++) {
                    chain.offerLast(chain.pollFirst());
                }
                // pollFirst & save index to result & initiate hop
            }
            else {
                // pollLast & pushFirst as much as -(hop - 1),
                for (int i = 0; i < -hop; i++) {
                    chain.offerFirst(chain.pollLast());
                }
                // pollLast & save index to result & initiate hop
            }

            index = getIndex(index, hop, chain);
            result.append(index).append(" ");

        }

        // add the last element to result
        return result.append(chain.getFirst()).toString();
    }

    private int getIndex(int index, int hop, Deque<Integer> chain) {
        int i = index + hop;
        if (i > chain.size()) {
            index += hop - chain.size();
        }
        else if (i < 0) {
            index += hop + chain.size();
        }
        else {
            index += hop;
        }
        return index;
    }

    public String solve2(String input) {
        // parse number of balloons
        String[] s = input.split("\n");
        Deque<Balloon> chain = new ArrayDeque<>();
        List<Integer> list = Arrays.stream(s[1].split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        for (int i = 1; i < list.size() + 1; i++) {
            chain.add(new Balloon(i, list.get(i - 1)));
        }

        // declare result
        StringBuilder result = new StringBuilder();

        // pollFirst & save index to result & D&I as hop
        Balloon balloon = chain.pollFirst();
        result.append(balloon.index).append(" ");
        int hop = balloon.hop;

        // while chain is bigger than 1
        while (chain.size() > 1) {

            if (hop >= 0) {
                // pollFirst & pushLast as much as hop - 1,
                for (int i = 0; i < hop - 1; i++) {
                    chain.offerLast(chain.pollFirst());
                }
                // pollFirst & save index to result & initiate hop
                Balloon b = chain.pollFirst();
                hop = getHop(result, b);

            } else {
                // pollLast & pushFirst as much as -(hop - 1),
                for (int i = 0; i < -(hop + 1); i++) {
                    chain.offerFirst(chain.pollLast());
                }
                // pollLast & save index to result & initiate hop
                Balloon b = chain.pollLast();
                hop = getHop(result, b);
            }

        }

        // add the last element to result
        return result.append(chain.getFirst().index).toString();
    }

    private int getHop(StringBuilder result, Balloon b) {
        int hop;
        result.append(b.index).append(" ");
        hop = b.hop;
        return hop;
    }

    class Balloon {
        private int index;
        private int hop;

        public Balloon(int index, int hop) {
            this.index = index;
            this.hop = hop;
        }
    }

}
