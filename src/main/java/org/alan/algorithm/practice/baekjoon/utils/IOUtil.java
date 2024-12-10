package org.alan.algorithm.practice.baekjoon.utils;

import java.io.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This is a utility class of various types of common inputs & outputs for algorithm problem.
 * All IOUtil return value should be String.
 */
public class IOUtil {

    public static void answer(Function<String, String> solution) throws IOException {
        System.out.print(solution.apply(readFiniteLine(s -> 0)));
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
        return nol <= 0 ? numberOfLine : numberOfLine + "\n" + IntStream.range(0, nol)
                .mapToObj(i -> readLine(bf))
                .collect(Collectors.joining("\n"));
    }

    private static String readLine(BufferedReader bf) {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("BuffedReader#readLine IOException.");
        }
    }

    public static void answerQuestionWithCondition(Function<String, Boolean> endLineCondition,
                                                   Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int n = 0;
            while (n++ < 1000000) {
                String line = readLine(bf);
                if (endLineCondition.apply(line)) break;
                sb.append(line).append("\n");
            }
            System.out.print(solution.apply(sb.substring(0, sb.length() - 1)));
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
        System.out.print(readFiniteLine(lineCounter).lines()
                .skip(1)
                .map(solution)
                .collect(Collectors.joining("\n")));
    }

    public static void answerQuestions(Function<String, Integer> numberOfQuestionProvider,
                                       Function<String, Integer> numberOfInputLineCounter,
                                       Function<String, String> solution) throws IOException {  // todo: instantiation for each sub-problem
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(IntStream.range(0, numberOfQuestionProvider.apply(readLine(bf)))
                    .mapToObj(i -> solution.apply(readCountedLine(numberOfInputLineCounter, bf)))
                    .collect(Collectors.joining("\n")));
            bw.flush();
        }
    }

    public static void answerQuestionsWithEndCondition(Function<String, Integer> numberOfInputLineCounter,
                                                       Predicate<String> terminationCondition,
                                                       Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder totalAnswer = new StringBuilder();

            int i = 1000000;
            while (i-- > 0) {
                String line = readLine(bf);
                if (terminationCondition.test(line)) break;

                StringBuilder input = new StringBuilder();
                input.append(line).append("\n");

                int numberOfLines = numberOfInputLineCounter.apply(line);
                while (numberOfLines-- > 0) input.append(readLine(bf)).append("\n");
                totalAnswer.append(solution.apply(input.toString())).append("\n");
            }

            bw.write(totalAnswer.toString());
            bw.flush();
        }
    }

    public static void answerQuestionsWithEndCondition(Function<String, Integer> numberOfQuestionProvider,
                                                       Function<String, String> solution,
                                                       Predicate<String> terminationCondition) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfQuestions = numberOfQuestionProvider.apply(bf.readLine());
            int i = 0;
            while (i++ < numberOfQuestions) {
                StringBuilder input = new StringBuilder();
                int numberOfLines = 0;
                while (numberOfLines++ < 1000000) {
                    String line = readLine(bf);
                    if (terminationCondition.test(line)) break;
                    input.append(line).append("\n");
                }
                bw.write(solution.apply(input.append(i).toString()) + "\n");
            }
            bw.flush();
        }
    }

    public static void answerSingleLinedQuestionsWithNoEndCondition(Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder answer = new StringBuilder();

            String line;
            while ((line = bf.readLine()) != null)
                answer.append(solution.apply(line)).append("\n");

            bw.write(answer.toString());
            bw.flush();
        }
    }

}
