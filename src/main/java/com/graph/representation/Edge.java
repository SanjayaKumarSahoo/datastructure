package com.graph.representation;

import java.util.Objects;

public class Edge {

    private final Vertex to;
    private int weight;

    public Edge(Vertex to) {
        this.to = to;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex getTo() {
        return to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return to.equals(edge.to);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "to=" + to +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(to);
    }

}