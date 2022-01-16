package programmers.sichuanCastle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Programmers1836_4 {

    public static void main(String[] args) {
        // AEFGHKLMDOQRSTNU
        String[] s =   {"M...M...DU",
            "....AR...R",
            "...E..OH.H",
            ".....O....",
            ".E..A..Q..",
            "Q....LL.*.",
            ".D.N.....U",
            "GT.T...F..",
            "....FKS...",
            "GN....K..S"};
        System.out.println(solution(10 ,10, s));
    }

    static String solution(int m, int n, String[] board) {
        char[][] chars = new char[m][n];
        IntStream.range(0, m)
            .forEach(i -> IntStream.range(0, n)
                .forEach(j -> chars[i][j] = board[i].charAt(j)));

        Character[][] chars2 = new Character[m][n];
        Arrays.stream(board)
            .forEach(string -> string.chars()
                .mapToObj(i -> (char) i)
                .toArray(Character[]::new)
            );

        HashMap<Character, Bloook> workList = new HashMap<>();
        for (int i = 0; i < chars.length; i++) for (int j = 0; j < chars[0].length; j++) {
            char aChar = chars[i][j];

            if (aChar == '*' || aChar == '.') {
                continue;
            }

            if (!workList.containsKey(aChar)) {
                workList.put(aChar, new Bloook(i, j, -1, -1, aChar));
            }
            else {
                workList.get(aChar).nextAxis1st = i;
                workList.get(aChar).nextAxis2nd = j;
            }
        }

        StringBuilder result = new StringBuilder();
        ArrayList<Bloook> blooks = new ArrayList<>(workList.values());
        while (!blooks.isEmpty()) {
            ArrayList<Bloook> deletableList = new ArrayList<>();

            blooks.stream()
                .filter(bloook -> deletable(copyAndFlip(chars, bloook)))
                .forEach(deletableList::add);

            if(deletableList.size() == 0) return "IMPOSSIBLE";

            Bloook delete = new Bloook(-1, -1, -1, -1, '~');
            for(Bloook b : deletableList) if (b.aChar < delete.aChar) delete = b;
            chars[delete.nowAxis1st][delete.nowAxis2nd] = '.';
            chars[delete.nextAxis1st][delete.nextAxis2nd] = '.';
            result.append(delete.aChar);
            blooks.remove(delete);
        }
        return result.toString();
    }

    static char[][] copyAndFlip(char[][] original, Bloook blook) {
        int now1st = blook.nowAxis1st;
        int now2nd = blook.nowAxis2nd;
        int next1st = blook.nextAxis1st;
        int next2nd = blook.nextAxis2nd;
        int length1st = Math.abs(next1st - now1st) + 1;
        int length2nd = Math.abs(next2nd - now2nd) + 1;
        char[][] chars = new char[length1st][length2nd];

        if (now1st <= next1st && now2nd <= next2nd) {
            for (int i = 0; i < length1st; i++)
                System.arraycopy(original[now1st + i], now2nd, chars[i], 0, length2nd);
        }
        if (now1st <= next1st && now2nd > next2nd) {
            flip(original, now1st, next2nd, length1st, length2nd, chars);
        }
        if (now1st > next1st && now2nd <= next2nd) {
            for (int i = 0; i < length1st; i++)
                System.arraycopy(original[next1st + i], now2nd, chars[i], 0, length2nd);
        }
        if (now1st > next1st && now2nd > next2nd) {
            flip(original, next1st, next2nd, length1st, length2nd, chars);
        }
        return chars;
    }

    private static void flip(char[][] original, int next1st, int next2nd, int length1st,
        int length2nd, char[][] chars) {
        for (int i = 0; i < length1st; i++) {
            System.arraycopy(original[next1st + i], next2nd, chars[i], 0, length2nd);
            char[] instant = new char[length2nd];
            for (int j = length2nd - 1; j >= 0; j--) instant[j] = chars[i][length2nd - j - 1];
            chars[i] = instant;
        }
    }

    static boolean deletable(char[][] chars) {
        int length1st = chars.length;
        int length2nd = chars[0].length;
        int distance = length1st + length2nd - 3;

        int step = 1;
        int count = 0;
        while (step <= distance) {
            if (step < length1st && chars[step][0] == '.') count++;
            if (step >= length1st && chars[length1st - 1][step - length1st + 1] == '.') count++;
            step++;
        }
        if (count == distance) return true;

        step = 1;
        count = 0;
        while (step <= distance) {
            if (step < length2nd && chars[0][step] == '.') count++;
            if (step >= length2nd && chars[step - length2nd + 1][length2nd - 1] == '.') count++;
            step++;
        }
        return count == distance;
    }
}

class Bloook {
    int nowAxis1st;
    int nowAxis2nd;
    int nextAxis1st;
    int nextAxis2nd;
    char aChar;

    public Bloook(int nowAxis1st, int nowAxis2nd, int nextAxis1st, int nextAxis2nd, char aChar) {
        this.nowAxis1st = nowAxis1st;
        this.nowAxis2nd = nowAxis2nd;
        this.nextAxis1st = nextAxis1st;
        this.nextAxis2nd = nextAxis2nd;
        this.aChar = aChar;
    }
}
