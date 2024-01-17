package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class BJ1202 {
    public String solve(String input) {
        String[] firstLine = input.split("\n")[0].split(" ");
        int numberOfGem = Integer.parseInt(firstLine[0]);
        int numberOfBag = Integer.parseInt(firstLine[1]);

        // DnI gem array with the order of the weight of it.
        // DnI bag array with the order of availability weight it can hold.
        // DnI pq with the price of each gem.

        int[][] gemArray = input.lines().skip(1).limit(numberOfGem).map(s ->
                        Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .sorted(Comparator.comparingInt(gem -> gem[0])) // NlgN
                .toArray(int[][]::new);

        int[] bagArray = input.lines().skip(1 + numberOfGem).limit(numberOfBag).mapToInt(Integer::parseInt).sorted().toArray();

        long sumOfPrice = 0;
        int gemIndex = 0;
        int bagIndex = 0;
        PriorityQueue<Integer> gemPriceQueue = new PriorityQueue<>(Comparator.reverseOrder());

        while (bagIndex < numberOfBag) {
            int canHold = bagArray[bagIndex++];
            // check if it is available to put each jem into the bag and put it
            while (gemIndex < numberOfGem && gemArray[gemIndex][0] <= canHold) {
                gemPriceQueue.offer(gemArray[gemIndex++][1]);
            }
            if (!gemPriceQueue.isEmpty()) sumOfPrice += gemPriceQueue.poll();
        }
        return String.valueOf(sumOfPrice);
    }
}
