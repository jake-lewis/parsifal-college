package factories;

import model.Trip;

public class ExternallyProvidedTripFactory implements TripProvider
{
	private static ExternallyProvidedTripFactory INSTANCE;
	
	static TripProvider getInstance()
	{
		if (null == INSTANCE)
		{
			INSTANCE = new ExternallyProvidedTripFactory();
		}

		return INSTANCE;
	}

	@Override
	public Trip getTrip(boolean residential) {
		// TODO Auto-generated method stub
		return null;
	}
}