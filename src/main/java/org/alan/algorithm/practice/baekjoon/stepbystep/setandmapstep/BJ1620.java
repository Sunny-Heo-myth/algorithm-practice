package org.alan.algorithm.practice.baekjoon.stepbystep.setandmapstep;

import org.alan.algorithm.practice.baekjoon.utils.IOUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BJ1620 {
    private final int numberOfPokemon;
    private final Map<Integer, String> integerStringMap;
    private final Map<String, Integer> stringIntegerMap;

    private final int numberOfQuestion;
    private final Object[] questionList;

    public static void main(String[] args) throws IOException {
        String input = IOUtil.readFiniteLine(line -> {
            String[] strings = line.split(" ");
            return Integer.parseInt(strings[0]) + Integer.parseInt(strings[1]);
        });

        BJ1620 instance = new BJ1620(input);
        System.out.print(instance.answer());
    }

    public BJ1620(String inputString) {
        String[] lines = inputString.split("\n");
        String[] firstLine = lines[0].split(" ");

        numberOfPokemon = Integer.parseInt(firstLine[0]);
        integerStringMap = new HashMap<>();
        stringIntegerMap = new HashMap<>();
        for (int i = 0; i < numberOfPokemon; i++) {
            integerStringMap.put(i + 1, lines[i + 1]);
            stringIntegerMap.put(lines[i  + 1], i + 1);
        }

        numberOfQuestion = Integer.parseInt(firstLine[1]);
        questionList = new Object[numberOfQuestion];
        for (int i = 0; i < numberOfQuestion; i++) {
            String question = lines[numberOfPokemon + i + 1];
            try {
                questionList[i] = Integer.parseInt(question);
            } catch (NumberFormatException e) {
                questionList[i] = question;
            }
        }
    }

    public String answer() {
        StringBuilder answer = new StringBuilder();
        for (Object o : questionList) {
            if (o instanceof Integer) {
                Integer i = (Integer) o;
                answer.append(integerStringMap.get(i)).append("\n");
            } else {
                String s = (String) o;
                answer.append(stringIntegerMap.get(s)).append("\n");
            }
        }
        return answer.deleteCharAt(answer.length() - 1).toString();
    }
}
