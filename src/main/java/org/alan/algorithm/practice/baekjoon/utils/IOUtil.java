package org.alan.algorithm.practice.baekjoon.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

/**
 * All IOUtil return value should be String.
 */
public class IOUtil {

    /**
     * This function assumes the first line is the number of sub-problems given thus read input from the second line of input string.
     *
     * @param lineCounter {@link IOUtil#readFiniteLine(Function)}
     * @param solution    solution function which provides actual solution of the given problem.
     * @return answer string split by end-of-line.
     * @throws IOException
     */
    public static void answerQuestions(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        String input = IOUtil.readFiniteLine(lineCounter);
        String[] inputs = input.split("\n");
        StringBuilder answer = new StringBuilder();
        for (int i = 1; i < inputs.length; i++) {
            answer.append(solution.apply(inputs[i])).append("\n");
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    /**
     * Answer one question with input conditions are:
     * 1. The first line is total input line count.(except the first ine)
     * 2. Continuing input introduced at each line.
     * @param solution
     * @return
     */
    public static void answer(Function<String, Integer> lineCounter, Function<String, String> solution) throws IOException {
        String input = readFiniteLine(lineCounter);
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
    public static void answerQuestionsWithEndLineCondition(Function<String, Boolean> endLineCondition, Function<String, String> solution) throws IOException {
        String input = IOUtil.readWithEndLineCondition(endLineCondition);
        String[] inputs = input.split("\n");
        StringBuilder answer = new StringBuilder();
        for (String s : inputs) {
            answer.append(solution.apply(s)).append("\n");
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    public static void answerEndLineConditionedQuestions(Function<String, Integer> numberOfQuestionProvider,
                                                         Function<String, Integer> questionEndLineCounter,
                                                         Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int numberOfProblems = numberOfQuestionProvider.apply(bf.readLine());

        StringBuilder answer = new StringBuilder();
        while (0 < numberOfProblems) {
            int n = questionEndLineCounter.apply(bf.readLine());

            StringBuilder input = new StringBuilder();
            int lineNumber = 0;
            while (lineNumber < n) {
                input.append(bf.readLine()).append("\n");
                lineNumber++;
            }

            answer.append(solution.apply(input.deleteCharAt(input.length() - 1).toString())).append("\n");
            numberOfProblems--;
        }

        bf.close();
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    public static void answer(Function<String, String> solution) throws IOException {
        String input = IOUtil.readFiniteLine(s -> 0);
        System.out.print(solution.apply(input));
    }

    public static void answer(int additionalLine, Function<String, String> solution) throws IOException {
        String input = IOUtil.readFiniteLine(s -> additionalLine);
        System.out.print(solution.apply(input));
    }

    /**
     * Give multiple answer in delimiter as lines.
     *
     * @param solution
     * @throws IOException
     */
    public static void answerQuestions(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = bf.readLine();   // After os buffer has all input value, let jvm read the first line.
        int n = Integer.parseInt(firstLine);
        String[] lines = new String[n];

        int i = 0;
        while (i < n) {
            String line = bf.readLine();
            lines[i] = line;
            i++;
        }
        bf.close();

        StringBuilder answer = new StringBuilder();
        for (String line : lines) {
            answer.append(solution.apply(line)).append("\n");
        }
        System.out.print(answer.deleteCharAt(answer.length() - 1));
    }

    // todo: BJ JVM & local Main work different in terms of carriage return & line feed or IDK shit
    public static void answerQuestionsWithNoEndLineCondition(Function<String, String> solution) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) {
            answer.append(solution.apply(line)).append("\n");
        }
        bf.close();
        System.out.print(answer.deleteCharAt(answer.length() - 1));
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
        String firstLine = bf.readLine();

        int n = lineCounter.apply(firstLine);
        int i = 0;
        sb.append(firstLine).append("\n");
        while (i < n) {
            sb.append(bf.readLine()).append("\n");
            i++;
        }

        bf.close();
        return sb.deleteCharAt(sb.length() - 1).toString();
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

        int i = 0;
        while (i < n) {
            sb.append(bf.readLine()).append("\n");
            i++;
        }

        bf.close();
        return sb.deleteCharAt(sb.length() - 1).toString();
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
        while (n < 2000000) { // do not let infinite loop
            String line = bf.readLine();
            if (endLineCondition.apply(line)) {
                break;
            }
            sb.append(line).append("\n");
            n++;
        }

        bf.close();
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String readWithNoEndLineCondition() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null) {
            sb.append(line).append("\n");
        }
        bf.close();
        return sb.toString();
    }

}
