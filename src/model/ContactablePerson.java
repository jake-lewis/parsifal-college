package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class ContactablePerson extends Person
{
	private final StringProperty mobile;
	
	public ContactablePerson()
	{
		this(null, null, null);
	}
	
	public ContactablePerson(final String forename, final String surname, final String mobile)
	{
		super(forename, surname);
		this.mobile = new SimpleStringProperty(mobile);
	}
	
	public String getMobile()
	{
		return this.mobile.get();
	}

	public StringProperty getMobileProperty()
	{
		return this.mobile;
	}
	
	public void setMobile(final String mobile)
	{
		this.mobile.set(mobile);
	}
}
