package basic.recursion;


import org.junit.jupiter.api.Test;

import static basic.recursion.Factorial.whileFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecursionTest {

    @Test
    void whileFactorialTest() {
        assertEquals(whileFactorial(5), 120);
        assertEquals(whileFactorial(1), 1);
    }
}
