package factories;

import model.Trip;

public class ExternallyProvidedTripFactory extends TripFactory
{
	private static ExternallyProvidedTripFactory INSTANCE;
	
	static ExternallyProvidedTripFactory getInstance()
	{
		if (null == INSTANCE)
		{
			INSTANCE = new ExternallyProvidedTripFactory();
		}

		return INSTANCE;
	}

	@Override
	public Trip getTrip()
	{
		return new Trip();
	}
}
