package org.tec.datastructures;
public class ListaDoble<T> {
	
	private Node<T> head;
	private int size;
	
	public void doubleLinkedList(){
		this.head = null;
		this.size = 0;
	}
	public Node<T> getHead() 
	{
		return this.head;
	}
	
	public void agregarPrimero(T data)
	{
		if (this.head == null){
			Node<T> nuevo = new Node<T>(data);
			this.head = nuevo;
		}
		else {
			Node<T> current = new Node<T>(data);
			current.setNext(head);
			head.setPrevious(current);
			head = current;
			this.size++;
		}
	}
	
	public void agregarUltimo(T data)
	{
		Node<T> ultimo = new Node<T>(data);
		this.size++;
		Node<T> current = this.head;
		if (head == null)
			head = ultimo;
		else
		{
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext( ultimo );
			ultimo.setPrevious(current);
		}
	}
	
	public void insertar( T data, int pos ){
		Node<T> nuevo = new Node<T>( data );
		Node<T> current = head;
		int contador = 1;
		while (contador != pos){
			current = current.getNext();
			contador++;
		}
		nuevo.setPrevious(current);
		nuevo.setNext(current.getNext());
		current.setNext(nuevo);
		current.setPrevious(nuevo);
		this.size++;
	}
	
	public void eliminarPrimero(){
		Node<T> current = head;
		current = current.getNext();
		head = current;
		head.setPrevious(null);
		size--;
	}
	
	public void eliminarUltimo(){
		Node<T> current = head;
		while( current.getNext() != null ){
			current = current.getNext();
		}
		current.getPrevious().setNext(null);
		size--;
	}
	
	public void eliminarPos(int pos){
		Node<T> current = head;
		int contador = 0;
		while (contador != pos){
			current = current.getNext();
			contador++;
		}
		Node<T> aux = current;
		current.getNext().setPrevious(aux.getPrevious());
		current.getPrevious().setNext(aux.getNext());
		this.size++;
	}
	
	public boolean buscarElemento(T data){
		Node<T> current = head;
		while (current.getNext() != null){
			if (current.getData() == data){
					return true;
			}else{
				current = current.getNext();
			}
		}return false;
	}
	
	public String toString()
	{
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