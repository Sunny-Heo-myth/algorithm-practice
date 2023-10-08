package org.alan.algorithm.datastructure.queue;

import org.alan.algorithm.ioa.datastructure.queue.BookIntQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntQueueTest {

    BookIntQueue intQueue = new BookIntQueue(10);

    @BeforeEach
    void initializeIntQueue() {

        for (int i = 0; i < 10; i++) {
            intQueue.enQueue(i * 2);
        }
    }

    @Test
    void deQueueTest() {
        assertEquals(0, intQueue.deQueue());
        assertEquals(2, intQueue.deQueue());
        assertEquals(4, intQueue.deQueue());
        assertEquals(6, intQueue.deQueue());
        assertEquals(8, intQueue.deQueue());
        assertEquals(10, intQueue.deQueue());
        assertEquals(12, intQueue.deQueue());
        assertEquals(14, intQueue.deQueue());
        assertEquals(16, intQueue.deQueue());
        assertEquals(18, intQueue.deQueue());
    }
}
