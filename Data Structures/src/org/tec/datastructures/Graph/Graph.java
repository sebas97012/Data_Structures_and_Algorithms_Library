package org.tec.datastructures.Graph;

import com.sun.istack.internal.Nullable;

import java.util.*;

/**
 * Created by sebas97012 on 6/4/17.
 */
public class Graph<T> {

    private Map<T, GraphNode<T>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex        vertex to add
     */
    public boolean addVertex(T vertex) {
        if (adjacencyList.containsKey(vertex)) {
            return false;
        }
        adjacencyList.put(vertex, new GraphNode<>(vertex));
        return true;
    }

    /**
     * Adds a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     */
    public boolean addEdge(T vertex1, T vertex2) {
        return addEdge(vertex1, vertex2, 0);
    }

    /**
     * Adds a weighted directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @param weight        weight of the edge
     */
    public boolean addEdge(T vertex1, T vertex2, int weight) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            throw new RuntimeException("Vertex does not exist");
        }

        // add the edge
        GraphNode<T> graphNode1 = getNode(vertex1);
        GraphNode<T> graphNode2 = getNode(vertex2);
        return graphNode1.addEdge(graphNode2, weight);
    }

    /**
     * Remove a vertex from the graph.
     * @param vertex        vertex to be removed
     * @return      true if the vertex was removed, false if no such vertex was found.
     */
    public boolean removeVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            return false;
        }

        // get node to be removed
        final GraphNode<T> toRemove = getNode(vertex);

        // remove all incoming edges to node
        adjacencyList.values().forEach(graphNode -> graphNode.removeEdge(toRemove));

        // remove the node
        adjacencyList.remove(vertex);
        return true;
    }

    /**
     * Method to remove a directed edge between two vertices in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return  true if the edge was removed, false if no such edge was found.
     */
    public boolean removeEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).removeEdge(getNode(vertex2));
    }

    /**
     * Method to get the number of vertices in the graph.
     * @return      count of vertices
     */
    public int vertexCount() {
        return adjacencyList.keySet().size();
    }

    /**
     * Method to get the number of edges in the graph.
     * @return      count of edges
     */
    public int edgeCount() {
        return adjacencyList.values()
                .stream()
                .mapToInt(GraphNode::getEdgeCount)
                .sum();
    }

    /**
     * Method to check if a vertex exists in the graph.
     * @param vertex    vertex which is to be checked
     * @return  returns true if the graph contains the vertex, false otherwise
     */
    public boolean containsVertex(T vertex) {
        return adjacencyList.containsKey(vertex);
    }

    /**
     * Method to check if an edge exists in the graph.
     * @param vertex1       vertex where the (directed) edge begins
     * @param vertex2       vertex where the (directed) edge ends
     * @return   returns true if the graph contains the edge, false otherwise
     */
    public boolean containsEdge(T vertex1, T vertex2) {
        if (!containsVertex(vertex1) || !containsVertex(vertex2)) {
            return false;
        }
        return getNode(vertex1).hasEdge(getNode(vertex2));
    }

    /**
     * Method to get the shortest path from startVertex to endVertex.
     * @param startVertex   vertex where the path begins
     * @param endVertex     vertex where the path ends
     * @return  list of vertices in the shortest path from startVertex to endVertex,
     *          null if no such path exists.
     */
    @Nullable
    public List<T> shortestPath(T startVertex, T endVertex) {
        // if nodes not found, return empty path
        if (!containsVertex(startVertex) || !containsVertex(endVertex)) {
            return null;
        }
        // run bfs on the graph
        runBFS(startVertex);

        List<T> path = new ArrayList<>();
        // trace path back from end vertex to start
        GraphNode<T> end = getNode(endVertex);
        while (end != null && end != getNode(startVertex)) {
            path.add(end.vertex());
            end = end.parent();
        }
        // if end is null, node not found
        if (end == null) {
            return null;
        }
        else {
            Collections.reverse(path);
        }
        return path;
    }

    private void runBFS(T startVertex) {
        if (!containsVertex(startVertex)) {
            throw new RuntimeException("Vertex does not exist.");
        }

        // reset the graph
        resetGraph();

        // init the queue
        Queue<GraphNode<T>> queue = new LinkedList<>();
        GraphNode<T> start = getNode(startVertex);
        queue.add(start);

        // explore the graph
        while (!queue.isEmpty()) {
            GraphNode<T> first = queue.remove();
            first.setVisited(true);
            //queue.forEach();
        }
    }

    private GraphNode<T> getNode(T value) {
        return adjacencyList.get(value);
    }

    private void resetGraph() {
        adjacencyList.keySet().forEach(key -> {
            GraphNode<T> graphNode = getNode(key);
            graphNode.setParent(null);
            graphNode.setVisited(false);
        });
    }
}