package org.tec.datastructures;

public class ListaCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int largo;
    
    public ListaCircular(){
        inicio = null;
        ultimo = null;
        largo = 0;
    }
    public boolean esVacia(){
        return inicio == null;
    }
    public int getLargo(){
        return largo;
    }
    public void agregarAlFinal(T valor){
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setDato(valor);
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else{
            ultimo.setSiguiente(nuevo);
            nuevo.setSiguiente(inicio);
            ultimo = nuevo;
        }
        largo++;
    }
    public void agregarAlInicio(T valor){
        Nodo<T> nuevo = new Nodo<>();
        nuevo.setDato(valor);
        if (esVacia()) {
            inicio = nuevo;
            ultimo = nuevo;
            ultimo.setSiguiente(inicio);
        } else{
            nuevo.setSiguiente(inicio);
            inicio = nuevo;
            ultimo.setSiguiente(inicio);
        }
        largo++;
    }
    public void insrtarPorPosicion(int posicion, T valor){
        if(posicion>=0 && posicion<=largo){
            Nodo<T> nuevo = new Nodo<>();
            nuevo.setDato(valor);
            if(posicion == 0){
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                ultimo.setSiguiente(inicio);
            }
            else{
                if(posicion == largo){
                    ultimo.setSiguiente(nuevo);
                    nuevo.setSiguiente(inicio);
                    ultimo = nuevo;     
                }
                else{
                    Nodo<T> aux = inicio;
                    for (int i = 0; i < (posicion-1); i++) {
                        aux = aux.getSiguiente();
                    }
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(nuevo);
                    nuevo.setSiguiente(siguiente);
                }
            }
            largo++;
        }
    }
    public T getValor(int posicion) throws Exception{
        if(posicion>=0 && posicion<largo){
            if (posicion == 0) {
                return inicio.getDato();
            }else{
                Nodo<T> aux = inicio;
                for (int i = 0; i < posicion; i++) {
                    aux = aux.getSiguiente();
                }
                return aux.getDato();
        }
            } else{
            throw new Exception("Posicion inexistente en la lista.");
        }
    }
    
    public boolean buscar(T referencia){
        Nodo<T> aux = inicio;
        boolean encontrado = false;
        do{
            if (referencia == aux.getDato()){
                encontrado = true;
            }
            else{
                aux = aux.getSiguiente();
            }
        }while(aux != inicio && encontrado != true);
        return encontrado;
    }

    
    public void removerPorPosicion(int posicion){
        if(posicion>=0 && posicion<largo){
            if(posicion == 0){
                inicio = inicio.getSiguiente();
                ultimo.setSiguiente(inicio);
            }
            else{
                Nodo<T> aux = inicio;
                for (int i = 0; i < posicion-1; i++) {
                    aux = aux.getSiguiente();
                }
                if (aux.getSiguiente() == ultimo) {
                    aux.setSiguiente(inicio);
                    ultimo = aux;
                } else {
                    Nodo<T> siguiente = aux.getSiguiente();
                    aux.setSiguiente(siguiente.getSiguiente());
            }
            largo--;
        }
    }
    }    
    public void listar(){
        if (!esVacia()) {
            Nodo<T> aux = inicio;
            
            do{
                System.out.print(aux.getDato());
                aux = aux.getSiguiente();
            }while(aux != inicio);
        }
    }
}