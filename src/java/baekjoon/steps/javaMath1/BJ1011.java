package baekjoon.steps.javaMath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1011 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int distance = b - a;
            double day = 2 * Math.sqrt(distance + 0.25) - 1;
            int maxDay = (int) (Math.ceil(day) % 2 == 1 ? Math.ceil(day) + 1 : Math.ceil(day));
            int maxDistance = (maxDay/2 + 1) * maxDay/2;
            int deter = maxDistance - maxDay/2;
            System.out.println(distance <= deter ? maxDay - 1 : maxDay);
        }
    }
}
