package com.example;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static String addEmployee(Session s,Transaction t)
	{
		Scanner sc1=new Scanner(System.in);
		System.out.println("Enter Employee id");
		int E_Id=sc1.nextInt();
		Scanner sc2 =new Scanner(System.in);
		System.out.println("Enter Employee name");
		String E_name=sc2.nextLine();
		Scanner sc3=new Scanner(System.in);
		System.out.println("Enter Employee department");
		String E_dept=sc3.nextLine();
		Scanner sc4 = new Scanner(System.in);
		System.out.println("Enter Employee salary");
		int E_salary=sc4.nextInt();
		Scanner sc5 = new Scanner(System.in);
		System.out.println("Enter House name");
		String hname=sc5.nextLine();
		Scanner sc6= new Scanner(System.in);
		System.out.println("Enter Area");
		String area=sc6.nextLine();
		Scanner sc7= new Scanner(System.in);
		System.out.println("Enter city");
		String city=sc7.nextLine();
		Scanner sc8= new Scanner(System.in);
		System.out.println("Enter pincode");
		int pincode=sc8.nextInt();
		
		Employee_Address ad1=new Employee_Address();
		
		ad1.setHname(hname);
		ad1.setArea(area);
		ad1.setCity(city);
		ad1.setPincode(pincode);
		
		Employee ss=new Employee();
		ss.setE_id(E_Id);
		ss.setE_name(E_name);
		ss.setE_dept(E_dept);
		ss.setE_salary(E_salary);
		ss.setAddress(ad1);
		
		s.save(ss);
		t.commit();
		
		Query query= s.createQuery("from Employee");
		List<Employee>employee = query.list();
		
		for(Employee e:employee)
		{
			System.out.println("Employee Id:"+e.getE_id()+" "+"Employee Name"+e.getE_name()+" "+"Employee Department"+e.getE_dept()+" "+"Employee Salary"+e.getE_salary());
		}
		s.close();
		 return "Employee is added";
		
	}
    public static void main( String[] args )
    {
    	 Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
	      SessionFactory sf=con.buildSessionFactory();
	     Session ss=sf.openSession(); 
	    Transaction T=ss.beginTransaction();
	   System.out.println(addEmployee(ss,T));


	
	}
}
