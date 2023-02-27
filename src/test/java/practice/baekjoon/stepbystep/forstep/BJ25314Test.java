package practice.baekjoon.stepbystep.forstep;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BJ25314Test {

    @Test
    void test1() {
        BJ25314 instance = new BJ25314(20);
        String expected = "long long long long long int";
        Assertions.assertEquals(expected, instance.answer());
    }
}
