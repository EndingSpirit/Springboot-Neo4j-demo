package com.tyh.service;

import com.tyh.entity.RelationEntity;
import com.tyh.utils.FormatConv;
import com.tyh.dao.MovieRepository;
import com.tyh.dao.PersonRepository;
import com.tyh.entity.Movie;
import com.tyh.entity.Person;
import org.neo4j.driver.Record;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GraphServices {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private Session session;


    public List<Map<Long,Long>> getAllRelationId() {
        return movieRepository.getAllRelationId();
    }

    public Map<String, Object> graph(){
        List<Movie> all = movieRepository.findAll();
        return FormatConv.toD3Format(all);
    }

    public List<Person> getAllPerson(){
        return personRepository.findAll();
    }

    public List<Movie> getAllMovie(){
        return movieRepository.findAll();
    }

    public Movie getMovieByName(String name) {
        return movieRepository.findByName(name);
    }

    public Map<String, Object> getRelatedNodes() {
        //return FormatConv.toFormat(movieRepository.getRelatedNodes());
        return new HashMap<>();
    }


    public Map<String, List<Map>> deal(){
        String sql = "MATCH p=(m)<-[r:ACTED_IN]->(n) RETURN  COLLECT(r) AS links,COLLECT(p) as nodes";
        Result statementResult = session.run(sql);
        // 定义 返回值  对象map key  relation  value  关系，key node value 节点数据
        Map<String, List<Map>> result = new HashMap<>();
        // 节点集合
        List<Map> nodes = new ArrayList<>();
        // 定义节点【用来去重】
        Map<Long, String> node_map = new HashMap<>();
        // 关系集合
        List<Map> relations = new ArrayList<>();
        while (statementResult.hasNext()) {
            Record record = statementResult.next();
            // 定义一个新的map 对象
            Map<String, Object> map = new HashMap<>();
            // 将数据put 进来
            map.putAll(record.asMap());
            List<Map> relatedNodes = (List<Map>) map.get("nodes");

            List<Map> resourceNodeRelations = (List<Map>) map.get("links");
            result.put("nodes", relatedNodes);
            result.put("links", resourceNodeRelations);
            System.out.println(1111);
        }
        return result;
    }

}
