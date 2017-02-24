package model;

public class Student extends Person
{
	private String mobile;
	
	public Student(String mobile, String forename, String surname)
	{
		super(forename, surname);
		this.mobile = mobile;
	}
	
	public String getMobile()
	{
		return this.mobile;
	}
}