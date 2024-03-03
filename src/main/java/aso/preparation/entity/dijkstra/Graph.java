package aso.preparation.entity.dijkstra;

import lombok.Data;

import java.util.*;

@Data
public class Graph {

    private Map<Integer, List<Edge>> adjacencyList = new HashMap<>();

    public List<Edge> getEdges(int vertex) {
        return adjacencyList.getOrDefault(vertex, new ArrayList<>());
    }

}
