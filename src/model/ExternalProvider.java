package model;

public class ExternalProvider extends ContactablePerson implements TripOrganizer
{
	public ExternalProvider()
	{
		this(null, null, null);
	}
	
	public ExternalProvider(final String forename, final String surname, final String mobile)
	{
		super(forename, surname, mobile);
	}
}
