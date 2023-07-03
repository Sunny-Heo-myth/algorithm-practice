package org.alan.algorithm.practice.baekjoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class IOUtil {

    /**
     * This function assumes the first line is the number of sub-problems given thus read input from the second line of input string.
     * @param lineCounter {@link org.alan.algorithm.practice.baekjoon.utils.IOUtil#readFiniteLine(java.util.function.Function)}
     * @param solution solution function which provides actual solution of the given problem.
     * @return answer string split by end-of-line.
     * @throws IOException
     */
    public static String answer(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        String input = IOUtil.readFiniteLine(lineCounter);
        String[] inputs = input.split("\n");
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < inputs.length; i++) {
            answer.append(solution.apply(inputs[i])).append("\n");
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    /**
     * A method read String from console with lambda counting readable number of line.
     * @param lineCounter A function provides number of line that it should read.
     * @return Console input
     * @throws IOException IOException when reading console.
     */
    public static String readFiniteLine(Function<String, Integer> lineCounter) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String firstLine = bf.readLine();

        sb.append(firstLine).append("\n");
        int n = lineCounter.apply(firstLine);
        int i = 0;
        while (i < n) {
            sb.append(bf.readLine()).append("\n");
            i++;
        }

        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String answer(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) {
            sb.append(solution.apply(line)).append("\n");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}
