package org.tec.datastructures.Graph;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class Edge<T> {

    private GraphNode<T> graphNode1;

    private GraphNode<T> graphNode2;

    private int weight;

    public Edge(GraphNode<T> graphNode1, GraphNode<T> graphNode2, int weight) {
        this.graphNode1 = graphNode1;
        this.graphNode2 = graphNode2;
        this.weight = weight;
    }

    public GraphNode<T> fromNode() {
        return graphNode1;
    }

    public GraphNode<T> toNode() {
        return graphNode2;
    }

    public boolean isBetween(GraphNode<T> graphNode1, GraphNode<T> graphNode2) {
        return (this.graphNode1 == graphNode1 && this.graphNode2 == graphNode2);
    }
}