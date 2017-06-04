package org.tec.datastructures.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class GraphNode<T> {

    private T vertex;

    private List<Edge<T>> edges;

    private GraphNode<T> parent;

    private boolean isVisited;

    public GraphNode(T vertex) {
        this.vertex = vertex;
        this.edges = new ArrayList<>();
    }

    public T vertex() {
        return vertex;
    }

    public boolean addEdge(GraphNode<T> graphNode, int weight) {
        if (hasEdge(graphNode)) {
            return false;
        }
        Edge<T> newEdge = new Edge<>(this, graphNode, weight);
        return edges.add(newEdge);
    }

    public boolean removeEdge(GraphNode<T> graphNode) {
        Optional<Edge<T>> optional = findEdge(graphNode);
        if (optional.isPresent()) {
            return edges.remove(optional.get());
        }
        return false;
    }

    public boolean hasEdge(GraphNode<T> graphNode) {
        return findEdge(graphNode).isPresent();
    }

    private Optional<Edge<T>> findEdge(GraphNode<T> graphNode) {
        return edges.stream()
                .filter(edge -> edge.isBetween(this, graphNode))
                .findFirst();
    }

    public List<Edge<T>> edges() {
        return edges;
    }

    public int getEdgeCount() {
        return edges.size();
    }

    public GraphNode<T> parent() {
        return parent;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }

    public void setParent(GraphNode<T> parent) {
        this.parent = parent;
    }
}