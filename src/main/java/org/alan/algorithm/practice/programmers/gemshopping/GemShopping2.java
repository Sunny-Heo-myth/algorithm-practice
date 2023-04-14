package org.alan.algorithm.practice.programmers.gemshopping;

import java.util.*;

public class GemShopping2 {
    public int[] solution(String[] shelf) {
        Set<String> kinds = new HashSet<>(List.of(shelf));  // Set filtered equal values.
        Map<String, Integer> map = new HashMap<>(); // Map saves temporary equivalent element count as loop runs.
        Queue<String> interval = new LinkedList<>();    // Queue is an interval itself and iterable collection for running loop.
        int length = Integer.MAX_VALUE; // length of the interval
        int from = 0;   // from index of the interval
        int tempFrom = 0;   // temporary from index of the interval

        for (String gem : shelf) {  // Run loop for elements of array.
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            interval.offer(gem);

            while (true) {
                String tempGem = interval.peek();   // For a head of the interval,
                if (map.get(tempGem) > 1) { // if there are duplicated values in the interval,
                    map.put(tempGem, map.get(tempGem) - 1);
                    interval.poll();
                    tempFrom++; // decrement the duplicated count by 1, move the head, increment temporary from index.
                } else {
                    break;
                }
            }

            if (map.size() == kinds.size() && length > interval.size()) {
                from = tempFrom;
                length = interval.size();
            }
        }

        return new int[]{from + 1, from + length};
    }
}
