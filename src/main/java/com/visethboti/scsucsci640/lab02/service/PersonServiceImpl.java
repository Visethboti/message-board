package com.visethboti.scsucsci640.lab02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visethboti.scsucsci640.lab02.dao.PersonDAO;
import com.visethboti.scsucsci640.lab02.entity.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;
	
	@Autowired
	public PersonServiceImpl(PersonDAO thePersonDAO) {
		this.personDAO = thePersonDAO;
	}
	
	@Override
	@Transactional
	public List<Person> findAll() {
		return personDAO.findAll();
	}

	@Override
	@Transactional
	public Person findById(int theId) {
		return personDAO.findById(theId);
	}

	@Override
	@Transactional
	public void save(Person thePerson) {
		personDAO.save(thePerson);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		personDAO.deleteById(theId);
	}

}
