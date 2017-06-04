package org.tec.algo.sort;

public class Node<T extends Comparable<T>>{
    private T data;
    private Node<T> next;

    public Node(){

    }

    public Node(T data){
        this.data = data;
        this.next = null;
    }

    public T getDataT() {
        return this.data;
    }

    public void setDataT(T dataT) {
        this.data = dataT;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}

