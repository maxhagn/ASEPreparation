package aso.preparation.entity.planet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    private int id;
    private List<Portal> portals;
    public void addPortal(int targetPlanetId, int weight) {
        portals.add(new Portal(targetPlanetId, weight));
    }
}
