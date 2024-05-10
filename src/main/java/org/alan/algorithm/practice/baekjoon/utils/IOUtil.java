package org.alan.algorithm.practice.baekjoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is a utility class of various types of common inputs & outputs for algorithm problem.
 * All IOUtil return value should be String.
 */
// todo: resource open at where?
public class IOUtil {

    public static void answer(Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> 0);
        System.out.print(solution.apply(input.substring(0, input.length() - 1)));
    }

    public static void answer(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        System.out.print(solution.apply(readFiniteLine(lineCounter)));
    }

    public static void answer(int countFrom, Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution.apply(readCountedLine(s -> countFrom - 1, bf) + "\n" + readCountedLine(lineCounter, bf)));
        }
    }

    public static String readFiniteLine(Function<String, Integer> lineCounter) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            return readCountedLine(lineCounter, bf);
        }
    }

    public static String readCountedLine(Function<String, Integer> lineCounter, BufferedReader bf) {
        String numberOfLine = readLine(bf);
        Integer nol = lineCounter.apply(numberOfLine);
        return  nol <= 0 ? numberOfLine : numberOfLine + "\n" + IntStream.range(0, nol)
                .mapToObj(i -> readLine(bf)).collect(Collectors.joining("\n"));
    }

    private static String readLine(BufferedReader bf) {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("BuffedReader#readLine IOException.");
        }
    }

    /**
     * This function assumes the first line is the number of sub-problems given thus read input from the second line of input string.
     *
     * @param lineCounter {@link IOUtil#readFiniteLine(Function)}
     * @param solution    solution function which provides actual solution of the given problem.
     * @return answer string split by end-of-line.
     * @throws IOException
     */
    public static void answerQuestions(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        System.out.print(readFiniteLine(lineCounter).lines().skip(1).map(solution).collect(Collectors.joining("\n")));
    }

    public static void answerQuestions(Function<String, Integer> numberOfQuestionProvider,
                                       Function<String, Integer> numberOfInputLineCounter,
                                       Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(IntStream.range(0, numberOfQuestionProvider.apply(readLine(bf)))
                    .mapToObj(i -> solution.apply(readCountedLine(numberOfInputLineCounter, bf)))
                    .collect(Collectors.joining("\n")));
        }
    }

    /**
     * This method can not properly operate when the first line has the endOfLine condition.
     *
     * @param endLineCondition
     * @param solution
     * @return
     * @throws IOException
     */
    public static void answerQuestionsWithCondition(Function<String, Boolean> endLineCondition,
                                                    Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int n = 0;
            while (n++ < 1000000) {
                String line = readLine(bf);
                if (endLineCondition.apply(line)) break;
                sb.append(line).append("\n");
            }
            String input = sb.substring(0, sb.length());
            System.out.print(input.lines().map(solution).collect(Collectors.joining("\n")));
        }
    }

    // todo: BJ JVM & local Main work different in terms of carriage return & line feed or IDK shit
    public static void answerQuestionsWithNoCondition(Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder answer = new StringBuilder();
            String line;
            while ((line = readLine(bf)) != null || line.isEmpty()) answer.append(solution.apply(line)).append("\n");
            System.out.print(answer.substring(0, answer.length() - 1));
        }
    }

}
