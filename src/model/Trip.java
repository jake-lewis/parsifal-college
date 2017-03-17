package model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Trip
{
	private final Map<UUID, Booking> bookings = new HashMap<>();
	
	private StringProperty tripName;
	private StringProperty organizerName;
	private Boolean residential;
	private Double entranceFee;
	private Double transportFee;
	private Double venueFee;
	private Double miscCosts;
	
	public void addBooking(final Booking booking)
	{
		this.bookings.put(booking.getStudent().getId(), booking);
	}
	
	public String getTripName()
	{
		return this.getTripNameProperty().get();
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
		this.tripName = new SimpleStringProperty();
	}
	
	public String getOrganizerName()
	{
		return this.getOrganizerNameProperty().get();
	}

	/**
	 * @return the organizerName
	 */
	public StringProperty getOrganizerNameProperty()
	{
		return organizerName;
	}

	/**
	 * @param organizerName the organizerName to set
	 */
	public void setOrganizerName(final StringProperty organizerName)
	{
		this.organizerName = organizerName;
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

	
}