package lab.etc;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionTest {

    public static void main(String args[]) throws IOException {
        FileInputStream input1 = null;
        input1 = new FileInputStream("D:/file.txt");

        int m;
        while ((m = input1.read()) != -1) {
            System.out.print((char)m);
        }

        input1.close();
    }
}

