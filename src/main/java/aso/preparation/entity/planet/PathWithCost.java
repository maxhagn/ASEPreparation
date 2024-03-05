package aso.preparation.entity.planet;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PathWithCost {
    private List<Integer> path;
    private int cost;
}
