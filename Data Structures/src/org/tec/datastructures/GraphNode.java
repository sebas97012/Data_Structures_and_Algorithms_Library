package org.tec.datastructures;

public class GraphNode<T extends Comparable<T>> {
    private Comparable data;

    public GraphNode(Comparable valor){
        this.data = valor;
    }

    public Comparable<T> getData() {
        return data;
    }

    public void setData(Comparable valor) {
        this.data = valor;
    }
}
