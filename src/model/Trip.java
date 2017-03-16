package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Trip
{
	private final Map<UUID, Booking> bookings = new HashMap<>();
	
	public void addBooking(final Booking booking)
	{
		this.bookings.put(booking.getStudent().getId(), booking);
	}
}