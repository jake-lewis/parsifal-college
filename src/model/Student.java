package model;

public class Student extends ContactablePerson
{
	public Student()
	{
		this(null, null, null);
	}
	
	public Student(final String forename, final String surname, final String mobile)
	{
		super(forename, surname, mobile);
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