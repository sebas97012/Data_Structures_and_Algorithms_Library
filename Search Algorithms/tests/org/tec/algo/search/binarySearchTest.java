package org.tec.algo.search;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class binarySearchTest {
    LinkedList TestList = new LinkedList();

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<=10; i++){
            TestList.insertElement(i*3, i);
        }
    }

    @Test
    public void binarySearchFound() throws Exception{
        assertEquals(binarySearch.binarySearch1(TestList,15),1);
    }

    @Test
    public void binarySearchNotFound() throws Exception{
        assertEquals(binarySearch.binarySearch1(TestList,14),0);
    }
}