package aso.preparation.controller;

import aso.preparation.entity.Point;
import aso.preparation.entity.hyperloop.Assignment1;
import aso.preparation.entity.hyperloop.Assignment2;
import aso.preparation.entity.hyperloop.Assignment3;
import aso.preparation.entity.hyperloop.Assignment4;
import aso.preparation.service.HyperloopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class HyperloopController {

    private static final String BASE_URL = "/api/hyperloop/";
    public static final String POST_USING_BODY = "POST {} using body {}";
    private final HyperloopService hyperloopService;

    public HyperloopController(HyperloopService hyperloopService) {
        this.hyperloopService = hyperloopService;
    }

    @PostMapping(BASE_URL + "1")
    public List<Point> generateSolution1(@RequestBody Assignment1 assignment1) {
        log.info(POST_USING_BODY, BASE_URL + "1", assignment1.toString());
        return hyperloopService.generateSolution1(assignment1);
    }

    @PostMapping(BASE_URL + "2")
    public List<Point> generateSolution2(@RequestBody Assignment2 assignment2) {
        log.info(POST_USING_BODY, BASE_URL + "2", assignment2.toString());
        return hyperloopService.generateSolution2(assignment2);
    }

    @PostMapping(BASE_URL + "3")
    public List<Point> generateSolution3(@RequestBody Assignment3 assignment3) {
        log.info(POST_USING_BODY, BASE_URL + "3", assignment3.toString());
        return hyperloopService.generateSolution3(assignment3);
    }

    @PostMapping(BASE_URL + "4")
    public List<Point> generateSolution4(@RequestBody Assignment4 assignment4) {
        log.info(POST_USING_BODY, BASE_URL + "4", assignment4.toString());
        return hyperloopService.generateSolution4(assignment4);
    }


}
