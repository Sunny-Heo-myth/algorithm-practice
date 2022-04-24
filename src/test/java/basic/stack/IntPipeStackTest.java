package basic.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntPipeStackTest {

    IntPipeStack intPipeStack = new IntPipeStack(20);

    @BeforeEach
    public void pushPipeStack() {
        for (int i = 0; i < 11; i++) {
            intPipeStack.lowEdgePush(i);
        }

        for (int i = 0; i < 9; i++) {
            intPipeStack.highEdgePush(100 + i);
        }
    }

    @Test
    public void pipeStackTest() {




        for (int i = 0; i < 11; i++) {
            System.out.println(intPipeStack.highEdgePop());
        }

        for (int i = 0; i < 9; i++) {
            System.out.println(intPipeStack.highEdgePop());
        }

//        System.out.println(intPipeStack.lowIndexOf(4));
    }
}
