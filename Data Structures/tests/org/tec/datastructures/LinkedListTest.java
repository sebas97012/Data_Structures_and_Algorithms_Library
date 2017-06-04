package org.tec.datastructures;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
    }
    @Test
    public void getFirst() throws Exception {
        System.out.println(TestList.getFirst().getDataT());
    }

    @Test
    public void setFirst() throws Exception {
        TestList.setFirst(new Node<String>("hola"));
        System.out.println(TestList.getFirst().getDataT());
    }

    @Test
    public void getSize() throws Exception {
        System.out.println(TestList.getSize());
    }

    @Test
    public void insertAtFirst() throws Exception {
        TestList.insertAtFirst(233);
        System.out.println(TestList.getFirst().getDataT());
    }

    @Test
    public void insertAtEnd() throws Exception {
        TestList.insertAtEnd("Final");
    }

    @Test
    public void getElement() throws Exception {
        System.out.println(TestList.getElement((int) (Math.random() * ((1000) + 1))).getDataT());
    }

    @Test
    public void deleteFirst() throws Exception {
        TestList.deleteFirst();
    }

    @Test
    public void insertElement() throws Exception {
        TestList.insertElement(2333,(int) (Math.random() * ((1000) + 1)));
    }

    @Test
    public void deleteElement() throws Exception {
        TestList.deleteElement(143);
    }

    @Test
    public void deleteElement1() throws Exception {
        TestList.deleteElementPos((int) (Math.random() * ((1000) + 1)));
    }

    @Test
    public void cleanList() throws Exception {
    TestList.cleanList();
    }

   @After
    public void after() throws Exception {
       TestList.printList();
        TestList.cleanList();
    }
}