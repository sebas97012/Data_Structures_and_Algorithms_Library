package org.tec.datastructures;

@SuppressWarnings("rawtypes")
public class Queue<T extends Comparable<T>>{
	private Node<T> start;
	private int length;
	
	public Queue(){
	    start = null;
	    length = 0;
	}
	
	public boolean isEmpty(){
	    return start == null;
	}

	public int getLength(){
	    return length;
	}
	
	public void enqueue(T t){
	    Node n = new Node<T>(t);
	    Node<T> aux;
	
	    if (isEmpty()) {
	        start = n;
	    }else {
	        aux = start;
	
	        while(aux.getNext() != null){
	            aux = aux.getNext();
	        }
	        aux.setNext(n);
	    }
	    length++;
	}
	
	public void dequeue(){
	    if (!isEmpty()) {
	        start = start.getNext();
	        length--;
	    }
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
	        throw new Exception("Error: Empty queue");
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
	
	public void printQueue(){
	    Node<T> aux = start;

	    while(aux != null){
	        System.out.println("|\t" + aux.getDataT() + "\t|");
	        aux = aux.getNext();
	    }
	}
}
