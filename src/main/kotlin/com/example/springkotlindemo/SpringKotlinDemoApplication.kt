package com.example.springkotlindemo

import com.example.springkotlindemo.modal.Person
import com.example.springkotlindemo.repository.PersonRepository
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinDemoApplication : CommandLineRunner {

	private val log = LoggerFactory.getLogger(SpringKotlinDemoApplication::class.java)

	@Autowired
	private lateinit var personRepository: PersonRepository

	override fun run(vararg args: String?) {
		log.info("run")
		val person1 = Person(1, "Ahmad", "ahmad@gmail.com", 25)
		personRepository.save(person1)
		for(person in personRepository.findAll()) println(person.email)
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(SpringKotlinDemoApplication::class.java, *args)
}
