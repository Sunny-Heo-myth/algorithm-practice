package org.alan.algorithm.practice.baekjoon.problem;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ11003 {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Deque<int[]> deque = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                while (!deque.isEmpty() && deque.peekLast()[0] > n) deque.pollLast();
                deque.offer(new int[]{n, i});
                if (deque.peek()[1] < i - (L - 1)) deque.poll();
                bw.write(deque.peek()[0] + " ");
            }
            bw.flush();
        }
    }

    public String solve2(String input) {
        String[] lines = input.split("\n");
        int L = Integer.parseInt(lines[0].split(" ")[1]);
        int[] array = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();

        List<Integer> answer = new ArrayList<>();
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            int n = array[i];
            while (!deque.isEmpty() && deque.peekLast()[0] > n) deque.pollLast();

            deque.offer(new int[]{n, i});
            if (deque.peek()[1] < i - (L - 1)) deque.poll();
            answer.add(deque.peek()[0]);
        }
        return answer.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
