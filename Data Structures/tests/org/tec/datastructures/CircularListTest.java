package org.tec.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class CircularListTest {
    CircularList CircularTestList = new CircularList();
    @Before
    public void setUp() throws Exception {
        for(int i=1; i<=999; i++){
            CircularTestList.addToStart((int) (Math.random() * ((1000) + 1)));
        }

    }

    @Test
    public void isEmpty() throws Exception {
        assertEquals(CircularTestList.isEmpty(),false);
    }

    @Test
    public void getlength() throws Exception {
        assertEquals(CircularTestList.getlength(),999);
    }

    @Test
    public void addToEnd() throws Exception {
        CircularTestList.addToEnd("final");
        assertEquals(CircularTestList.getElement(999),"final");
    }


    @Test
    public void getElement() throws Exception {
        System.out.println(CircularTestList.getElement((int) (Math.random() * ((1000) + 1))));
    }

    @Test
    public void search() throws Exception {
        System.out.println(CircularTestList.search((int) (Math.random() * ((1000) + 1))));
    }

    @Test
    public void deletePos() throws Exception {
        CircularTestList.deletePos((int) (Math.random() * ((1000) + 1)));
    }

}