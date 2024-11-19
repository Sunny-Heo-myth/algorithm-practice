package org.alan.algorithm.practice.baekjoon.problem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ19644 {

    public String solve(String input) { // todo:
        String[] lines = input.split("\n"), mg = lines[1].split(" ");
        int range = Integer.parseInt(mg[0]), damage = Integer.parseInt(mg[1]), grenade = Integer.parseInt(lines[2]);

        Queue<Integer> queue = IntStream.range(0, Integer.parseInt(lines[0]))
                .mapToObj(i -> Integer.parseInt(lines[i + 3]))
                .collect(Collectors.toCollection(LinkedList::new));

        int shoot = 0;
        int bombed = 0;
        while (!queue.isEmpty()) {
            int health = queue.peek();

            int shot = Math.min(range, ++shoot) - bombed;
            if (shot * damage >= health) {
                queue.poll();
                bombed = Math.max(0, bombed - 1);
            } else {
                if (grenade > 0) {
                    grenade--;
                    queue.poll();
                    bombed++;
                } else return "NO";
            }
        }
        return "YES";
    }

    public String solve2(String input) {
        String[] lines = input.split("\n"), mg = lines[1].split(" ");
        int distance = Integer.parseInt(lines[0]);
        int range = Integer.parseInt(mg[0]), damage = Integer.parseInt(mg[1]), grenade = Integer.parseInt(lines[2]);

        int[] health = Arrays.stream(lines).skip(3).mapToInt(Integer::parseInt).toArray();
        boolean[] bombedAt = new boolean[distance];

        int shootFrom = -range + 1;
        int shootTo = -1;
        int bombed = range - 1;

        int shot;
        while (++shootTo < distance) {
            shot = (range - bombed) * damage;
            if (shot < health[shootTo]) {
                if (--grenade < 0) return "NO";
                bombed++;
                bombedAt[shootTo] = true;
            }

            if (shootFrom < 0 || bombedAt[shootFrom]) bombed--;

            shootFrom++;
        }

        return "YES";
    }

}
