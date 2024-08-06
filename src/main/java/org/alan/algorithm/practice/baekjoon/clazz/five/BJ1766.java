package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BJ1766 {
    public String solve(String input) {
        List<List<Integer>> incidenceList = IntStream.rangeClosed(0, Integer.parseInt(input.split("\n")[0].split(" ")[0]))
                .mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());
        int[] inDegreeArray = new int[incidenceList.size()];

        input.lines().skip(1)
                .map(directedEdge -> Pattern.compile(" ").splitAsStream(directedEdge).mapToInt(Integer::parseInt).toArray())
                .peek(directedEdge -> inDegreeArray[directedEdge[1]]++)
                .forEach(directedEdge -> incidenceList.get(directedEdge[0]).add(directedEdge[1]));

        PriorityQueue<Integer> inDegreeZeroPq = new PriorityQueue<>();
        IntStream.range(1, inDegreeArray.length).filter(idx -> inDegreeArray[idx] == 0).forEach(inDegreeZeroPq::offer);

        List<Integer> answer = new ArrayList<>();
        while (!inDegreeZeroPq.isEmpty()) {
            Integer inDegreeZero = inDegreeZeroPq.poll();
            answer.add(inDegreeZero);

            for (Integer vertex : incidenceList.get(inDegreeZero)) {
                if (inDegreeArray[vertex] != 0) inDegreeArray[vertex]--;
                if (inDegreeArray[vertex] == 0) inDegreeZeroPq.offer(vertex);
            }
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
