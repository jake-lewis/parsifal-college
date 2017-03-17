package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Booking
{
	private Student student;
	private boolean paid;
	private boolean authorized;
	
	public Booking(final Student student)
	{
		this.student = student;
		this.paid = false;
		this.authorized = false;
	}
	
	public Booking()
	{
		this(null);
	}

	public Student getStudent()
	{
		return this.student;
	}
	
	public boolean hasPaid()
	{
		return this.paid;
	}
	
	public void setPaid(final boolean paid)
	{
		this.paid = paid;
	}
	
	public boolean isAuthorized()
	{
		return this.authorized;
	}
	
	public void setAuthorized(final boolean authorized)
	{
		this.authorized = authorized;
	}

	public StringProperty getStudentNameProperty()
	{
		return new SimpleStringProperty(this.student.toString());
	}

	public void setStudent(final Student selectedItem)
	{
		this.student = selectedItem;
	}
}
