package aso.preparation.entity.hyperloop;

import aso.preparation.entity.Point;
import lombok.Data;

import java.util.List;

@Data
public class Assignment2 {
    private Point startPoint;
    private Point endPoint;
    private List<Point> points;
}
