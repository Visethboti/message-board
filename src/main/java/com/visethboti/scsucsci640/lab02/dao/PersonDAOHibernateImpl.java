package com.visethboti.scsucsci640.lab02.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.visethboti.scsucsci640.lab02.entity.Person;

@Repository
public class PersonDAOHibernateImpl implements PersonDAO {

	// define field for entitymanager
	
		private EntityManager entityManager;
		
		// set up constructor injection
		
		@Autowired
		public PersonDAOHibernateImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		@Override
		public List<Person> findAll() {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// create a query
			Query<Person> theQuery =
					currentSession.createQuery("from Person", Person.class);
			
			// execute query and get result list
			List<Person> users = theQuery.getResultList();
			
			// return the results
			return users;
		}

		@Override
		public Person findById(int theId) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// get the person
			Person thePerson = currentSession.get(Person.class, theId);
			
			// return the person
			return thePerson;
		}

		@Override
		public void save(Person thePerson) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// save person
			currentSession.saveOrUpdate(thePerson); // if id=0 then save/insert, else update
		}

		@Override
		public void deleteById(int theId) {
			// get the current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
			
			// delete object with primary key
			Query theQuery =currentSession.createQuery("delete from Person where id=:personID");
			theQuery.setParameter("personID", theId);
			
			theQuery.executeUpdate();
			
		}
}
