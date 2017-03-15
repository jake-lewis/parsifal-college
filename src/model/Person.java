package model;

import java.util.UUID;

public abstract class Person
{
	//Generate unique ID
	private final UUID id = UUID.randomUUID();
	private final String forename;
	private final String surname;
	
	public Person(final String forename, final String surname)
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
	
	@Override 
	public int hashCode()
	{
		return (this.forename + this.surname).hashCode();
	}
}
