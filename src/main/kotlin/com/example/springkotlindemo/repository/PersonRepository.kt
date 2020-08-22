package com.example.springkotlindemo.repository

import com.example.springkotlindemo.modal.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Int>