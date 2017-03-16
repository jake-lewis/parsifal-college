package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student extends Person
{
	private final StringProperty mobile;

	public Student(final String mobile, final String forename, final String surname)
	{
		super(forename, surname);
		this.mobile = new SimpleStringProperty(mobile);
	}

	public Student()
	{
		this(null, null, null);
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
	
	@Override
	public boolean equals(final Object o)
	{
		if (o instanceof Student)
		{
			final Student object = ((Student) o);
			return (object.getForename().equals(this.getForename())) && (object.getSurname().equals(this.getSurname()));
		}

		return false;
	}
}