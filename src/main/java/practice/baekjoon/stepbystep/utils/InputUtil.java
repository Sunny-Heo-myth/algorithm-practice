package practice.baekjoon.stepbystep.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class InputUtil {

    /**
     * Get System input and sout applied answer.
     * @param p1 : solution function for a problem. The return value converted into String.
     * @param p2 : Auxiliary function for a problem. The return value converted into String.
     * @throws IOException
     */
    public static <T, U> void answer(Function<String, T> p1, Function<String, U> p2) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < cases) {
            String inputLine = bf.readLine();
            sb.append(p1.apply(inputLine)).append(" ").append(p2.apply(inputLine)).append("\n");
            count++;
        }

        System.out.print(sb.deleteCharAt(sb.length() - 1));
    }

}
