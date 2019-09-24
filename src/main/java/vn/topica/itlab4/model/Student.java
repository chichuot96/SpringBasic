package vn.topica.itlab4.model;

import java.sql.Date;


public class Student {
	public String id;
	public String name;
	public Date dateOfBirth;
	public Gender gender;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth =Date.valueOf(dateOfBirth);
	}
	public void setGender(String gender) {
		switch(gender.toLowerCase()) {
		case "male": this.gender=Gender.Male; break;
		case "female": this.gender=Gender.Female; break;
		default: this.gender=Gender.Other; break;
		}
	}
	public String getGender() {
		return gender.toString();
	}

	public Student(String id, String name, Date dateOfBirth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		switch(gender.toLowerCase()) {
		case "male": this.gender=Gender.Male; break;
		case "female": this.gender=Gender.Female; break;
		default: this.gender=Gender.Other; break;
		}

	}
	public Student(String id, String name, String dateOfBirth, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = Date.valueOf(dateOfBirth);
		switch(gender.toLowerCase()) {
		case "male": this.gender=Gender.Male; break;
		case "female": this.gender=Gender.Female; break;
		default: this.gender=Gender.Other; break;
		}

	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender.toString() + "]";
	}
	
	
}
