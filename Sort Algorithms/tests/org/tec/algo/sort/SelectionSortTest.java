package org.tec.algo.sort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class SelectionSortTest {
    LinkedList TestList = new LinkedList();

    @Before
    public void setUp() throws Exception {
        for(int i=0; i<=10; i++){
            TestList.insertElement((int) (Math.random() * ((200) + 1)), i);
        }
        TestList.printList();
    }

    @Test
    public void insertionTest() throws Exception {
        TestList = SelectionSort.selectionSort(TestList);
    }

    @After
    public void insertionTestPrint() throws Exception {
        TestList.printList();
    }
}