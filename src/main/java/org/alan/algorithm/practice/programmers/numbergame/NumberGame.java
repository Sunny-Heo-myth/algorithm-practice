package org.alan.algorithm.practice.programmers.numbergame;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberGame {
    public int solution(int[] inputA, int[] inputB) {
        Arrays.sort(inputB);
        List<Integer> bList = Arrays.stream(inputB).boxed().collect(Collectors.toCollection(LinkedList::new));

        int answer = 0;
        for (int a : inputA) {
            int i = 0;
            while (i < bList.size()) {
                if (a < bList.get(i)) {
                    Integer removed = bList.remove(i);
                    answer++;
                    break;
                }
                i++;
            }
        }
        return answer;
    }
}
