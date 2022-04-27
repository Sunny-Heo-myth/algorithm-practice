package challenges.SASA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SASA {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int s = Integer.parseInt(input.split(" ")[0]);
        int a = Integer.parseInt(input.split(" ")[1]);

        if(s >= a){
            System.out.println(a/2);
        }else{
            System.out.println(s/2);
        }
    }
}
