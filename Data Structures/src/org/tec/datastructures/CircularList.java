package org.tec.datastructures;

@SuppressWarnings("rawtypes")
public class CircularList<T extends Comparable<T>> {
    private Node<T> start;
    private Node<T> last;
    private int length;
    
    public CircularList(){
        start = null;
        last = null;
        length = 0;
    }

    public boolean isEmpty(){
        return start == null;
    }

    public int getlength(){
        return length;
    }

    public void addToEnd(T ele){
        Node<T> n = new Node<>();
        n.setDataT(ele);

        if (isEmpty()) {
            start = n;
            last = n;
            last.setNext(start);
        } else{
            last.setNext(n);
            n.setNext(start);
            last = n;
        }
        length++;
    }

    public void addToStart(T ele){
        Node<T> n = new Node<>();
        n.setDataT(ele);

        if (isEmpty()) {
            start = n;
            last = n;
            last.setNext(start);
        } else{
            n.setNext(start);
            start = n;
            last.setNext(start);
        }
        length++;
    }

    public void addToPos(int pos, T ele){
        if(pos>=0 && pos<=length){
            Node<T> n = new Node<>();
            n.setDataT(ele);

            if(pos == 0){
                n.setNext(start);
                start = n;
                last.setNext(start);
            }
            else{
                if(pos == length){
                    last.setNext(n);
                    n.setNext(start);
                    last = n;
                }
                else{
                    Node<T> aux = start;
                    Node<T> next = aux.getNext();

                    for (int i = 0; i < (pos-1); i++) {
                        aux = aux.getNext();
                    }

                    aux.setNext(n);
                    n.setNext(next);
                }
            }
            length++;
        }
    }

    public T getElement(int pos) throws Exception{
        if(pos >= 0 && pos < length){
            if (pos == 0) {
                return start.getDataT();
            }else{
                Node<T> aux = start;
                for (int i = 0; i < pos; i++) {
                    aux = aux.getNext();
                }
                return aux.getDataT();
            }
        }else{
            throw new Exception("Error");
        }
    }
    
    public boolean search(T ele){
        Node<T> aux = start;
        boolean found = false;

        do{
            if (ele == aux.getDataT()){
                found = true;
            }
            else{
                aux = aux.getNext();
            }
        }while(aux != start && !found);
        return found;
    }

    public void deletePos(int pos){
        if(pos >= 0 && pos < length){
            if(pos == 0){
                start = start.getNext();
                last.setNext(start);
            }else{
                Node<T> aux = start;

                for (int i = 0; i < pos-1; i++) {
                    aux = aux.getNext();
                }
                if (aux.getNext() == last) {
                    aux.setNext(start);
                    last = aux;
                } else {
                    Node<T> next = aux.getNext();
                    aux.setNext(next.getNext());
                }
                length--;
            }
        }
    }

    public void printCirList(){
        if (!isEmpty()) {
            Node<T> aux = start;
            
            do{
                System.out.print(aux.getDataT()+", ");
                aux = aux.getNext();
            }while(aux != start);
        }
    }
}