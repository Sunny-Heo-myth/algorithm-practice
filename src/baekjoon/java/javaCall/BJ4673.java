package baekjoon.java.javaCall;

public class BJ4673 {

    public static void main(String[] args) {
        boolean[] booleans = new boolean[10000];
        for (int i = 0; i < 10000; i++) {
            int y = self(i + 1);
            if (y <= 10000) booleans[y - 1] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) if (!booleans[i]) sb.append(i + 1).append("\n");
        System.out.println(sb);
    }

    static int self(int x) {
        String string = Integer.toString(x);
        int length = string.length();
        int sum = x;
        for (int i = 0; i < length; i++) sum += Character.getNumericValue(string.charAt(i));
        return sum;
    }

}
