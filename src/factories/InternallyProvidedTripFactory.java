package factories;

import model.Trip;

public class InternallyProvidedTripFactory implements TripProvider
{
	private static TripProvider INSTANCE;
	
	static TripProvider getInstance()
	{
		if (null == INSTANCE)
		{
			INSTANCE = new InternallyProvidedTripFactory();
		}

		return INSTANCE;
	}

	@Override
	public Trip getTrip(boolean residential) {
		// TODO Auto-generated method stub
		return null;
	}
}