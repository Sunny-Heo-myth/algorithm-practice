package baekjoon.java.javaIf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ14681 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int axis1st = Integer.parseInt(bf.readLine());
        int axis2nd = Integer.parseInt(bf.readLine());
        bf.close();
        if (axis1st > 0 && axis2nd > 0) System.out.println(1);
        else if (axis1st < 0 && axis2nd > 0) System.out.println(2);
        else if (axis1st < 0 && axis2nd < 0) System.out.println(3);
        else System.out.println(4);

    }


}
