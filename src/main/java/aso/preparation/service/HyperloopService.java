package aso.preparation.service;

import aso.preparation.entity.*;
import aso.preparation.entity.hyperloop.Assignment1;
import aso.preparation.entity.hyperloop.Assignment2;
import aso.preparation.entity.hyperloop.Assignment3;
import aso.preparation.entity.hyperloop.Assignment4;
import aso.preparation.repository.PointRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
@Slf4j
public class HyperloopService {
    private final PointRepository pointRepository;

    public HyperloopService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> generateSolution1(Assignment1 assignment1) {
        List<Point> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        assignment1.getPoints().forEach((Point point) -> {
            if (assignment1.getLine().getY() > 0 && point.getY() < assignment1.getLine().getY()) {
                result.add(point);
                stringBuilder.append(point.getX()).append(" ").append(point.getY()).append(" ");
            }
            if (assignment1.getLine().getY() < 0 && point.getY() > assignment1.getLine().getY()) {
                result.add(point);
                stringBuilder.append(point.getX()).append(" ").append(point.getY()).append(" ");
            }
        });

        log.info(stringBuilder.toString());
        return result;
    }

    public List<Point> generateSolution2(Assignment2 assignment2) {
        List<Point> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        double angle1 = Math.atan2(assignment2.getStartPoint().getX(), assignment2.getStartPoint().getY());
        double angle2 = Math.atan2(assignment2.getEndPoint().getX(), assignment2.getEndPoint().getY());

        double highest;
        double lowest;
        if (angle1 < angle2) {
            lowest = angle1;
            highest = angle2;
        } else {
            lowest = angle2;
            highest = angle1;
        }

        log.info("Angles: {} {}", highest, lowest);

        assignment2.getPoints().forEach((Point point) -> {
            double angle = Math.atan2(point.getX(), point.getY());
            //log.info("Point: {} Angle: {}", point.toString(), angle);

            if (angle < lowest || angle > highest) {
                result.add(point);
                stringBuilder.append(point.getX()).append(" ").append(point.getY()).append(" ");
            }

        });

        log.info(stringBuilder.toString());
        return result;
    }

    public List<Point> generateSolution3(Assignment3 assignment3) {
        List<Point> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        double angleX1 = Math.atan2(assignment3.getObstacle().getY(), assignment3.getObstacle().getX1());
        double angleX2 = Math.atan2(assignment3.getObstacle().getY(), assignment3.getObstacle().getX2());

        double lowest = Math.min(angleX1, angleX2);
        double highest = Math.max(angleX1, angleX2);

        assignment3.getPoints().forEach(point -> {
            double pointAngle = Math.atan2(point.getY(), point.getX());

            boolean withinAngleRange = pointAngle >= lowest && pointAngle <= highest;
            boolean sameSideOfY = (assignment3.getObstacle().getY() < 0) == (point.getY() < 0);

            if (!withinAngleRange || !sameSideOfY) {
                result.add(point);
                stringBuilder.append(point.getX()).append(" ").append(point.getY()).append(" ");
            }
        });

        log.info("Filtered Points: " + stringBuilder.toString());
        return result;
    }

    public List<Point> generateSolution4(Assignment4 assignment4) {
        List<Point> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        List<Obstacle> obstacles = assignment4.getObstacles();

        for (Point point : assignment4.getPoints()) {
            boolean isBehindAnyObstacle = false;

            for (Obstacle obstacle : obstacles) {
                double angleX1 = Math.atan2(obstacle.getY(), obstacle.getX1());
                double angleX2 = Math.atan2(obstacle.getY(), obstacle.getX2());

                double lowest = Math.min(angleX1, angleX2);
                double highest = Math.max(angleX1, angleX2);

                double pointAngle = Math.atan2(point.getY(), point.getX());

                boolean withinAngleRange = pointAngle > lowest && pointAngle < highest;
                boolean sameSideOfY = (obstacle.getY() < 0) == (point.getY() < 0);

                if (withinAngleRange && sameSideOfY && Math.abs(obstacle.getY()) < Math.abs(point.getY())) {
                    isBehindAnyObstacle = true;
                    break;
                }
            }

            if (!isBehindAnyObstacle) {
                result.add(point);
                stringBuilder.append(point.getX()).append(" ").append(point.getY()).append(" ");
                pointRepository.save(point);
            }
        }

        log.info("Filtered Points: " + stringBuilder.toString());
        return result;
    }

}
