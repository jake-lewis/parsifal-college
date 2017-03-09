package factories;

import model.ExternalProvider;
import model.Teacher;
import model.TripOrganizer;

public class TripFactory
{
	static final TripProvider getTripFactory(TripOrganizer organiser)
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