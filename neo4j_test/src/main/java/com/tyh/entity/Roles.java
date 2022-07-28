package com.tyh.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.Collection;
import java.util.List;

@RelationshipProperties
@Data
public class Roles {

    @RelationshipId @GeneratedValue
    private Long id;

    private List<String> roles;


    @TargetNode
    private Person person;

}
