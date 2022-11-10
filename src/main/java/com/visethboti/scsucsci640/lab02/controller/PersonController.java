package com.visethboti.scsucsci640.lab02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visethboti.scsucsci640.lab02.entity.Person;
import com.visethboti.scsucsci640.lab02.service.PersonService;

@Controller
@RequestMapping("/persons")
public class PersonController{
	
	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService thePersonService) {
		personService = thePersonService;
	}
	
	@GetMapping("/list")
	public String listPersons(Model theModel) {
		// get all persons
		List<Person> persons = personService.findAll();
		
		// add to the Spring MVC model
		theModel.addAttribute("persons", persons);
		
		return "list-persons";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		// create model attribute to bind form data
		
		Person thePerson = new Person();
		
		theModel.addAttribute("person", thePerson);
		
		return "person-form.html";
	}
	
	@PostMapping("/save")
	public String savePerson(@ModelAttribute("person") Person thePerson) {
		// save person
		personService.save(thePerson);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/persons/list";
	}
}
