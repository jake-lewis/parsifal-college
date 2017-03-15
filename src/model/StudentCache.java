package model;

import java.util.ArrayList;
import java.util.List;

public class StudentCache
{
	List<Student> students = new ArrayList<>();
	
	public void addStudent(final Student student)
	{
		this.students.add(student);
	}
	
	public List<Student> getStudents()
	{
		return this.students;
	}
}