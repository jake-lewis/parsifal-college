package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Trip
{
	private final Map<UUID, Booking> bookings = new HashMap<>();
	
	private String tripName;
	private String organizerName;
	private Boolean residential;
	private Integer entranceFee;
	private Integer transportCost;
	private Integer venueCost;
	private Integer miscCosts;
	
	public void addBooking(final Booking booking)
	{
		this.bookings.put(booking.getStudent().getId(), booking);
	}
}