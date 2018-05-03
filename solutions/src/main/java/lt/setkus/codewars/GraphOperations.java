package lt.setkus.codewars;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://www.codewars.com/kata/graph-operations-part-1-find-neighbours-of-a-vertex
 * https://www.codewars.com/kata/graph-operations-part-2-your-distance-from-a-colleague
 */
public class GraphOperations {
    private static final int PATH_DOES_NOT_EXIST = -1;

    public static Set<Vertex> getNeighbours(Graph exampleGraph, Vertex vertex) {
        Set<Vertex> neighbours = new HashSet<>();
        for (Edge edge : exampleGraph.getEdges()) {
            if (edge.getV1().equals(vertex)) {
                neighbours.add(edge.getV2());
            }

            if (edge.getV2().equals(vertex)) {
                neighbours.add(edge.getV1());
            }
        }

        return neighbours;
    }

    public static int hopDistance(Graph graph, Vertex source, Vertex target) {
        int distance = 0;
        Iterator<Vertex> neighboursIterator = getNeighbours(graph, source).iterator();
        while (neighboursIterator.hasNext()) {
            distance++;
            Vertex currentVertex = neighboursIterator.next();
            if (currentVertex.equals(target)) {
                return distance;
            } else {
                neighboursIterator.remove();
            }
        }

        return PATH_DOES_NOT_EXIST;
    }
}

class Graph {

    private static int uidCounter = 0;
    Set<Vertex> vertices;
    Set<Edge> edges;

    public Graph(){
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    public void addVertex(Vertex vertex){
        vertices.add(vertex);
    }

    public void addVertices(Vertex... vertices){
        for(Vertex v: vertices)
            addVertex(v);
    }

    public void addEdge(Vertex v1, Vertex v2){
        addEdge(new Edge(v1, v2));
    }

    public void addEdge(Edge edge){
        vertices.add(edge.v1);
        vertices.add(edge.v2);
        edges.add(edge);
    }

    public void addEdges(Vertex... vertices){
        if(vertices.length%2 != 0)
            throw new IllegalArgumentException();

        for(int i = 0; i< vertices.length; i=i+2){
            addEdge(vertices[i], vertices[i+1]);
        }
    }

    public Set<Vertex> getVertices(){ return vertices; }

    public Set<Edge> getEdges(){ return edges; }

    static int getUidForNode(){ return uidCounter++; }
}

class Vertex {
    private final int uid;

    Vertex(){
        uid = Graph.getUidForNode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex other = (Vertex) o;
        return uid == other.uid;
    }

    @Override
    public int hashCode() { return uid; }
}

class Edge{
    Vertex v1;
    Vertex v2;

    Edge(Vertex v1, Vertex v2){
        this.v1 = v1;
        this.v2 = v2;
    }

    public Vertex getV1() { return v1; }

    public Vertex getV2() { return v2; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge other = (Edge) o;
        return (v1.equals(other.v1) && v2.equals(other.v2)) || (v1.equals(other.v2) && v2.equals(other.v1));
    }

    @Override
    public int hashCode() {
        return v1.hashCode() + v2.hashCode();
    }
}
