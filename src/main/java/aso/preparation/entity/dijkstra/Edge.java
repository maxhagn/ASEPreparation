package aso.preparation.entity.dijkstra;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    int target;
    int weight;
}
