package model;

public class Student extends Person
{
	private final String mobile;

	public Student(final String mobile, final String forename, final String surname)
	{
		super(forename, surname);
		this.mobile = mobile;
	}

	public String getMobile()
	{
		return this.mobile;
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