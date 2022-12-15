package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
		private int E_id;
		private String E_name;
		private String E_dept;
		private int E_salary;
		private Employee_Address Address; 
		
		
		public Employee() 
		{
			
		}
		public int getE_id() {
			return E_id;
		}
		public void setE_id(int e_id) {
			E_id = e_id;
		}
		public String getE_name() {
			return E_name;
		}
		public void setE_name(String e_name) {
			E_name = e_name;
		}
		public String getE_dept() {
			return E_dept;
		}
		public void setE_dept(String e_dept) {
			E_dept = e_dept;
		}
		public int getE_salary() {
			return E_salary;
		}
		public void setE_salary(int e_salary) {
			E_salary = e_salary;
		}
		public Employee_Address getAddress() {
			return Address;
		}
		public void setAddress(Employee_Address address) {
			Address = address;
		}

}
