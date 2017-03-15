package factories;

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
}
