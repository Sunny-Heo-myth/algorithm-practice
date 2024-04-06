package org.alan.algorithm.practice.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KeyboardTransform {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String operations = bf.readLine();

        StringBuilder text = new StringBuilder();
        String line;
        while ((line = bf.readLine()) != null && !line.isEmpty()) {
            text.append(line).append("\n");
        }

        System.out.print(solve2(operations, text.toString()));
        bf.close();
    }

    private static final Character[][] qwerty = Pattern.compile(" ").splitAsStream("1234567890 qwertyuiop asdfghjkl; zxcvbnm,./")
            .map(s -> s.chars().mapToObj(i -> (char) i).toArray(Character[]::new)).toArray(Character[][]::new);
    private static Character[][] tQwerty = new Character[4][10];

    public static String solve2(String seq, String text) {
        IntStream.range(0, 4).forEach(i -> System.arraycopy(qwerty[i], 0, tQwerty[i], 0, 10));
        Map<Character, Character> map = new HashMap<>();

        String[] operations = Pattern.compile(",").splitAsStream(seq).toArray(String[]::new);
        for (String o : operations) switch (o) {
            case "H": hFlip(); break;
            case "V": vFlip(); break;
            default: shift(Integer.parseInt(o));
        }

        for (int i = 0; i < 4; i++) for (int j = 0; j < 10; j++) {
            map.put(qwerty[i][j], tQwerty[i][j]);
        }

        return text.chars().mapToObj(ch -> String.valueOf(map.computeIfAbsent((char) ch, Function.identity()))).collect(Collectors.joining());
    }

    private static void shift(int s) {
        int enhancedS = s % 40;
        List<Character> charList = Arrays.stream(tQwerty).flatMap(Arrays::stream).collect(Collectors.toList());
        if (enhancedS > 0) IntStream.range(0, enhancedS).forEach(i -> charList.add(0, charList.remove(charList.size() - 1)));
        if (enhancedS < 0) IntStream.range(0, -enhancedS).forEach(i -> charList.add(charList.remove(0)));
        tQwerty = IntStream.range(0, 4).mapToObj(i -> charList.subList(10 * i, 10 * i + 10).toArray(Character[]::new)).toArray(Character[][]::new);
    }

    private static void vFlip() {
        for (int i = 0; i < 2; i++) {
            Character[] temp = tQwerty[3 - i];
            tQwerty[3 - i] = tQwerty[i];
            tQwerty[i] = temp;
        }
    }

    private static void hFlip() {
        for (int i = 0; i < 4; i++) {
            List<Character> temp = Arrays.stream(tQwerty[i]).collect(Collectors.toList());
            Collections.reverse(temp);
            tQwerty[i] = temp.toArray(new Character[0]);
        }
    }

}
