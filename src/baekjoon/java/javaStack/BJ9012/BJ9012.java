package baekjoon.java.javaStack.BJ9012;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9012 {

    public static final char LEFT_PARENTHESES = '(';
    //public static final char RIGHT_PARENTHESES = ')';

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(bf.readLine());

        for(int i = 0; i < inputCount; i++){
            String string = bf.readLine();
            System.out.println(vps(string));
        }

    }

    public static String vps(String input){
        int count = 0;
        int countLeft = 0;
        int countRight = 0;

        while(count < input.length()){

            if(input.charAt(count) == LEFT_PARENTHESES){
                countLeft += 1;
            }else{
                countRight += 1;
            }

            if(countLeft < countRight){
                return "NO";
            }

            count += 1;
        }

        if(countLeft != countRight){
            return "NO";
        }

        return "YES";
    }
}
