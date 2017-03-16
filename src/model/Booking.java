package model;

public class Booking
{
	private final Student student;
	private boolean paid;
	private boolean authorized;
	
	public Booking(final Student student)
	{
		this.student = student;
		this.paid = false;
		this.authorized = false;
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
}
