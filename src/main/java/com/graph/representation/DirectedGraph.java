package com.graph.representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph {

    private final Map<Vertex, List<Edge>> adjVertices = new HashMap<>();

    public void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(String label) {
        Vertex toRemove = new Vertex(label);
        adjVertices.values().forEach(edges -> edges.remove(new Edge(toRemove)));
        adjVertices.remove(toRemove);
    }

    public void addEdge(String from, String to, int weight) {
        Vertex fromVertex = new Vertex(from);
        Vertex toVertex = new Vertex(to);
        if (adjVertices.get(fromVertex) == null) {
            throw new RuntimeException("Vertex " + from + " not present");
        }
        if (adjVertices.get(toVertex) == null) {
            throw new RuntimeException("Vertex " + to + " not present");
        }
        // edge to be added
        Edge edge = new Edge(toVertex);
        edge.setWeight(weight);
        // find the edge list and add to it
        adjVertices.get(fromVertex).add(edge);
    }

    public void removeEdge(String from, String to) {
        Vertex fromVertex = new Vertex(from);
        Vertex toVertex = new Vertex(to);
        if (adjVertices.get(fromVertex) == null) {
            throw new RuntimeException("Vertex " + from + " not present");
        }
        if (adjVertices.get(toVertex) == null) {
            throw new RuntimeException("Vertex " + to + " not present");
        }
        // edge to be removed
        Edge toRemove = new Edge(toVertex);
        adjVertices.get(fromVertex).remove(toRemove);
    }

    public static void main(String[] args) {
        DirectedGraph directedGraph = new DirectedGraph();
        directedGraph.addVertex("A");
        directedGraph.addVertex("B");
        directedGraph.addVertex("C");
        directedGraph.addVertex("D");
        directedGraph.addVertex("E");
        directedGraph.addEdge("A", "B", 1);
        directedGraph.addEdge("B", "C", 2);
        directedGraph.addEdge("C", "D", 3);
        directedGraph.addEdge("D", "E", 4);
        directedGraph.addEdge("A", "D", 5);
        System.out.println(directedGraph);
    }

    @Override
    public String toString() {
        return "DirectedGraph{" +
                "adjVertices=" + adjVertices +
                '}';
    }
}