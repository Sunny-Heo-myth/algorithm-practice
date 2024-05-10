package org.alan.algorithm.practice.baekjoon;

import org.alan.algorithm.practice.baekjoon.silver.one.BJ2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        answer(1, Integer::parseInt, new BJ2302()::solve);
    }
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
}
