package org.alan.algorithm.practice.programmers.gemshopping;

import java.util.*;

public class GemShopping3 {
    public int[] solution(String[] shelf) {
        Set<String> set = new HashSet<>(List.of(shelf));
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        int from = 0;
        int tempFrom = 0;
        int length = Integer.MAX_VALUE;

        for (String gem : shelf) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            queue.add(gem);

            while (true) {
                String headGem = queue.peek();
                if (map.get(headGem) > 1) {
                    map.put(headGem, map.get(headGem) - 1);
                    queue.poll();
                    tempFrom++;
                } else {
                    break;
                }
            }

            if (set.size() == map.size() && length > queue.size()) {
                from = tempFrom;
                length = queue.size();
            }
        }
        return new int[]{from + 1, from + length};
    }
}
