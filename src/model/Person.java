package model;

import java.util.UUID;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Person
{
	//Generate unique ID
	private final UUID id = UUID.randomUUID();
	private final StringProperty forename;
	private final StringProperty surname;
	
	public Person()
	{
		this(null, null);
	}
	
	public Person(final String forename, final String surname)
	{
		this.forename = new SimpleStringProperty(forename);
		this.surname = new SimpleStringProperty(surname);
	}
	
	public UUID getId()
	{
		return id;
	}
	
	public String getForename()
	{
		return this.forename.get();
	}
	
	public String getSurname()
	{
		return this.surname.get();
	}
	
	public StringProperty getForenameProperty()
	{
		return forename;
	}
	
	public StringProperty getSurnameProperty()
	{
		return surname;
	}
	
	public void setForename(final String forename)
	{
		this.forename.set(forename);
	}
	
	public void setSurname(final String surname)
	{
		this.surname.set(surname);
	}
	
	@Override
	public String toString()
	{
		return this.getForename() + " " + this.getSurname();
	}
	
	@Override 
	public int hashCode()
	{
		return (this.getForename() + this.getSurname()).hashCode();
	}
}
