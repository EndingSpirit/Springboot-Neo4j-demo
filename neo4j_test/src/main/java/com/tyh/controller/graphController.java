package com.tyh.controller;

import com.tyh.entity.Movie;
import com.tyh.entity.RelationEntity;
import com.tyh.service.GraphServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/movie")
public class graphController {
    @Autowired
    private GraphServices graphServices;

    @GetMapping("/Overview")
    public Map<String, Object> Overview(){
        return graphServices.graph();
    }


    @GetMapping("/get_all_movie")
    public List<Movie> getAllMovie(){
        return graphServices.getAllMovie();
    }

    @GetMapping("/getRelatedNodes")
    public Map<String, Object> getRelatedNodes(){
        return graphServices.getRelatedNodes();
    }

    @GetMapping("/getAllRelationId")
    public List<Map<Long,Long>> getAllRelationId(){
        return graphServices.getAllRelationId();
    }

    @GetMapping("/get_movie")
    public Movie getMovie(@RequestParam("title")String title){
        return graphServices.getMovieByName(title);
    }



    @GetMapping("/deal")
    public Map<String, List<Map>> deal(){
        return graphServices.deal();
    }

}
