package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonRepository;
import com.example.demo.entity.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(Person person)
	{
		return personRepository.save(person);
	}
	
	public List<Person> createPersons(List<Person> persons)
	{
		return personRepository.saveAll(persons);
	}
	
	public Person getPersonById(int id)
	{
		return personRepository.findById(id).orElse(null);
	}
	
	public List<Person> getPersons()
	{
		return personRepository.findAll();
	}
	
	public Person updatePerson(Person person)
	{
		Person oldPerson = null;
		Optional<Person> optionalPerson =  personRepository.findById(person.getId());
		if(optionalPerson.isPresent())
		{
			oldPerson = optionalPerson.get();
			oldPerson.setName(person.getName());
			oldPerson.setAddress(person.getAddress());
			personRepository.save(oldPerson);
		}
		else
		{
			return new Person();
		}
		return oldPerson;
	}
	
	public String deletePersonById(int id)
	{
		personRepository.deleteById(id);
		return "Person got deleted.";
	}

}
