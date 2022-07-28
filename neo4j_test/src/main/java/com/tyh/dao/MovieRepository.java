package com.tyh.dao;

import com.tyh.entity.Movie;
import com.tyh.entity.RelationEntity;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

    @Query("CREATE (n:Movie {title:$title, released:$released, tagline:$tagline})")
    void createMovie(String title, Integer released, String tagline);

    @Query("MATCH (n:Movie) where n.name=$title RETURN n")
    Movie findByName(String title);

    //@Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a")
    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a")
    List<Movie> graph();

    @Query("MATCH p=(m)<-[r:ACTED_IN]->(n) RETURN  COLLECT(r) AS links,COLLECT(p) as nodes")
    List<RelationEntity> getRelatedNodes();

    @Query("MATCH (u)<-[r]-(m) RETURN u.id,m.id")
    List<Map<Long,Long>> getAllRelationId();

}

