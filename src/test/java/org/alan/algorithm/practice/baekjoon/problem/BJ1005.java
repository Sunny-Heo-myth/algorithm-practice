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
            int[] constructionTime = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // DNI total elapsed time for each building as array
            int[] totalElapsedTime = new int[numberOfBuildings];

            // DNI directed edges
            Map<Integer, List<Integer>> edgeMap = new HashMap<>();
            for (int i = 0; i < numberOfRules; i++) {
                String[] s = bf.readLine().split(" ");
                int key = Integer.parseInt(s[0]) - 1;   // minus 1 for array processing
                int valueElement = Integer.parseInt(s[1]) - 1;  // minus 1 for array processing
                if (edgeMap.containsKey(key)) {
                    edgeMap.get(key).add(valueElement);
                } else {
                    List<Integer> integers = new ArrayList<>();
                    integers.add(valueElement);
                    edgeMap.put(key, integers);
                }
            }

            // DNI destination
            int destination = Integer.parseInt(bf.readLine()) - 1;  // minus 1 for array processing

            // initiate first element of totalElapsedTime
            System.arraycopy(constructionTime, 0, totalElapsedTime, 0, constructionTime.length);

            result.append(answer(constructionTime, totalElapsedTime, edgeMap, destination)).append("\n");

            numberOfQuestions--;
        }

        bf.close();
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private int answer(int[] constructionTime,
                       int[] totalElapsedTime,
                       Map<Integer, List<Integer>> edgeMap,
                       int destination) {

        int shortestTime = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        while (!queue.isEmpty()) {
            // DNI current building with poll & add to total for the building
            int currentBuilding = queue.poll();

            // if it is destination, update result
            if (currentBuilding == destination) {
                if (shortestTime > totalElapsedTime[destination]) {
                    shortestTime = totalElapsedTime[destination];
                }
                continue;
            }

            List<Integer> nextBuildings = edgeMap.get(currentBuilding);
            for (int nextBuilding : nextBuildings) {
                // if total is 0 add the building cost to total and write to the building
                if (totalElapsedTime[nextBuilding] == constructionTime[nextBuilding]) {
                    queue.add(nextBuilding);
                    totalElapsedTime[nextBuilding] += totalElapsedTime[currentBuilding];
                }
                // else compare total elapsed time of the building vs total elapsed time of current building & update total
                else {
                    int sum = totalElapsedTime[currentBuilding] + constructionTime[nextBuilding];
                    if (totalElapsedTime[nextBuilding] > sum) {
                        queue.add(nextBuilding);
                        totalElapsedTime[nextBuilding] = sum;
                    }
                }
            }

        }

        // return result
        return shortestTime;
    }

    private int answer2(int[] constructionTime,
                        int[] reversedTotalElapsedTime,
                        Map<Integer, List<Integer>> reversedEdgeMap,
                        int destination) {

        int shortestTime = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(destination);
        while (!queue.isEmpty()) {
            // DNI current building with poll & add to total for the building
            int currentBuilding = queue.poll();

            // if it is destination, update result
            if (currentBuilding == 0) {
                if (shortestTime > reversedTotalElapsedTime[0]) {
                    shortestTime = reversedTotalElapsedTime[0];
                }
                continue;
            }

            List<Integer> previousBuildings = reversedEdgeMap.get(currentBuilding);
            for (int previousBuilding : previousBuildings) {
                // if total is 0 add the building cost to total and write to the building
                if (reversedTotalElapsedTime[previousBuilding] == constructionTime[previousBuilding]) {
                    queue.add(previousBuilding);
                    reversedTotalElapsedTime[previousBuilding] += reversedTotalElapsedTime[currentBuilding];
                }
                // else compare total elapsed time of the building vs total elapsed time of current building & update total
                else {
                    int sum = reversedTotalElapsedTime[currentBuilding] + constructionTime[previousBuilding];
                    if (reversedTotalElapsedTime[previousBuilding] > sum) {
                        queue.add(previousBuilding);
                        reversedTotalElapsedTime[previousBuilding] = sum;
                    }
                }
            }

        }

        // return result
        return shortestTime;
    }
}
