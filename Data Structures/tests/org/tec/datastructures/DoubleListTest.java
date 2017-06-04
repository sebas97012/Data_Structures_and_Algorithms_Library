package org.tec.datastructures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class DoubleListTest {
    DoubleList DoubleTestList = new DoubleList();

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<=1000; i++){
            DoubleTestList.addToStart((int) (Math.random() * ((1000) + 1)));
        }
        System.out.println(DoubleTestList.toString());
    }

    @Test
    public void doubleList() throws Exception {
    }

    @Test
    public void getHead() throws Exception {
    }

    @Test
    public void addToStart() throws Exception {
    }

    @Test
    public void addToEnd() throws Exception {
    }

    @Test
    public void add() throws Exception {
    }

    @Test
    public void deleteFirst() throws Exception {
    }

    @Test
    public void deleteLast() throws Exception {
    }

    @Test
    public void deletePos() throws Exception {
    }

    @Test
    public void search() throws Exception {
    }
}