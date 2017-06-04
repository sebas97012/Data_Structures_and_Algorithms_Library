package org.tec.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/3/17.
 */
public class LinkedListTest {
    LinkedList TestList = new LinkedList();

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<=1000; i++){
            TestList.insertElement((int) (Math.random() * ((1000) + 1)), i);
        }
        TestList.printList();
    }
    @Test
    public void getFirst() throws Exception {

    }

    @Test
    public void setFirst() throws Exception {
    }

    @Test
    public void getSize() throws Exception {
    }

    @Test
    public void insertAtFirst() throws Exception {
    }

    @Test
    public void insertAtEnd() throws Exception {
    }

    @Test
    public void getElement() throws Exception {
    }

    @Test
    public void deleteFirst() throws Exception {
    }

    @Test
    public void insertElement() throws Exception {
    }

    @Test
    public void deleteElement() throws Exception {
    }

    @Test
    public void deleteElement1() throws Exception {
    }

    @Test
    public void cleanList() throws Exception {
    }

    @Test
    public void printList() throws Exception {
    }

   @After
    public void after() throws Exception {
        TestList.cleanList();
    }
}