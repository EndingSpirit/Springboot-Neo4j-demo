package com.tyh.entity;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@Node("Person")
@Builder
public class Person {
    @Id @GeneratedValue
    private Long id;

    @Property("name")
    private String name;

    @Property("born")
    private Integer born;

//    public Person(String id, Integer born, String name) {
//        this.id = id;
//        this.born = born;
//        this.name = name;
//    }
}


