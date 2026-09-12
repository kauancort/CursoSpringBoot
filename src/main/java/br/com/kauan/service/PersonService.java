package br.com.kauan.service;


import br.com.kauan.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {

        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Kauan");
        person.setLastName("Cortiço");
        person.setAddress("Tupã-SP");
        person.setGender("M");
        return person;
    }

    //retornando uma lista:

    public List<Person> findAll() {
        logger.info("finding all people!");
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            Person person = mockPerson(i);
            people.add(person);
        }

        return people;
    }

    //metodo POST:

    public Person create(Person person) {
        logger.info("create one person!");
        return person;
    }

    public Person update(Person person) {

        logger.info("Updating one person!");

        return person;
    }

    public void delete(String id) {

        logger.info("Deleting one person");

        
    }



    private Person mockPerson(int i) {

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("FirstName" + i);
        person.setLastName("Cortiço" + i);
        person.setAddress("Tupã-SP" + i);
        person.setGender("M" + i);
        return person;

    }
}
