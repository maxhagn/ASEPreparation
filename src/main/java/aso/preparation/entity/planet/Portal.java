package aso.preparation.entity.planet;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Portal {
    private int targetPlanetId;
    private int weight;
}
