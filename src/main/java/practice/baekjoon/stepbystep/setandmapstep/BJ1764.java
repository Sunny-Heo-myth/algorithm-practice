package practice.baekjoon.stepbystep.setandmapstep;

import practice.baekjoon.utils.IOUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BJ1764 {
    private final Set<String> neverHeard;
    private final Set<String> neverSeen;

    public static void main(String[] args) throws IOException {
        String s = IOUtil.readFiniteLine();
        BJ1764 instance = new BJ1764(s);
        System.out.print(instance.answer());
    }

    public BJ1764(String input) {
        neverHeard = new HashSet<>();
        neverSeen = new HashSet<>();
        String[] lines = input.split("\n");
        String[] firstLine = lines[0].split(" ");
        int neverHeardCount = Integer.parseInt(firstLine[0]);
        int neverSeenCount = Integer.parseInt(firstLine[1]);
        neverHeard.addAll(Arrays.asList(lines).subList(1, neverHeardCount + 1));
        neverSeen.addAll(Arrays.asList(lines).subList(neverHeardCount + 1, neverHeardCount + neverSeenCount + 1));
    }

    public String answer() {
        List<String> neverHeardAndSeen = neverHeard.stream()
                        .filter(neverSeen::contains)
                        .sorted()
                        .collect(Collectors.toList());
        return neverHeardAndSeen.size() + toString(neverHeardAndSeen);
    }

    private String toString(List<String> stringList) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (String s : stringList) {
            sb.append(s).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
