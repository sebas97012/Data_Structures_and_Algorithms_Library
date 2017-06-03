package org.tec.datastructures;

public class Pila<T> {
    private Nodo<T> inicio;
    
    private int largo;

    public Pila(){
        inicio = null;
        largo = 0;
    }

    public boolean esVacia(){
        return inicio == null;
    }
    public int getLargo(){
        return largo;
    }
 
    public void push(T valor){
        
        Nodo<T> nuevo = new Nodo<>();
        
        nuevo.setDato(valor);
        
        if (esVacia()) {
            
            inicio = nuevo;
        }
        
        else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
        }
        
        largo++;
    } 
    public void pop(){
        if (!esVacia()) {
            inicio = inicio.getSiguiente();
            largo--;
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
