package org.tec.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class StackTest {
    Stack TestStack = new Stack();
    @Before
    public void setUp() throws Exception {
        for (int i = 0; i <= 999; i++) {
            TestStack.push((int) (Math.random() * ((1000) + 1)));
        }
    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(TestStack.isEmpty(),false);
    }

    @Test
    public void getLength() throws Exception {
        assertEquals(TestStack.getLength(),1000);
    }

    @Test
    public void push() throws Exception {
        TestStack.push("inicio");
        assertEquals(TestStack.peek(),"inicio");
    }

    @Test
    public void pop() throws Exception {
        TestStack.push("inicio");
        TestStack.push("inicio2");
        TestStack.pop();
        assertEquals(TestStack.peek(),"inicio");
    }


}