/*
	Program: Create one to many relationship one Teacher and their Courses. A teacher name Mrunali can give multiple
		     courses like java programming,python programming,Anuglar programming but a course is given by only one teacher.
	Author: Rajshree Gaikwad
	Date:22nd Dec 2022	


*/

//declaring packages

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
//declaring class
public class Teacher 
{
	//declaring varriables
	@Id
	private int T_Id;
	private String T_name;
	//constructor
	public Teacher() 
	{
		
	}
	//use getter setter method
	
	public int getT_Id() {
		return T_Id;
	}
	public void setT_Id(int t_Id) {
		T_Id = t_Id;
	}
	public String getT_name() {
		return T_name;
	}
	public void setT_name(String t_name) {
		T_name = t_name;
	}
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	@OneToMany(cascade=CascadeType.ALL)
	List<Course>course;
	
	

}   //end of class





package com.example;

//declaring packages
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Courses")

//declaring class
public class Course
{
	//declaring varriables
	@Id
	private int C_Id;
	private String C_Name;
	//constructor
	public Course() 
	{
		
	}
	//using getter setter method
	public int getC_Id() {
		return C_Id;
	}
	public void setC_Id(int c_Id) {
		C_Id = c_Id;
	}
	public String getC_Name() {
		return C_Name;
	}
	public void setC_Name(String c_Name) {
		C_Name = c_Name;
	}
	
	
	

} // end of class






package com.example;

//declaring packages
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

//declaring class
public class App 
{
	//calling main method
    public static void main( String[] args )
    {
		//using configuration method
    	Configuration con=new Configuration().configure().addAnnotatedClass(Teacher.class);
    	Configuration con1=new Configuration().configure().addAnnotatedClass(Course.class);
    	
		
		//using sessionfactory
    	SessionFactory sf=con.buildSessionFactory();
    	Session ss=sf.openSession();
    	Transaction T=ss.beginTransaction(); //using transaction method
    	
    	//creating object of class Teacher and put the value
    	Teacher t1=new Teacher();
    	t1.setT_Id(201);
    	t1.setT_name("Mrunali");
    	
		//creating object of class Course and put the value
    	Course c1=new Course();
    	c1.setC_Id(1);
    	c1.setC_Name("Java Programming");
    	
		//creating object of class course and put the value
    	Course c2=new Course();
    	c2.setC_Id(2);
    	c2.setC_Name("Python");
    	
		//creating object of class course and put the value
    	Course c3=new Course();
    	c3.setC_Id(3);
    	c3.setC_Name("Angular");
    	
    	//adding arrayList
    	List<Course> courses=new ArrayList<>();
    	courses.add(c1);
    	courses.add(c2);
    	courses.add(c3);
    	t1.setCourse(courses);
    	
    	ss.persist(t1);
    	
    	T.commit();
    	ss.close();
    	
    	
    }   //end of main method
}  //end of class
