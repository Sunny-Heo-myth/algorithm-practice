package org.alan.algorithm.practice.baekjoon.stepbystep.stackqueuedequestep;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BJ11866 {
    public String solve(String input) {
        // parse and initiate length & hop
        String[] s = input.split(" ");
        StringBuilder result = new StringBuilder();

        // declare & initiate deque
        Deque<Integer> chain = new LinkedList<>();
        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
            chain.add(i);
        }

        // declare & initiate hop
        int hop = Integer.parseInt(s[1]);

        // while deque is bigger than 1
        while (chain.size() > 1) {  // O(n)
            // poll hop times and push it at the end sequentially, the last polled element should be deleted.
            for (int i = 0; i < hop - 1; i++) { // O(n)
                chain.offerLast(chain.poll());
            }
            result.append(chain.poll()).append(", ");
        }
        // while loop end

        // add last element to result
        result.append(chain.poll());

        // return result in format
        return result.insert(0, "<").append(">").toString();
    }

    public String solve2(String input) {
        // parse and initiate length & hop
        String[] s = input.split(" ");
        StringBuilder result = new StringBuilder();

        // declare & initiate deque
        List<Integer> chain = new LinkedList<>();
        for (int i = 1; i <= Integer.parseInt(s[0]); i++) {
            chain.add(i);
        }

        // declare & initiate hop
        int hop = Integer.parseInt(s[1]);

        int index = 0;
        while (chain.size() > 1) {  // O(n)
            // initiate index
            index = (index + hop - 1) % chain.size();

            // get rid of element & append to result
            result.append(chain.remove(index)).append(", ");
        }

        return result.append(chain.remove(0)).insert(0, "<").append(">").toString();
    }

}
