package com.tyh.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import lombok.Builder;
import lombok.Data;
import java.util.List;

import org.springframework.data.neo4j.core.schema.*;

@Node("Movie")
@Data
@Builder
public class Movie {

    @Id @GeneratedValue
    private Long id;

    @Property("title")
    private String title;

    @Property("released")
    private Integer released;

    @Property("tagline")
    private String tagline;

    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.INCOMING)
    private List<Roles> roles;

//    public Movie(String id,String title, String tagline) {
//        this.id = id;
//        this.title = title;
//        this.tagline = tagline;
//    }
}
