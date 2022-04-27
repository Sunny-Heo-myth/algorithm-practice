package basic.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntPipeStackTest {

    IntPipeStack intPipeStack = new IntPipeStack(20);

    @BeforeEach
    public void pushPipeStack() {
        for (int i = 0; i < 11; i++) {
            intPipeStack.pushFront(i);
        }

        for (int i = 0; i < 9; i++) {
            intPipeStack.pushRear(100 + i);
        }
    }

    @Test
    public void pipeStackPopTest() {

        for (int i = 0; i < 11; i++) {
            System.out.println(intPipeStack.popFront());
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(intPipeStack.popRear());
        }
    }

    @Test
    public void pipeStackIndexOfTest() {
        assertEquals(intPipeStack.indexOfFront(10), 10);
    }
}
