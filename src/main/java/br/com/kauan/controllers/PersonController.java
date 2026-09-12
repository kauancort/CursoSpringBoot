package br.com.kauan.controllers;

import br.com.kauan.model.Person;
import br.com.kauan.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;
        // -> sem injeção de dependencia e sem o @Service, precisamos usar o new PersonService
        //Com o spring, temos o @Autowired

    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") String id) {

        return service.findById(id);
    }

    @GetMapping()
    public List<Person> findAll() {
        return service.findAll();
    }

    @PostMapping
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
