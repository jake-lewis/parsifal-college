package model;

public class Booking
{
	private Student student;
	private boolean paid;
	private boolean authorized;
	
	public Booking(Student student)
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
	
	public void setPaid(boolean paid)
	{
		this.paid = paid;
	}
	
	public boolean isAuthorized()
	{
		return this.authorized;
	}
	
	public void setAuthorized(boolean authorized)
	{
		this.authorized = authorized;
	}
}
