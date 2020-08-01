package com.example.springkotlindemo.service

import com.example.springkotlindemo.modal.Person
import com.example.springkotlindemo.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService(@Autowired var personRepository: PersonRepository) {

    fun save(person: Person) {
        personRepository.save(person)
    }

    fun findById(id:Int):Person {
        return personRepository.findById(id).get()
    }

    fun getAllPersons():List<Person> {
        return personRepository.findAll()
    }
}