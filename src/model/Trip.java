package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Trip
{
	private final Map<UUID, Booking> bookings = new HashMap<>();
	
	private final StringProperty tripName;
	private final StringProperty organizerName;
	private TripOrganizer organizer;
	private Boolean residential;
	private Double entranceFee;
	private Double transportFee;
	private Double venueFee;
	private Double miscCosts;
	private final ObservableList<Booking> bookingData = FXCollections.observableArrayList();
	
	public Trip()
	{
		this(null, null);
	}
	
	public Trip(final String tripName, final String organizerName)
	{
		this.tripName = new SimpleStringProperty(tripName);
		this.organizerName = new SimpleStringProperty(organizerName);
	}
	
	public void addBooking(final Booking booking)
	{
		this.bookings.put(booking.getStudent().getId(), booking);
	}
	
	public String getTripName()
	{
		return this.tripName.get();
	}

	/**
	 * @return the tripName
	 */
	public StringProperty getTripNameProperty()
	{
		return tripName;
	}

	/**
	 * @param tripName the tripName to set
	 */
	public void setTripName(final String tripName)
	{
		this.tripName.set(tripName);
	}
	
	public String getOrganizerName()
	{
		return this.organizerName.get();
	}

	/**
	 * @return the organizerName
	 */
	public StringProperty getOrganizerNameProperty()
	{
		return organizerName;
	}

	public void setOrganizer(final TripOrganizer organizer)
	{
		this.organizer = organizer;
		this.organizerName.set(this.organizer.toString());
	}
	
	public Boolean getResidential()
	{
		return this.residential;
	}

	/**
	 * @return the residential
	 */
	public StringProperty getResidentialProperty()
	{
		return new SimpleStringProperty(this.residential.toString());
	}

	/**
	 * @param residential the residential to set
	 */
	public void setResidential(final Boolean residential)
	{
		this.residential = residential;
	}

	/**
	 * @return the entranceFee
	 */
	public String getEntranceFee()
	{
		return String.valueOf(entranceFee);
	}

	/**
	 * @param entranceFee the entranceFee to set
	 */
	public void setEntranceFee(final Double entranceFee)
	{
		this.entranceFee = entranceFee;
	}

	/**
	 * @return the transportCost
	 */
	public String getTransportFee()
	{
		return String.valueOf(transportFee);
	}

	/**
	 * @param transportFee the transportCost to set
	 */
	public void setTransportFee(final Double transportFee)
	{
		this.transportFee = transportFee;
	}

	/**
	 * @return the venueCost
	 */
	public String getVenueFee()
	{
		return String.valueOf(venueFee);
	}

	/**
	 * @param venueFee the venueFee to set
	 */
	public void setVenueFee(final Double venueFee)
	{
		this.venueFee = venueFee;
	}

	/**
	 * @return the miscCosts
	 */
	public String getMiscCosts()
	{
		return String.valueOf(miscCosts);
	}

	/**
	 * @param miscCosts the miscCosts to set
	 */
	public void setMiscCosts(final Double miscCosts)
	{
		this.miscCosts = miscCosts;
	}

	public String getTotalCost()
	{
		return String.valueOf(entranceFee + transportFee + venueFee + miscCosts);
	}

	public ObservableList<Booking> getBookingData()
	{
		return this.bookingData;
	}
	
	@Override
	public String toString()
	{
		return this.getTripName();
	}
}