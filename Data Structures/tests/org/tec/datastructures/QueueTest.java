package org.tec.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by sebas97012 on 6/4/17.
 */
public class QueueTest {
    Queue TestQueue = new Queue();

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<=1000; i++){
            TestQueue.enqueue((int) (Math.random() * ((1000) + 1)));
        }
    }

    @Test
    public void isEmpty() throws Exception {
        System.out.println(TestQueue.isEmpty());
    }

    @Test
    public void getLength() throws Exception {
        System.out.println(TestQueue.getLength());
    }

    @Test
    public void dequeue() throws Exception {
        TestQueue.dequeue();
    }

    @Test
    public void enqueue() throws Exception {
        TestQueue.enqueue("Prueba");
    }

    @Test
    public void pop() throws Exception {
        TestQueue.pop();
    }

    @Test
    public void peek() throws Exception {
        System.out.println(TestQueue.peek());
    }

    @Test
    public void search() throws Exception {
        TestQueue.search((int) (Math.random() * ((1000) + 1)));
    }

    @After
    public void setUp2() throws Exception {
        TestQueue.printQueue();
    }
}