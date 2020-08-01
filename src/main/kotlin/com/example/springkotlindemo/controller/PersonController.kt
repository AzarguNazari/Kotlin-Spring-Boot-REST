package com.example.springkotlindemo.controller

import com.example.springkotlindemo.modal.Person
import com.example.springkotlindemo.repository.PersonRepository
import com.example.springkotlindemo.service.PersonService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class PersonController(private val personService: PersonService, private val personRepository: PersonRepository){

    @GetMapping("/persons/{id}")
    fun getPerson(@PathVariable("id") id: Int): ResponseEntity<Person> {
        val person: Person? = personService.findById(id)
        return ResponseEntity(person as Person, HttpStatus.OK);
    }

    @GetMapping("/persons")
    fun getAllCricketers() :ResponseEntity<List<Person>>  {
        println("Hit it")
        var personsList: ArrayList<Person> =  personService.getAllPersons() as (ArrayList<Person>)
        return ResponseEntity(personsList, HttpStatus.OK)
    }

    @PostMapping("/persons")
    fun addPerson(@RequestBody person: Person):ResponseEntity<Person>  {
        val tempPerson : Person = Person(firstname = person.firstname, email = person.email, age = person.age)
        personRepository.save(tempPerson)
        return ResponseEntity(person, HttpStatus.OK)
    }

    @PutMapping("/persons/{id}")
    fun updatePerson(@PathVariable("id") id: Int, @RequestBody person: Person ):ResponseEntity<Person> {
        val tempPerson : Person = Person(firstname = person.firstname
                , email = person.email
                , age = person.age)
        personRepository.save(tempPerson)
        return ResponseEntity(person, HttpStatus.OK)
    }

    @DeleteMapping("/person/{id}")
    fun deletePerson(@PathVariable("id") id: Int):ResponseEntity<String> {
        val tempPerson :Person  = personService.findById(id) as Person
        personRepository.delete(tempPerson)
        return ResponseEntity("person with id $id is removed", HttpStatus.OK)
    }
}