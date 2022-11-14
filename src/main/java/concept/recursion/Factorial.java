package concept.recursion;

public class Factorial {

    public static int factorial(int number) {
        if (number > 0) {
            return factorial(number - 1);
        }
        else {
            return 1;
        }
    }

    public static int whileFactorial(int number) {
        int result = 1;
        while (number != 0) {
            result *= number--;
        }
        return result;
    }
}
