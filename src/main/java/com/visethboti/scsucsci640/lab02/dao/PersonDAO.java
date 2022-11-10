package com.visethboti.scsucsci640.lab02.dao;

import java.util.List;

import com.visethboti.scsucsci640.lab02.entity.Person;

public interface PersonDAO {
	public List<Person> findAll();
	public Person findById(int theId);
	public void save(Person thePerson);
	public void deleteById(int theId);
}
