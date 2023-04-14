package org.alan.algorithm.practice.programmers.gemshopping;

import java.util.*;

public class GemShopping {
    public int[] solution(String[] shelf) {
        Set<String> set = new HashSet<>(List.of(shelf));
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        int from = 0;
        int tempFrom = 0;
        int length = Integer.MAX_VALUE;

        for (String gem : shelf) {
            map.put(gem, map.getOrDefault(gem, 0) + 1);
            queue.offer(gem);

            while (true) {
                String tempGem = queue.peek();
                if (map.get(tempGem) > 1) {
                    queue.poll();
                    map.put(tempGem, map.get(tempGem) - 1);
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
