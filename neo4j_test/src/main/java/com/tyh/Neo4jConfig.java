package com.tyh;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: neo4j-rest
 * @Package: nk.gk.wyl.config
 * @ClassName: Neo4jConfig
 * @Author: zsl
 * @Description: neo4j 配置类
 * @Date: 2021/9/13 22:43
 * @Version: 1.0
 */
@Configuration
public class Neo4jConfig {


    private Session session;

    public void setSession() {
        this.session = create();
    }

    @Value("${spring.neo4j.uri}")
    private String uri;

    @Value("${spring.neo4j.authentication.username}")
    private String username;


    @Value("${spring.neo4j.authentication.password}")
    private String password;

    /**
     * 实例化自己的实现类
     * @return
     */
    @Bean("Neu4jSession")
    public Session getSession(){
        return create();
    }

    public Session create(){
        Driver driver = GraphDatabase.driver( uri, AuthTokens.basic( username, password ) );
        Session session = driver.session();
        return session;
    }
}
