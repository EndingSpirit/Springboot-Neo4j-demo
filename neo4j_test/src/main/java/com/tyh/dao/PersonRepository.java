package com.tyh.dao;

import com.tyh.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    @Query("CREATE (n:Person {name:$name, born:$born})")
    void createPerson(String name, Integer born);

    @Query("CREATE ($name)-[:ACTED_IN {roles:[$roles]}]->($Movie)")
    void createRelationActedIn(String name, String Movie,String roles);

    @Query("match (n:Person) where n.name=$name return n")
    Person findByName(String name);

    @Query("MATCH (n) RETURN n")
    List<Person> findAll();

    @Query("MATCH (a:Person),(b:Person) WHERE a.name = $startName AND b.name = $endName CREATE (a)-[r:sonOf] -> (b)")
    void createRelationSonOf(String startName,String endName);

    @Query("MATCH (a:Person),(b:Person) WHERE a.name = $startName AND b.name = $endName CREATE (a)-[r:daughterOf] -> (b)")
    void createRelationDaughterOf(String startName,String endName);

}


