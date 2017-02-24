package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Trip
{
	private Map<UUID, Booking> bookings = new HashMap<>();
	
	public void addBooking(Booking booking)
	{
		this.bookings.put(booking.getStudent().getId(), booking);
	}
}