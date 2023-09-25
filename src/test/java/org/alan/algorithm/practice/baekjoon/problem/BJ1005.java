package org.alan.algorithm.practice.baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1005 {

    public String solve() throws IOException {
        // parse
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfQuestions = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();

        while (0 < numberOfQuestions) {

            // DNI number of building (node) & number of rule (edge)
            String[] line = bf.readLine().split(" ");
            int numberOfBuildings = Integer.parseInt(line[0]);
            int numberOfRules = Integer.parseInt(line[1]);

            // DNI elapsed time for each building as array (directed edge)
            int[] elapseTime = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // DNI total elapsed time for each building as array
            int[] totalElapseTime = new int[numberOfBuildings];

            // DNI directed edges
            Map<Integer, List<Integer>> edgeMap = new HashMap<>();
            for (int i = 0; i < numberOfRules; i++) {
                String[] s = bf.readLine().split(" ");
                int key = Integer.parseInt(s[0]);
                int valueElement = Integer.parseInt(s[1]);
                if (edgeMap.containsKey(key)) {
                    edgeMap.get(key).add(valueElement);
                } else {
                    edgeMap.put(key, List.of(valueElement));
                }
            }

            // DNI destination
            int destination = Integer.parseInt(bf.readLine());


            numberOfQuestions--;
        }

        bf.close();
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private String answer(String s) {


        // DNI queue
        // add starting point to queue<int>

        // while queue is not empty

        // DNI current building with poll & add to total for the building

        // if total is 0 add the building cost to total and write to the building
        // else compare total elapsed time of the building vs total elapsed time of current building & update total

        // if it is destination, update result

        // while end

        // return result
        return null;
    }
}
