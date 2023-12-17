package org.alan.algorithm.practice.baekjoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.regex.Pattern;

/**
 * This is a utility class of various types of common inputs & outputs for algorithm problem.
 * All IOUtil return value should be String.
 */
public class IOUtil {

    public static void answer(Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> 0);
        System.out.print(solution.apply(input));
    }


    public static void answer(int additionalLine,
                              Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> additionalLine);
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
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input =  readCountedLine(countFrom, lineCounter, bf, sb);
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
        StringBuilder answer = new StringBuilder();
        Pattern.compile("\n").splitAsStream(readFiniteLine(lineCounter)).skip(1)
                .forEach(s -> answer.append(solution.apply(s)).append("\n"));
        System.out.print(answer.substring(0, answer.length() - 1));
    }

    public static void answerQuestions(Function<String, Integer> numberOfQuestionProvider,
                                       int numberOfInputLine,
                                       Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int numberOfQuestions = numberOfQuestionProvider.apply(bf.readLine());
        while (0 < numberOfQuestions--) {
            StringBuilder input = new StringBuilder();
            int n = numberOfInputLine;
            while (0 < n--) input.append(bf.readLine()).append("\n");
            answer.append(solution.apply(input.substring(0, input.length() - 1))).append("\n");
        }
        bf.close();
        System.out.print(answer.substring(0, answer.length() - 1));
    }

    public static void answerQuestions(Function<String, Integer> numberOfQuestionProvider,
                                       Function<String, Integer> numberOfInputLineCounter,
                                       Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int numberOfProblems = numberOfQuestionProvider.apply(bf.readLine());
        while (0 < numberOfProblems--) {
            StringBuilder input = new StringBuilder();
            int n = numberOfInputLineCounter.apply(bf.readLine());
            input.append(n).append("\n");
            while (0 < n--) input.append(bf.readLine()).append("\n");
            answer.append(solution.apply(input.substring(0, input.length() - 1))).append("\n");
        }
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
        StringBuilder answer = new StringBuilder();
        Pattern.compile("\n").splitAsStream(input).forEach(s -> answer.append(solution.apply(s)).append("\n"));
        System.out.print(answer.substring(0, answer.length() - 1));
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
        StringBuilder sb = new StringBuilder();
        return readCountedLine(lineCounter, bf, sb);
    }

    public static String readFiniteLine(int countingFrom,
                                        Function<String, Integer> lineCounter) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        return readCountedLine(countingFrom, lineCounter, bf, sb);
    }


    public static String readCountedLine(Function<String, Integer> lineCounter,
                                         BufferedReader bf,
                                         StringBuilder sb) throws IOException {
        String counter = bf.readLine();
        sb.append(counter).append("\n");
        int numberOfLine = lineCounter.apply(counter);
        while (0 < numberOfLine--) sb.append(bf.readLine()).append("\n");
        bf.close();
        return sb.substring(0, sb.length() - 1);
    }

    public static String readCountedLine(int countingfrom,
                                         Function<String, Integer> lineCounter,
                                         BufferedReader bf,
                                         StringBuilder sb) throws IOException {
        while (--countingfrom > 0) sb.append(bf.readLine()).append("\n");
        return readCountedLine(lineCounter, bf, sb);
    }

}
