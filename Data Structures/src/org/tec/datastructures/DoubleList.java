package org.tec.datastructures;

public class DoubleList<T extends Comparable<T>> {
	private Node<T> head;
	private int size;
	
	public void DoubleList(){
		this.head = null;
		this.size = 0;
	}

	public Node<T> getHead() 
	{
		return this.head;
	}
	
	public void addToStart(T data){
		if (this.head == null){
			Node<T> n = new Node<>(data);
			this.head = n;
		}
		else {
			Node<T> current = new Node<>(data);
			current.setNext(head);
			head.setPrevious(current);
			head = current;
			this.size++;
		}
	}
	
	public void addToEnd(T data){
		Node<T> last = new Node<>(data);
		this.size++;
		Node<T> current = this.head;

		if (head == null)
			head = last;
		else{
			while (current.getNext() != null)		//¿Falta {}?/////////////////
			current = current.getNext();
			current.setNext( last );
			last.setPrevious(current);
		}
	}
	
	public void add( T data, int pos){
		Node<T> n = new Node<>(data);
		Node<T> current = head;
		int cont = 1;

		while (cont != pos){
			current = current.getNext();
			cont++;
		}

		n.setPrevious(current);
		n.setNext(current.getNext());
		current.setNext(n);
		current.setPrevious(n);
		this.size++;
	}
	
	public void deleteFirst(){
		Node<T> current = head;
		current = current.getNext();
		head = current;
		head.setPrevious(null);
		size--;
	}
	
	public void deleteLast(){
		Node<T> current = head;
		while(current.getNext() != null ){
			current = current.getNext();
		}
		current.getPrevious().setNext(null);
		size--;
	}
	
	public void deletePos(int pos){
		Node<T> current = head;
		int cont = 0;

		while (cont != pos){
			current = current.getNext();
			cont++;
		}

		Node<T> aux = current;
		current.getNext().setPrevious(aux.getPrevious());
		current.getPrevious().setNext(aux.getNext());
		this.size++;
	}
	
	public boolean search(T data){
		Node<T> current = head;

		while (current.getNext() != null){
			if (current.getData() == data){
					return true;
			}else{
				current = current.getNext();
			}
		}
		return false;
	}

	//////////////////
	public String toString(){
		String datos = "Datos de la lista: \n";
		Node<T> current = head;

		while( current.getNext() != null )
		{
			datos += current.getData() + "\n";
			current = current.getNext();
		}
		datos += current.getData() + "\n";
		return datos;
	}
	

}