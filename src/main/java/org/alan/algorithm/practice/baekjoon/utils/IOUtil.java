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

    /**
     * Answer one question with input conditions are:
     * 1. The first line is total input line count.(except the first ine)
     * 2. Continuing input introduced at each line.
     *
     * @param solution
     * @return
     */
    public static void answer(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        String input = readFiniteLine(lineCounter);
        System.out.print(solution.apply(input));
    }

    public static void answer(int nthLine, Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        String input = readFiniteLine(nthLine, lineCounter);
        System.out.print(solution.apply(input));
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
        return getAnswerString(lineCounter, bf, sb);
    }

    public static String readFiniteLine(int nthLine, Function<String, Integer> lineCounter) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        nthLine -= 1;
        while (nthLine-- > 0) sb.append(bf.readLine()).append("\n");

        return getAnswerString(lineCounter, bf, sb);
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
        String input = readFiniteLine(lineCounter);
        String[] inputs = input.split("\n");
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < inputs.length; i++) answer.append(solution.apply(inputs[i])).append("\n");
        System.out.print(deleteLastCharacter(answer));
    }

    public static void answer(Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> 0);
        System.out.print(solution.apply(input));
    }

    public static void answer(int additionalLine, Function<String, String> solution) throws IOException {
        String input = readFiniteLine(s -> additionalLine);
        System.out.print(solution.apply(input));
    }

    /**
     * This method can not properly operate when the first line has the endOfLine condition.
     *
     * @param endLineCondition
     * @param solution
     * @return
     * @throws IOException
     */
    public static void answerQuestionsWithEndLineCondition(Function<String, Boolean> endLineCondition,
                                                           Function<String, String> solution) throws IOException {
        String input = readWithEndLineCondition(endLineCondition);
        StringBuilder answer = new StringBuilder();
        Pattern.compile("\n").splitAsStream(input).forEach(s -> answer.append(solution.apply(s)).append("\n"));
        System.out.print(deleteLastCharacter(answer));
    }

    public static void answerQuestionsWithLineCounter(Function<String, Integer> numberOfQuestionProvider,
                                                      Function<String, Integer> lineCounter,
                                                      Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder answer = new StringBuilder();
        int numberOfProblems = numberOfQuestionProvider.apply(bf.readLine());
        while (0 < numberOfProblems--) {
            StringBuilder input = new StringBuilder();
            int n = lineCounter.apply(bf.readLine());
            input.append(n).append("\n");
            while (0 < n--) input.append(bf.readLine()).append("\n");
            answer.append(solution.apply(deleteLastCharacter(input).toString())).append("\n");
        }

        bf.close();
        System.out.print(deleteLastCharacter(answer));
    }

    public static void answerQuestionsWithNumberOfLine(Function<String, Integer> numberOfQuestionProvider,
                                                       int numberOfLine,
                                                       Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int numberOfQuestions = numberOfQuestionProvider.apply(bf.readLine());
        while (0 < numberOfQuestions--) {
            StringBuilder input = new StringBuilder();
            int n = numberOfLine;
            while (0 < n--) input.append(bf.readLine()).append("\n");
            answer.append(solution.apply(input.toString())).append("\n");
        }
        bf.close();
        System.out.print(deleteLastCharacter(answer));
    }

    /**
     * Give multiple answer with delimiter as lines.
     *
     * @param solution
     * @throws IOException
     */
    public static void answerQuestions(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bf.readLine();   // After os buffer has all input value, let jvm read the first line.
        int n = Integer.parseInt(firstLine);
        String[] lines = new String[n];
        while (0 <= n--) lines[lines.length - n - 1] = bf.readLine();
        bf.close();

        StringBuilder answer = new StringBuilder();
        for (String line : lines) answer.append(solution.apply(line)).append("\n");
        System.out.print(deleteLastCharacter(answer));
    }

    // todo: BJ JVM & local Main work different in terms of carriage return & line feed or IDK shit
    public static void answerQuestionsWithNoEndLineCondition(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) answer.append(solution.apply(line)).append("\n");
        bf.close();
        System.out.print(deleteLastCharacter(answer));
    }

    /**
     * read n lines.
     *
     * @param n
     * @return
     * @throws IOException
     */
    public static String readFiniteLine(int n) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (0 < n--) sb.append(bf.readLine()).append("\n");
        bf.close();
        return deleteLastCharacter(sb).toString();
    }

    /**
     * read until the line meets the end condition
     *
     * @param endLineCondition
     * @return
     * @throws IOException
     */
    public static String readWithEndLineCondition(Function<String, Boolean> endLineCondition) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = 0;
        while (n++ < 2000000) { // do not let infinite loop
            String line = bf.readLine();
            if (endLineCondition.apply(line)) break;
            sb.append(line).append("\n");
        }

        bf.close();
        return deleteLastCharacter(sb).toString();
    }

    public static String readWithNoEndLineCondition() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) sb.append(line).append("\n");
        bf.close();
        return sb.toString();
    }

    private static String getAnswerString(Function<String, Integer> lineCounter, BufferedReader bf, StringBuilder sb) throws IOException {
        String counter = bf.readLine();
        sb.append(counter).append("\n");
        int n = lineCounter.apply(counter);
        while (0 < n--) sb.append(bf.readLine()).append("\n");
        bf.close();
        return deleteLastCharacter(sb).toString();
    }

    private static StringBuilder deleteLastCharacter(StringBuilder answer) {
        return answer.deleteCharAt(answer.length() - 1);
    }
}
