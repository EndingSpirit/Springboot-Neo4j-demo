package com.tyh.runner;


import com.tyh.dao.MovieRepository;
import com.tyh.dao.PersonRepository;
import com.tyh.entity.Person;
import com.tyh.service.GraphServices;
import com.tyh.utils.FormatConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;


/* CRUD操作
*/

@Component
public class DemoCommandRunner {
    @Bean
    CommandLineRunner personRunner(PersonRepository personRepository) {
        return args -> {

//            personRepository.deleteAll();
//            personRepository.createPerson("Carrie-Anne Moss","1967");
//            personRepository.createPerson("Keanu Reeves","1964");
//            personRepository.createPerson("Laurence Fishburne","1961");
//            personRepository.createPerson("Hugo Weaving","1960");
//            personRepository.createPerson("Lilly Wachowski","1967");
//            personRepository.createPerson("Lana Wachowski","1965");
//            personRepository.createPerson("Joel Silverstein","1952");

            //personRepository.createRelationActedIn("Carrie-Anne Moss","The Matrix","Neo");


//            System.out.println("Number of Person Counts : " + personRepository.count());
//
//            System.out.println(personRepository.findPersonByName(daddy.getName()));
//
//            System.out.println(personRepository.findAll());

//            personRepository.createRelationSonOf(daddy.getName(),grandpa.getName());
//
//            personRepository.createRelationDaughterOf(mommy.getName(),maternalGrandpa.getName());
//
//            personRepository.createRelationDaughterOf(daughter.getName(),daddy.getName());

        };
    }

    @Autowired
    private GraphServices graphServices;

    @Bean
    CommandLineRunner movieRunner(MovieRepository movieRepository) {



        return args -> {
            //movieRepository.deleteAll();
            //System.out.println(FormatConv.toFormat(movieRepository.graph()));
            //System.out.println(FormatConv.toFormat(movieRepository.getRelatedNodes()));
            System.out.println("111111");
            System.out.println(graphServices.deal());
//            movieRepository.getRelatedNodes();
//           movieRepository.getRelatedNodes();
        };
    }
}
