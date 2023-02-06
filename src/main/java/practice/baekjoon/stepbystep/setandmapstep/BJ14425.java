package practice.baekjoon.stepbystep.setandmapstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ14425 {
    private final Map<String, Integer> map;
    private final int numberOfKey;
    private final int numberOfWord;
    private int match = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String firstLine = bf.readLine();
        sb.append(firstLine).append("\n");

        String[] firstLineWord = firstLine.split(" ");
        int n = Integer.parseInt(firstLineWord[0]) + Integer.parseInt(firstLineWord[1]);
        int i = 0;
        while (i < n) {
            sb.append(bf.readLine()).append("\n");

            i++;
        }

        BJ14425 instance = new BJ14425(sb.deleteCharAt(sb.length() - 1).toString());
        System.out.print(instance.match);
    }

    public BJ14425(String inputString) {
        String[] lines = inputString.split("\n");
        String[] firstLine = lines[0].split(" ");
        numberOfKey = Integer.parseInt(firstLine[0]);
        numberOfWord = Integer.parseInt(firstLine[1]);
        map = new HashMap<>();

        for (int i = 0; i < numberOfKey; i++) {
            map.put(lines[i + 1], 0);
        }

        for (int i = 0; i < numberOfWord; i++) {
            if (map.containsKey(lines[i + numberOfKey + 1])) {
                match++;
            }
        }
    }

    public int answer() {
        return match;
    }
}
