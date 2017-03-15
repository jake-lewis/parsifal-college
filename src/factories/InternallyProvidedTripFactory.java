package factories;

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
}
