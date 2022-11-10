package com.visethboti.scsucsci640.lab02.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	// define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personID")
	private int personID;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="message")
	private String message;
		
	// define constructor
	public Person() {
		
	}
	
	public Person(int personID, String firstName, String lastName, String message) {
		super();
		this.personID = personID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
	}



	public Person(String firstName, String lastName, String message) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.message = message;
	}

	
	// define getter and setter
	public int getPersonID() {
		return personID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Person [personID=" + personID + ", firstName=" + firstName + ", lastName=" + lastName + ", message="
				+ message + "]";
	}
	
	
}
