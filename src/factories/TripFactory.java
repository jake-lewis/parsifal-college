package factories;

import model.ExternalProvider;
import model.Teacher;
import model.TripOrganizer;

public abstract class TripFactory implements TripProvider
{
	
	
	static final TripFactory getFactory(final TripOrganizer organiser)
	{
		if (organiser instanceof Teacher)
		{
			return InternallyProvidedTripFactory.getInstance();
		}
		else if (organiser instanceof ExternalProvider)
		{
			return ExternallyProvidedTripFactory.getInstance();
		}
		else
		{
			throw new IllegalArgumentException("The TripOrganiser passed into the TripFactory was not recognised");
		}
	}
}
