package model;

public class Teacher extends Person implements TripOrganizer
{
	public Teacher(final String forename, final String surname)
	{
		super(forename, surname);
	}
	
	public Teacher()
	{
		this(null, null);
	}

	@Override
	public boolean equals(final Object o)
	{
		if (o instanceof Teacher)
		{
			final Teacher object = ((Teacher)o);
			return (object.getForename().equals(this.getForename())) && (object.getSurname().equals(this.getSurname())) ;
		}

		return false;
	}
}
