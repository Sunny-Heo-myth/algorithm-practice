package practice.baekjoon.stepbystep.forstep;

import java.util.Scanner;

public class BJ25314 {
    private final int repeatCount;
    private static final String LONG_ = "long ";
    private static final String INT = "int";
    public BJ25314(int i) {
        this.repeatCount = i / 4;
    }

    public String answer() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < repeatCount; i++) {
            sb.append(LONG_);
        }
        return sb.append(INT).toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BJ25314 instance = new BJ25314(scanner.nextInt());
        scanner.close();
        System.out.print(instance.answer());
    }
}
