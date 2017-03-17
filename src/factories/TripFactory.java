package factories;

import model.Trip;

public class TripFactory
{
	private static TripFactory INSTANCE;
	
	private TripFactory() {}
	
	static TripFactory getInstance()
	{
		if (null == INSTANCE)
		{
			INSTANCE = new TripFactory();
		}

		return INSTANCE;
	}

	public Trip getTrip()
	{
		return new Trip();
	}
}
