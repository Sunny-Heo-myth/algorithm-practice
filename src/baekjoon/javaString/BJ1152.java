package baekjoon.javaString;

import java.io.IOException;

public class BJ1152 {

    public static void main(String[] args) throws IOException {
        int count = 0;
        int ch;
        int previousCh = 32;
        while (true) {
            ch = System.in.read();
            if(ch == 32 && previousCh != 32) count++;
            else if (ch == 10) {
                if (previousCh != 32) count++;
                break;
            }
            previousCh = ch;
        }
        System.out.print(count);
    }
}
