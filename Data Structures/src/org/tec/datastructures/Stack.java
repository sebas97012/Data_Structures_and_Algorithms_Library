package org.tec.datastructures;

public class Stack<T extends Comparable<T>>{
    private Node<T> start;
    private int length;

    public Stack(){
        start = null;
        length = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }
    
    public void push(T ele){
        Node<T> n = new Node<>();
        n.setDataT(ele);
        
        if (isEmpty()) {
            start = n;
        }
        
        else{
            n.setNext(start);
            start = n;
        }
        length++;
    }

    public void pop(){
        if (!isEmpty()) {
            start = start.getNext();
            length--;
        }
    }

    public T peek() throws Exception{
        if(!isEmpty()){
            return start.getDataT();
        } else {
            throw new Exception("Error: Empty stack");
        }
    }

    public boolean search(T ele){
        Node<T> aux = start;
        boolean found = false;

        while(!found && aux != null){
            if (ele == aux.getDataT()) {
                found = true;
            }
            else{
                aux = aux.getNext();
            }
        }
        return found;
    }

    public void printStack(){
        Node<T> aux = start;

        while(aux != null){
            System.out.println("\t" + aux.getDataT()");
            aux = aux.getNext();
        }
    }
    
    public int getLength(){
        return length;
    }
 
}
