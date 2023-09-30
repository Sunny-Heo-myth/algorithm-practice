package org.alan.algorithm.practice.baekjoon.stepbystep.deeptwo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ20920 {
    public String solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() < m) {
                continue;
            }
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(map.keySet());
        words.sort((w1, w2) -> {
            if (!Objects.equals(map.get(w1), map.get(w2))) {
                return Integer.compare(map.get(w2), map.get(w1));
            }
            if (w1.length() != w2.length()) {
                return w2.length() - w1.length();
            }
            return w1.compareTo(w2);
        });

        StringBuilder sb = new StringBuilder();
        words.forEach(word -> sb.append(word).append("\n"));
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
