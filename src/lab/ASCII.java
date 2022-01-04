package lab;

public class ASCII {

    public static void main(String[] args) {
        char a = 'a';
        char z = 'z';
        char A = 'A';
        char Z = 'Z';
        System.out.println(Character.getNumericValue(a) +
            "\n" + Character.getNumericValue(A) +
            "\n" + Character.getNumericValue(z) +
            "\n" + Character.getNumericValue(Z));
        System.out.print((char) 65);
    }
}
