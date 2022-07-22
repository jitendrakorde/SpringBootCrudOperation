package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person Person)
	{
		return personService.createPerson(Person);
	}
	
	@PostMapping("/addPersons")
	public List<Person> addPerson(@RequestBody List<Person> Persons)
	{
		return personService.createPersons(Persons);
	}
	
	@GetMapping("/Person/{id}")
	public Person getPersonById(@PathVariable int id)
	{
		return personService.getPersonById(id);
	}
	
	@GetMapping("/Persons")
	public List<Person> getAllPersons()
	{
		return personService.getPersons();
	}
	
	@PutMapping("/udatePerson")
	public Person udatePerson(@RequestBody Person Person)
	{
		return personService.updatePerson(Person);
	}
	
	@DeleteMapping("/Person/{id}")
	public String deletePerson(@PathVariable int id)
	{
		return personService.deletePersonById(id);
	}
	

}
