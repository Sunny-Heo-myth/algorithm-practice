package org.alan.algorithm.practice.baekjoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class IOUtil {

    /**
     * This function assumes the first line is the number of sub-problems given thus read input from the second line of input string.
     * @param lineCounter {@link IOUtil#readFiniteLine(Function)}
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
     * This method can not properly operate when the first line has the endOfLine condition.
     * @param endLineCondition
     * @param solution
     * @return
     * @throws IOException
     */
    public static String answerWithEndLineCondition(Function<String, Boolean> endLineCondition, Function<String, String> solution) throws IOException {
        String input = IOUtil.readLineUntil(endLineCondition);
        String[] inputs = input.split("\n");
        StringBuilder answer = new StringBuilder();
        for (String s : inputs) {
            answer.append(solution.apply(s)).append("\n");
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }

    public static String answer(Function<String, String> solution) throws IOException {
        String input = IOUtil.readFiniteLine(s -> 0);
        return solution.apply(input);
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

        bf.close();
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String readLineUntil(Function<String, Boolean> endLineCondition) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int maxLine = 20;
        int currentLine = 0;
        while (currentLine < maxLine) {
            currentLine++;
            String line = bf.readLine();
            if (endLineCondition.apply(line)) {
                break;
            }
            sb.append(line).append("\n");
        }
        bf.close();

        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
