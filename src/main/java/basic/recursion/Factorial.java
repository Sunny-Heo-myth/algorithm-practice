package basic.recursion;

public class Factorial {

    static int factorial(int number) {
        if (number > 0) {
            return factorial(number - 1);
        }
        else {
            return 1;
        }
    }

    static int whileFactorial(int number) {
        int result = 1;
        while (number != 0) {
            result *= number--;
        }
        return result;
    }
}
