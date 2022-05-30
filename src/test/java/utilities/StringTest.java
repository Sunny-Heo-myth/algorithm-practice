package utilities;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void subStringTest() {
        String s = "123456";
        System.out.println(s.substring(0, 3));
        System.out.println(s.substring(0, 6));
    }
}
