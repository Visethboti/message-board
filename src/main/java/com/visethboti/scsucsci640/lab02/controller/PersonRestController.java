package com.visethboti.scsucsci640.lab02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.visethboti.scsucsci640.lab02.entity.Person;
import com.visethboti.scsucsci640.lab02.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonRestController {
	
	private PersonService personService;
	
	@Autowired
	public PersonRestController(PersonService thePersonService) {
		personService = thePersonService;
	}
	
	//  GET	/api/persons	Read a list of persons
	@GetMapping("/persons")
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	// add mapping for GET /api/persons/{personId}	Read a single person
	@GetMapping("/persons/{personId}")
	public Person getPerson(@PathVariable int personId) {
		Person thePerson = personService.findById(personId);
		
		if(thePerson == null) {
			throw new RuntimeException("Person id not found - " + personId);
		}
		
		return thePerson;
	}
	
	// add mapping for POST /api/persons	add a new person
	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person thePerson) {
		// just in case they pas an id in JSON ... set id to 0
		// this is to force a save of a new item instead of update
		thePerson.setPersonID(0);
		
		personService.save(thePerson);
		
		return thePerson;
	}
	
	// add mapping for PUT	/api/persons Update an existing person
	@PutMapping("/persons")
	public Person updatePerson(@RequestBody Person thePerson) {
		personService.save(thePerson);
		
		return thePerson;
	}
	
	// add mapping for DELETE	/api/employees/{personId}	Delete an existing person
	@DeleteMapping("/persons/{personId}")
	public String deletePerson(@PathVariable int personId){
		Person thePerson = personService.findById(personId);
		
		if(thePerson == null) {
			throw new RuntimeException("Person id not found - " + personId);
		}
		
		personService.deleteById(personId);
		
		return "Deleted person id - " + personId;
		
	}
}
