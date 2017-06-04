package org.tec.algo.search;

public class Node<T extends Comparable<T>>{
    private T data;
    private Node<T> next;
    private Node<T> previous;

    public Node(){

    }

    public Node(T data){
        this.data = data;
        this.next = null;
        this.previous = null;
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

    public Node<T> getPrevious(){
        return this.previous;
    }

    public void setPrevious(Node<T> previous){
        this.previous = previous;
    }
}

