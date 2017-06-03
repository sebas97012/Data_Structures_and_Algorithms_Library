package org.tec.datastructures;
@SuppressWarnings("rawtypes")
public class Cola<T>{
	
	private Node<T> inicio;
	
	private int largo;
	
	public Cola(){
	    inicio = null;
	    largo = 0;
	}
	
	public boolean esVacia(){
	    return inicio == null;
	}
	public int getLargo(){
	    return largo;
	}
	
	
	public void dequeue(){
	    if (!esVacia()) {
	        inicio = inicio.getNext();
	        largo--;
	    }
	}
	
	public void enqueue(T t){
		 
	    Node nuevo = new Node<T>(t);
	    Node<T> aux;
	
	    if (esVacia()) {
	        inicio = nuevo;
	    }else {
	        aux = inicio;
	
	        while(aux.getSiguiente() != null){
	            aux=aux.getSiguiente();
	        }
	        aux.setSiguiente(nuevo);
	    }
	}
	
	public T peek() throws Exception{
	    if(!esVacia()){
	        return inicio.getDato();
	    } else {
	        throw new Exception("La pila se encuentra vacia.");
	    }
	}
	
	public boolean buscar(T referencia){
	    Nodo<T> aux = inicio;
	    boolean existe = false;
	    while(existe != true && aux != null){
	        if (referencia == aux.getDato()) {
	            existe = true;
	        }
	        else{
	            aux = aux.getSiguiente();
	        }
	    }
	    return existe;
	}
	
	public void imprimir(){
	    Nodo<T> aux = inicio;
	    while(aux != null){
	        System.out.println("|\t" + aux.getDato() + "\t|");
	        System.out.println("-----------------");
	        aux = aux.getSiguiente();
	    }
	}
}
