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

    public static void answer(Function<String, Integer> lineCounter,
                              Function<String, String> solution) throws IOException {
        System.out.print(solution.apply(readFiniteLine(lineCounter)));
    }

    public static void answer(int countFrom,
                              Function<String, Integer> lineCounter,
                              Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print(solution.apply(readCountedLine(s -> countFrom - 1, bf) + "\n" + readCountedLine(lineCounter, bf)));
        }
    }

    public static String readFiniteLine(Function<String, Integer> lineCounter) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            return readCountedLine(lineCounter, bf);
        }
    }

    public static String readCountedLine(Function<String, Integer> lineCounter,
                                         BufferedReader bf) {
        String numberOfLine = readLine(bf);
        int nol = lineCounter.apply(numberOfLine);
        if (nol <= 0) return numberOfLine;

        return numberOfLine + "\n" + IntStream.range(0, nol)
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

    public static void answerQuestionWithCondition(Function<String, Boolean> endOfInputPredicate,
                                                   Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            int n = 0;
            while (n++ < 1000000) {
                String line = readLine(bf);
                if (endOfInputPredicate.apply(line)) {
                    break;
                }
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
    public static void answerQuestions(Function<String, Integer> lineCounter,
                                       Function<String, String> solution) throws IOException {
        System.out.print(readFiniteLine(lineCounter).lines()
                .skip(1)
                .map(solution)
                .collect(Collectors.joining("\n")));
    }

    public static void answerQuestions(Function<String, Integer> questionCounter,
                                       Function<String, Integer> questionInputLineCounter,
                                       Function<String, String> solution) throws IOException {  // todo: instantiation for each sub-problem
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            bw.write(IntStream.range(0, questionCounter.apply(readLine(bf)))
                    .mapToObj(i -> solution.apply(readCountedLine(questionInputLineCounter, bf)))
                    .collect(Collectors.joining("\n")));
            bw.flush();
        }
    }

    public static void answerQuestionsWith2EndCondition(Predicate<String> questionEndOfInputPredicate,
                                                        Predicate<String> endOfInputPredicate,
                                                        Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder answer = new StringBuilder();

            StringBuilder input = new StringBuilder();
            int i = 10_000_000;
            while (i-- > 0) {
                String line = readLine(bf);
                if (endOfInputPredicate.test(line)) break;

                if (questionEndOfInputPredicate.test(line)) {
                    String subAnswer = solution.apply(input.substring(0, input.length() - 1));
                    answer.append(subAnswer).append("\n");
                    input = new StringBuilder();
                } else {
                    input.append(line).append("\n");
                }
            }

            bw.write(answer.substring(0, answer.length() - 1));
            bw.flush();
        }
    }

    public static void answerQuestionsWithEndCondition(Function<String, Integer> questionInputLineCounter,
                                                       Predicate<String> endOfInputPredicate,
                                                       Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder answer = new StringBuilder();

            int i = 1_000_000;
            while (i-- > 0) {
                String line = readLine(bf);
                if (endOfInputPredicate.test(line)) {
                    break;
                }

                StringBuilder input = new StringBuilder();
                input.append(line).append("\n");

                int numberOfLines = questionInputLineCounter.apply(line);
                while (numberOfLines-- > 0) input.append(readLine(bf)).append("\n");
                answer.append(solution.apply(input.substring(0, input.length() - 1))).append("\n");
            }

            bw.write(answer.substring(0, answer.length() - 1));
            bw.flush();
        }
    }

    public static void answerQuestionsWithEndCondition2(Function<String, Integer> questionCounter,
                                                       Function<String, String> solution,
                                                       Predicate<String> endOfInputPredicate) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int numberOfQuestions = questionCounter.apply(bf.readLine());
            int i = 0;
            while (i++ < numberOfQuestions) {
                StringBuilder input = new StringBuilder();
                int numberOfLines = 0;
                while (numberOfLines++ < 1000000) {
                    String line = readLine(bf);
                    if (endOfInputPredicate.test(line)) {
                        break;
                    }
                    input.append(line).append("\n");
                }
                bw.write(solution.apply(input.append(i).toString()) + "\n");
            }
            bw.flush();
        }
    }

    /**
     * Each question input is a single line.
     *
     * @param solution
     * @throws IOException
     */
    public static void answerQuestionsWithNoEndCondition(Function<String, String> solution) throws IOException {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringBuilder answer = new StringBuilder();

            String line;
            while ((line = bf.readLine()) != null) answer.append(solution.apply(line)).append("\n");

            bw.write(answer.toString());
            bw.flush();
        }
    }

}
