package aso.preparation.controller;

import aso.preparation.entity.dijkstra.DijkstraAssignment;
import aso.preparation.service.DijkstraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class DijkstraController {
    private static final String BASE_URL = "/api/dijkstra";
    private final DijkstraService dijkstraService;

    public DijkstraController(DijkstraService dijkstraService) {
        this.dijkstraService = dijkstraService;
    }

    @PostMapping(BASE_URL)
    public List<Integer> calculateShortestPath(@RequestBody DijkstraAssignment dijkstraAssignment) {
        return dijkstraService.getShortestPath(dijkstraAssignment.getGraph(), dijkstraAssignment.getSource(), dijkstraAssignment.getTarget());
    }

}
