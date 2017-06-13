package org.tec.datastructures;

@SuppressWarnings("rawtypes")
public class LinkedList<T extends Comparable<T>>{
	protected Node first;
    protected int size;

    public LinkedList() {
        this.first = null;
        this.size = 0;
    }

	public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public int getSize(){
        return size;
    }

    public void insertAtFirst(T data) {
    	Node newNode = new Node<>(data);
        if (this.first == null) {
            setFirst(newNode);
        } else {
            newNode.setNext(first);
            setFirst(newNode);
        }
        size++;
    }

    public void insertAtEnd(T data) {
        Node newNode = new Node(data);
        if (this.first == null) {
            setFirst(newNode);
        } else {
            Node current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
    }

    public Node getElement(int position){
        Node current = this.first;

        if(position < this.size && position >= 0) {
            for (int i = 0; i < position; i++) {
                current = current.getNext();
            }
        } else{
            return null;
        }
        return current;
    }

    public void insertElement(T data, int position){
        Node newNode = new Node(data);
        Node current = this.first;

        if(1 <= position && position < this.size){
            for(int i = 0; i < (position - 1); i++){
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        if(position == 0){
            this.insertAtFirst(data);
        }
        if(this.size <= position){
            for(int i = 0; i < (this.size - 1); i++){
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        this.size++;
    }

    public void deleteFirst() {
        if(this.first != null) {
            this.first = first.getNext();
            size--;
        }
    }

    public void deleteElement(T object){
        Node<T> current = this.first;

        if(current.getDataT().compareTo(object) == 0){
            this.deleteFirst();
        } else{
            while(current != null && current.getNext() != null){
                if(current.getNext().getDataT().compareTo(object) == 0){
                    current.setNext(current.getNext().getNext());
                    this.size--;
                }
                current = current.getNext();
            }
        }
    }
	
    public void deleteElementPos(int position) {
        if (position == 0) {
            this.deleteFirst();
        } else {
            if (position <= (this.size - 1)) {
                Node current = this.first;
                for (int i = 0; i < (position - 1); i++) {
                    current = current.getNext();
                }

                current.setNext(current.getNext().getNext());
                this.size--;
            }
        }
    }

    public void cleanList(){
        this.first = null;
        this.size = 0;
    }

    public void printList() {
        Node current = first;
        while (current != null) {
            System.out.print(current.getDataT() + " ");
            current = current.getNext();
        }
        System.out.println("");
    }

}

