package model;

import java.util.UUID;

public abstract class Person
{
	//Generate unique ID
	private UUID id = UUID.randomUUID();
	private String forename;
	private String surname;
	
	public Person(String forename, String surname)
	{
		this.forename = forename;
		this.surname = surname;
	}
	
	public UUID getId()
	{
		return id;
	}
	
	public String getForename()
	{
		return forename;
	}
	
	public String getSurname()
	{
		return surname;
	}
}
