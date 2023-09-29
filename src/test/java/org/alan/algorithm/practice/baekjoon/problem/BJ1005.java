package org.alan.algorithm.practice.baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

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

    public String solve2() throws IOException {
//        Scanner sc = new Scanner(System.in);
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();

        while (n > 0) {

//            int numberOfNodes = sc.nextInt();
//            int numberOfEdges = sc.nextInt();
            String[] s = bf.readLine().split(" ");
            int numberOfNodes = Integer.parseInt(s[0]);
            int numberOfEdges = Integer.parseInt(s[1]);

            int[] nodes = IntStream.rangeClosed(1, numberOfNodes).toArray();
            Map<Integer, Integer> nodeCosts = new HashMap<>();
            Map<Integer, Integer> nodeTotalCosts = new HashMap<>();

//            for (int node : nodes) {
//                int cost = sc.nextInt();
//                nodeCosts.put(node , cost);
//                nodeTotalCosts.put(node , cost);
//            }
            int[] costs = Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int i = 0; i < nodes.length; i++) {
                nodeCosts.put(nodes[i], costs[i]);
                nodeTotalCosts.put(nodes[i], costs[i]);
            }


            int[] froms = new int[numberOfEdges];
            int[] tos = new int[numberOfEdges];
            for (int i = 0; i < numberOfEdges; i++) {
//                froms[i] = sc.nextInt();
//                tos[i] = sc.nextInt();
                String[] ss = bf.readLine().split(" ");
                froms[i] = Integer.parseInt(ss[0]);
                tos[i] = Integer.parseInt(ss[1]);
            }

//            int destination = sc.nextInt();
            int destination = Integer.parseInt(bf.readLine());

            result.append(traverse(nodes, nodeCosts, nodeTotalCosts, froms, tos, destination)).append("\n");

            n--;
        }

//        sc.close();
        bf.close();

        return result.deleteCharAt(result.length() - 1).toString();
    }

    private String traverse(int[] nodes,
                            Map<Integer, Integer> nodeCosts,
                            Map<Integer, Integer> nodeTotalCosts,
                            int[] froms,
                            int[] tos,
                            int destination) {

        Map<Integer, List<Integer>> fromTo = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (int node : nodes) {
            fromTo.put(node, new ArrayList<>());
            inDegrees.put(node, 0);
        }

        for (int i = 0; i < froms.length; i++) {
            int from = froms[i];
            int to = tos[i];

            fromTo.get(from).add(to);

            if (inDegrees.containsKey(to)) {
                inDegrees.put(to, inDegrees.get(to) + 1);
            } else {
                inDegrees.put(to, 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int answer = Integer.MAX_VALUE;
        for (int to : inDegrees.keySet()) {
            if (inDegrees.get(to) == 0) {
                queue.offer(to);
            }
        }

        while (!queue.isEmpty()) {
            int from = queue.poll();

            if (from == destination) {
                int sum = nodeTotalCosts.get(destination);
                if (sum < answer) {
                    answer = sum;
                }
                continue;
            }

            for (int to : fromTo.get(from)) {

                if (!Objects.equals(nodeTotalCosts.get(to), nodeCosts.get(to))) {
                    int newSum = nodeTotalCosts.get(from) + nodeCosts.get(to);
                    if (nodeTotalCosts.get(to) < newSum) {
                        nodeTotalCosts.put(to, newSum);
                    }
                } else {
                    nodeTotalCosts.put(to, nodeTotalCosts.get(to) + nodeTotalCosts.get(from));
                }

                inDegrees.put(to, inDegrees.get(to) - 1);
                if (inDegrees.get(to) == 0) {
                    queue.offer(to);
                }
            }
        }

        return String.valueOf(answer);
    }

}
