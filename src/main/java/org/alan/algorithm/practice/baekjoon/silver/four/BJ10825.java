package org.alan.algorithm.practice.baekjoon.silver.four;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BJ10825 {

    public String solve(String input) {
        return Pattern.compile("\n").splitAsStream(input).skip(1)
                .map(Member::new).sorted().map(Member::toString).collect(Collectors.joining("\n"));
    }

    private static class Member implements Comparable<Member> {
        private final String name;
        private final int koreanScore;
        private final int englishScore;
        private final int mathScore;

        public Member(String line) {
            String[] s = line.split(" ");
            this.name = s[0];
            this.koreanScore = Integer.parseInt(s[1]);
            this.englishScore = Integer.parseInt(s[2]);
            this.mathScore = Integer.parseInt(s[3]);
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public int compareTo(Member m) {
            if (m.koreanScore != this.koreanScore) return m.koreanScore - this.koreanScore;
            if (this.englishScore != m.englishScore) return this.englishScore - m.englishScore;
            if (m.mathScore != this.mathScore) return m.mathScore - this.mathScore;
            return  this.name.compareTo(m.name);
        }
    }
}
