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
public class IOUtil {

    public static void answer(Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> 0);
        System.out.print(solution.apply(input));
    }

    /**
     * Answer one question with input conditions are:
     * 1. The first line is total input line count.(except the first ine)
     * 2. Continuing input introduced at each line.
     *
     * @param solution
     * @return
     */
    public static void answer(Function<String, Integer> lineCounter,
                              Function<String, String> solution) throws IOException {
        String input = readFiniteLine(lineCounter);
        System.out.print(solution.apply(input));
    }

    public static void answer(int countFrom,
                              Function<String, Integer> lineCounter,
                              Function<String, String> solution) throws IOException {
        String input = readFiniteLine(countFrom, lineCounter);
        System.out.print(solution.apply(input));
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
        System.out.print(readFiniteLine(lineCounter).lines().skip(1).map(solution).collect(Collectors.joining("\n")));
    }

    public static void answerQuestions(Function<String, Integer> numberOfQuestionProvider,
                                       Function<String, Integer> numberOfInputLineCounter,
                                       Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int numberOfProblems = numberOfQuestionProvider.apply(bf.readLine());
        while (0 < numberOfProblems--) answer.append(solution.apply(readCountedLine(numberOfInputLineCounter, bf))).append("\n");
        bf.close();
        System.out.print(answer.substring(0, answer.length() - 1));
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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = 0;
        while (n++ < 2000000) { // do not let infinite loop
            String line = bf.readLine();
            if (endLineCondition.apply(line)) break;
            sb.append(line).append("\n");
        }
        bf.close();
        String input = sb.substring(0, sb.length() - 1);
        System.out.print(input.lines().map(solution).collect(Collectors.joining("\n")));
    }

    // todo: BJ JVM & local Main work different in terms of carriage return & line feed or IDK shit
    public static void answerQuestionsWithNoCondition(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) answer.append(solution.apply(line)).append("\n");
        bf.close();
        System.out.print(answer.substring(0, answer.length() - 1));
    }

    /**
     * Read the interpreted number of the first line.
     *
     * @param lineCounter A function provides number of line that it should read.
     * @return Console input
     * @throws IOException IOException when reading console.
     */
    public static String readFiniteLine(Function<String, Integer> lineCounter) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String countedLine = readCountedLine(lineCounter, bf);
        bf.close();
        return countedLine;
    }

    public static String readFiniteLine(int countingFrom,
                                        Function<String, Integer> lineCounter) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String countedLine = readCountedLine(s -> countingFrom, bf) + "\n" + readCountedLine(lineCounter, bf);
        bf.close();
        return countedLine;
    }

    public static String readCountedLine(Function<String, Integer> lineCounter,
                                         BufferedReader bf) throws IOException {
        String counter = bf.readLine();
        return counter + "\n" + IntStream.range(0, lineCounter.apply(counter))
                .mapToObj(i -> readLine(bf)).collect(Collectors.joining("\n"));
    }

    private static String readLine(BufferedReader bf) {
        try {
            return bf.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("BuffedReader#readLine IOException.");
        }
    }

}
