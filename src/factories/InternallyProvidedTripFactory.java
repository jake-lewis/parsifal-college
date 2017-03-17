package factories;

import model.Trip;

public class InternallyProvidedTripFactory extends TripFactory
{
	private static InternallyProvidedTripFactory INSTANCE;
	
	static InternallyProvidedTripFactory getInstance()
	{
		if (null == INSTANCE)
		{
			INSTANCE = new InternallyProvidedTripFactory();
		}

		return INSTANCE;
	}

	@Override
	public Trip getTrip()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
