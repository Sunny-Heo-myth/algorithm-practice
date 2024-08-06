package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * N명의 학생들을 키 순서대로 줄을 세우려고 한다. 각 학생의 키를 직접 재서 정렬하면 간단하겠지만, 마땅한 방법이 없어서 두 학생의 키를 비교하는 방법을 사용하기로 하였다.
 * 그나마도 모든 학생들을 다 비교해 본 것이 아니고, 일부 학생들의 키만을 비교해 보았다.
 * 일부 학생들의 키를 비교한 결과가 주어졌을 때, 줄을 세우는 프로그램을 작성하시오.
 */
public class BJ2252 {
    public String solve(String input) {
        int n = Integer.parseInt(input.split("\n")[0].split(" ")[0]);
        int[] inDegreeArray = new int[n + 1];

        List<List<Integer>> outDegreeList = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) outDegreeList.add(new ArrayList<>());
        
        input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .peek(line -> inDegreeArray[line[1]]++)
                .forEach(line -> outDegreeList.get(line[0]).add(line[1]));

        List<Integer> studentList = new LinkedList<>();

        Queue<Integer> zeroInDegreeQueue = new LinkedList<>();
        IntStream.range(1, inDegreeArray.length)
                .filter(student -> inDegreeArray[student] == 0)
                .peek(studentList::add)
                .forEach(zeroInDegreeQueue::offer);

        while (!zeroInDegreeQueue.isEmpty()) {
            outDegreeList.get(zeroInDegreeQueue.poll()).stream()
                    .peek(later -> inDegreeArray[later]--)
                    .filter(later -> inDegreeArray[later] == 0)
                    .peek(studentList::add)
                    .forEach(zeroInDegreeQueue::offer);
        }
        return studentList.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
