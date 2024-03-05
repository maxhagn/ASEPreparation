package aso.preparation.controller;

import aso.preparation.entity.planet.Assignment1;
import aso.preparation.entity.planet.Assignment2;
import aso.preparation.entity.planet.Assignment3;
import aso.preparation.entity.planet.Assignment4;
import aso.preparation.service.PlanetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class PlanetController {

    private static final String BASE_URL = "/api/planet/";

    private final PlanetService planetService;

    @PostMapping(BASE_URL + "1")
    public ResponseEntity<?> generateSolution1(@RequestBody Assignment1 assignment1) {
        log.info("POST request to {}", BASE_URL + "1");
        return ResponseEntity.ok(planetService.generateSolution1(assignment1.getGalaxy(), assignment1.getStartPlanetId()));
    }

    @PostMapping(BASE_URL + "2")
    public ResponseEntity<?> generateSolution2(@RequestBody Assignment2 assignment2) {
        log.info("POST request to {}", BASE_URL + "2");
        return ResponseEntity.ok(planetService.generateSolution2(assignment2.getGalaxy()));
    }

    @PostMapping(BASE_URL + "3")
    public ResponseEntity<?> generateSolution3(@RequestBody Assignment3 assignment3) {
        log.info("POST request to {}", BASE_URL + "3");
        return ResponseEntity.ok(planetService.generateSolution3(assignment3.getGalaxy(), assignment3.getSource(), assignment3.getTarget()));
    }

    @PostMapping(BASE_URL + "4")
    public ResponseEntity<?> generateSolution4(@RequestBody Assignment4 assignment4) {
        log.info("POST request to {}", BASE_URL + "4");
        return ResponseEntity.ok(planetService.generateSolution4(assignment4.getGalaxy()));
    }
}
